package main.com.java.studentsystem.model;



import java.util.Date;

public class Student {
    private int id;
    private String studentId;
    private String name;
    private String gender;
    private Date birthDate;
    private String studentClass; // 新增的班级属性

    public Student() {
    }

    public Student(String studentId, String name, String gender, Date birthDate, String studentClass) {
        this.studentId = studentId;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.studentClass = studentClass;
    }

    public Student(String studentId, String name, String gender, java.sql.Date birthDate) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    @Override
    public String toString() {
        return
                "学号='" + studentId + '\'' +
                        ",姓名='" + name + '\'' +
                        ",性别='" + gender + '\'' +
                        ", 生日=" + birthDate +
                        ", 班级='" + studentClass;

    }
}

