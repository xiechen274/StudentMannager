package main.com.java.studentsystem.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUI extends JFrame {
    public MainUI() {
        setTitle("学生信息管理系统");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 创建主面板
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // 添加顶部图片
        String imagePath = "图片 1.png";
        ImageIcon icon = new ImageIcon(imagePath);
        JLabel imageLabel = new JLabel(icon);
        mainPanel.add(imageLabel, BorderLayout.NORTH);

        // 创建按钮面板
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JButton studentButton = new JButton("学生信息管理");
        JButton gradeButton = new JButton("学习成绩管理");
        JButton updateStudentButton = new JButton("修改学生信息");
        JButton generateReportButton = new JButton("生成成绩报告");
        JButton logoutButton = new JButton("退出");

        // 设置按钮样式
        studentButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        gradeButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        updateStudentButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        generateReportButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        logoutButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));


        studentButton.setPreferredSize(new Dimension(800, 100));
        gradeButton.setPreferredSize(new Dimension(800, 100));
        updateStudentButton.setPreferredSize(new Dimension(800, 100));
        generateReportButton.setPreferredSize(new Dimension(800, 100));
        logoutButton.setPreferredSize(new Dimension(800, 100));

        // 学生管理按钮
        studentButton.addActionListener(e -> {
            // 打开学生管理界面
            StudentUI studentUI = new StudentUI();
            studentUI.setVisible(true);
        });

        // 成绩管理按钮
        gradeButton.addActionListener(e -> {
            // 打开成绩管理界面
            GradeUI gradeUI = new GradeUI();
            gradeUI.setVisible(true);
        });

        // 修改学生信息按钮
        updateStudentButton.addActionListener(e -> {
            // 打开修改学生信息界面
            UpdateStudentUI updateStudentUI = new UpdateStudentUI();
            updateStudentUI.setVisible(true);
        });

        // 生成报表按钮
        generateReportButton.addActionListener(e -> {
            // 打开生成报表界面
            ReportUI reportUI = new ReportUI();
            reportUI.setVisible(true);
        });

        // 登出按钮
        logoutButton.addActionListener(e -> {
            dispose(); // 关闭主界面
            LoginUI loginUI = new LoginUI();
            loginUI.setVisible(true); // 打开登录界面
        });

      
        buttonPanel.add(studentButton);
       
        buttonPanel.add(gradeButton);
       
        buttonPanel.add(updateStudentButton);
       
        buttonPanel.add(generateReportButton);
      
        buttonPanel.add(logoutButton);
      

        // 添加按钮面板到主面板的中心
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // 添加主面板到框架
        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginUI loginUI = new LoginUI();
            loginUI.setVisible(true);
        });
    }
}





