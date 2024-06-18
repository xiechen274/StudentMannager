package main.com.java.studentsystem.ui;



import main.com.java.studentsystem.model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import main.com.java.studentsystem.service.StudentService;

public class StudentUI extends JFrame {
    private StudentService studentService;

    public StudentUI() {
        studentService = new StudentService();
        setTitle("学生信息管理");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2)); // 使用网格布局，10行2列

        JLabel idLabel = new JLabel("学生学号:");
        JTextField idField = new JTextField();
        JLabel nameLabel = new JLabel("学生姓名:");
        JTextField nameField = new JTextField();
        JLabel genderLabel = new JLabel("性别:");
        JTextField genderField = new JTextField();
        //日期格式为：YYYY-MM-DD
        JLabel birthLabel = new JLabel("生日:");
        JTextField birthField = new JTextField();
        JLabel classLabel = new JLabel("班级:");
        JTextField classField = new JTextField();

        JButton addButton = new JButton("添加学生信息");
        JButton viewButton = new JButton("一键查看全部学生信息");
        JButton findByIdButton = new JButton("通过学号查找");
        JButton findByNameButton = new JButton("通过姓名查找");

        // 添加学生按钮
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentId = idField.getText();
                String name = nameField.getText();
                String gender = genderField.getText();
                Date birthDate = Date.valueOf(birthField.getText()); // 日期格式：YYYY-MM-DD
                String studentClass = classField.getText();

                Student student = new Student(studentId, name, gender, birthDate, studentClass);
                if (studentService.addStudent(student)) {
                    JOptionPane.showMessageDialog(null, "成功添加学生");
                } else {
                    JOptionPane.showMessageDialog(null, "添加学生失败");
                }
            }
        });

        // 查看所有学生按钮
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 打开一个新的窗口显示所有学生信息
                JFrame viewFrame = new JFrame("全部学生信息");
                viewFrame.setSize(600, 400);
                viewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                viewFrame.setLocationRelativeTo(null);

                JTextArea textArea = new JTextArea();
                for (Student student : studentService.getAllStudents()) {
                    textArea.append(student.toString() + "\n");
                }

                viewFrame.add(new JScrollPane(textArea));
                viewFrame.setVisible(true);
            }
        });

        // 按学号查询学生按钮
        findByIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentId = idField.getText();
                Student student = studentService.getStudentByStudentId(studentId);
                if (student != null) {
                    JOptionPane.showMessageDialog(null, student.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "无法查询到这个学号的信息，学生学号为: " + studentId);
                }
            }
        });

        // 按姓名模糊查询学生按钮
        findByNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                java.util.List<Student> students = studentService.getStudentsByName(name);
                if (!students.isEmpty()) {
                    JFrame viewFrame = new JFrame("含有输入的模糊查询: " + name);
                    viewFrame.setSize(600, 400);
                    viewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    viewFrame.setLocationRelativeTo(null);

                    JTextArea textArea = new JTextArea();
                    for (Student student : students) {
                        textArea.append(student.toString() + "\n");
                    }

                    viewFrame.add(new JScrollPane(textArea));
                    viewFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "没有找到含有名字是: " + name +"的学生");
                }
            }
        });

        panel.add(idLabel);
        panel.add(idField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(genderLabel);
        panel.add(genderField);
        panel.add(birthLabel);
        panel.add(birthField);
        panel.add(classLabel);
        panel.add(classField);
        panel.add(addButton);
        panel.add(viewButton);
        panel.add(findByIdButton);
        panel.add(findByNameButton);

        add(panel);
    }
}

