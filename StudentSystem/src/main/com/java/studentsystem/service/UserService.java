package main.com.java.studentsystem.service;


import main.com.java.studentsystem.dao.UserDAO;
import main.com.java.studentsystem.model.User;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public boolean addUser(User user) {
        return userDAO.addUser(user);
    }

    public User findUserByUsername(String username) {
        return userDAO.findUserByUsername(username);
    }

    public boolean validateUser(String username, String password) {
        User user = userDAO.findUserByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}

