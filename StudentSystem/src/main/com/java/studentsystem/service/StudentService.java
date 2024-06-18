package main.com.java.studentsystem.service;



import main.com.java.studentsystem.dao.StudentDAO;
import main.com.java.studentsystem.model.Student;

import java.util.List;

public class StudentService {
    private StudentDAO studentDAO = new StudentDAO();

    public boolean addStudent(Student student) {
        return studentDAO.addStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentDAO.findAllStudents();
    }

    public Student getStudentByStudentId(String studentId) {
        return studentDAO.findStudentByStudentId(studentId);
    }

    public List<Student> getStudentsByName(String name) {
        return studentDAO.findStudentsByName(name);
    }

    public boolean updateStudent(Student student) {
        return studentDAO.updateStudent(student);
    }
}

