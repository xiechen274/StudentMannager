package main.com.java.studentsystem.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import main.com.java.studentsystem.model.Grade;
import main.com.java.studentsystem.model.Student;

public class GradeDAO {
    public boolean addGrade(Grade grade) {
        String sql = "INSERT INTO grades (student_id, subject, score) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, grade.getStudentId());
            pstmt.setString(2, grade.getSubject());
            pstmt.setDouble(3, grade.getScore());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    //重载addGrades方法，批量添加
    public boolean addGrades(List<Grade> grades) {
        String sql = "INSERT INTO grades (student_id, subject, score) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (Grade grade : grades) {
                pstmt.setString(1, grade.getStudentId());
                pstmt.setString(2, grade.getSubject());
                pstmt.setDouble(3, grade.getScore());
                pstmt.addBatch();
            }
            pstmt.executeBatch();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    //查询所有
    public List<Grade> findAllGrades() {
        String sql = "SELECT * FROM grades";
        List<Grade> grades = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Grade grade = new Grade();
                grade.setId(rs.getInt("id"));
                grade.setStudentId(rs.getString("student_id"));
                grade.setSubject(rs.getString("subject"));
                grade.setScore(rs.getDouble("score"));
                grades.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grades;
    }
    //根据学生ID查询
    public List<Grade> findGradesByStudentId(String studentId) {
        String sql = "SELECT * FROM grades WHERE student_id = ?";
        List<Grade> grades = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, studentId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Grade grade = new Grade();
                grade.setId(rs.getInt("id"));
                grade.setStudentId(rs.getString("student_id"));
                grade.setSubject(rs.getString("subject"));
                grade.setScore(rs.getDouble("score"));
                grades.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grades;
    }

    public boolean deleteGrade(int id) {
        String sql = "DELETE FROM grades WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

