package main.com.java.studentsystem.service;
import main.com.java.studentsystem.dao.GradeDAO;
import main.com.java.studentsystem.dao.StudentDAO;
import main.com.java.studentsystem.model.Grade;
import main.com.java.studentsystem.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportService {
    private final StudentDAO studentDAO;
    private GradeDAO gradeDAO = new GradeDAO();

    public ReportService() {
        studentDAO = new StudentDAO();
    }

    public List<Map<String, Object>> generateStudentReport() {
        List<Student> students = studentDAO.findAllStudents();
        List<Grade> grades = gradeDAO.findAllGrades();

        Map<String, List<Grade>> gradesByStudent = grades.stream()
                .collect(Collectors.groupingBy(Grade::getStudentId));

        Map<String, List<Grade>> gradesByClass = grades.stream()
                .collect(Collectors.groupingBy(grade -> {
                    Student student = studentDAO.findStudentByStudentId(grade.getStudentId());
                    return student != null ? student.getStudentClass() : "Unknown";
                }));

        List<Map<String, Object>> report = new ArrayList<>();

        for (Student student : students) {
            //防重复
            Map<String, Object> studentReport = new HashMap<>();
            studentReport.put("studentId", student.getStudentId());
            studentReport.put("name", student.getName());
            studentReport.put("studentClass", student.getStudentClass());

            List<Grade> studentGrades = gradesByStudent.get(student.getStudentId());
            if (studentGrades != null) {
                double totalScore = 0;
                int count = 0;
                for (Grade grade : studentGrades) {
                    studentReport.put(grade.getSubject(), grade.getScore());
                    totalScore += grade.getScore();
                    count++;
                }
                studentReport.put("totalScore", totalScore);
                studentReport.put("averageScore", totalScore / count);
            }

            List<Grade> classGrades = gradesByClass.get(student.getStudentClass());
            if (classGrades != null) {
                Map<String, List<Grade>> gradesBySubject = classGrades.stream()
                        .collect(Collectors.groupingBy(Grade::getSubject));
                for (Map.Entry<String, List<Grade>> entry : gradesBySubject.entrySet()) {
                    String subject = entry.getKey();
                    List<Grade> subjectGrades = entry.getValue();
                    double totalSubjectScore = subjectGrades.stream()
                            .mapToDouble(Grade::getScore)
                            .sum();
                    studentReport.put(subject + "ClassAverage", totalSubjectScore / subjectGrades.size());
                }
            }

            report.add(studentReport);
        }

        // 按照总成绩平均值降序排序
        report.sort((r1, r2) -> Double.compare((double) r2.get("averageScore"), (double) r1.get("averageScore")));

        return report;
    }
}
