package main.com.java.studentsystem.model;


public class Grade {
    private int id;
    private String studentId;
    private String subject;
    private double score;

    public Grade() {}

    public Grade(String studentId, String subject, double score) {
        this.studentId = studentId;
        this.subject = subject;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "科目id=" + id +
                ", 学生学号='" + studentId + '\'' +
                ", 科目='" + subject + '\'' +
                ", 成绩=" + score
                ;
    }
}
