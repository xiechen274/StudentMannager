package main.com.java.studentsystem.ui;
import main.com.java.studentsystem.service.StudentService;
import main.com.java.studentsystem.model.Student;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class UpdateStudentUI extends JFrame {
    private StudentService studentService;

    public UpdateStudentUI() {
        studentService = new StudentService();
        setTitle("更新学生信息");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2)); // 使用网格布局，7行2列

        JLabel idLabel = new JLabel("学生学号:");
        JTextField idField = new JTextField();
        JLabel nameLabel = new JLabel("学生姓名:");
        JTextField nameField = new JTextField();
        JLabel genderLabel = new JLabel("性别:");
        JTextField genderField = new JTextField();
        JLabel birthLabel = new JLabel("生日:");
        JTextField birthField = new JTextField();
        JLabel classLabel = new JLabel("班级:");
        JTextField classField = new JTextField();

        JButton searchButton = new JButton("根据信息搜索学生");
        JButton updateButton = new JButton("修改");

        // 搜索学生信息按钮
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentId = idField.getText();
                Student student = studentService.getStudentByStudentId(studentId);
                if (student != null) {
                    nameField.setText(student.getName());
                    genderField.setText(student.getGender());
                    birthField.setText(student.getBirthDate().toString());
                    classField.setText(student.getStudentClass());
                } else {
                    JOptionPane.showMessageDialog(null, "没有找到ID为: " + studentId + "的学生");
                }
            }
        });

        // 更新学生信息按钮
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentId = idField.getText();
                String name = nameField.getText();
                String gender = genderField.getText();
                Date birthDate = Date.valueOf(birthField.getText());
                String studentClass = classField.getText();

                Student student = new Student(studentId, name, gender, birthDate, studentClass);
                student.setId(studentService.getStudentByStudentId(studentId).getId());

                if (studentService.updateStudent(student)) {
                    JOptionPane.showMessageDialog(null, "学生信息修改成功");
                } else {
                    JOptionPane.showMessageDialog(null, "修改失败.");
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
        panel.add(searchButton);
        panel.add(updateButton);

        add(panel);
    }


}

