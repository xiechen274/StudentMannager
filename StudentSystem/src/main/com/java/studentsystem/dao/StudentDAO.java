package main.com.java.studentsystem.dao;


import main.com.java.studentsystem.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    //添加学生
    public boolean addStudent(Student student) {
        String sql = "INSERT INTO students (student_id, name, gender, birth_date, class) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getStudentId());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getGender());
            pstmt.setDate(4, new java.sql.Date(student.getBirthDate().getTime()));
            pstmt.setString(5, student.getStudentClass());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    //通过学号来查找学生信息

    public Student findStudentByStudentId(String studentId) {
        String sql = "SELECT * FROM students WHERE student_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, studentId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setStudentId(rs.getString("student_id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setBirthDate(rs.getDate("birth_date"));
                student.setStudentClass(rs.getString("class"));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //通过名字查抄学生信息
    public List<Student> findStudentsByName(String name) {
        String sql = "SELECT * FROM students WHERE name LIKE ?";
        List<Student> students = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setStudentId(rs.getString("student_id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setBirthDate(rs.getDate("birth_date"));
                student.setStudentClass(rs.getString("class"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }


    //更新学生信息
    public boolean updateStudent(Student student) {
        String sql = "UPDATE students SET name = ?, gender = ?, birth_date = ? WHERE student_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getGender());
            pstmt.setDate(3, new java.sql.Date(student.getBirthDate().getTime()));
            pstmt.setString(4, student.getStudentId());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStudent(String studentId) {
        String sql = "DELETE FROM students WHERE student_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, studentId);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<Student> findAllStudents() {
        String sql = "SELECT * FROM students";
        List<Student> students = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setStudentId(rs.getString("student_id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setBirthDate(rs.getDate("birth_date"));
                student.setStudentClass(rs.getString("class"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }



}


