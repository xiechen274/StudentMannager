package main.com.java.studentsystem.service;

import main.com.java.studentsystem.dao.GradeDAO;
import main.com.java.studentsystem.model.Grade;

import java.util.List;

public class GradeService {
    private GradeDAO gradeDAO = new GradeDAO();

    public boolean addGrade(Grade grade) {
        return gradeDAO.addGrade(grade);
    }

    public boolean addGrades(List<Grade> grades) {
        return gradeDAO.addGrades(grades);
    }

    public List<Grade> getAllGrades() {
        return gradeDAO.findAllGrades();
    }

}

