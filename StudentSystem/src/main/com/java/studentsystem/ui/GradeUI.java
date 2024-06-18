package main.com.java.studentsystem.ui;

import main.com.java.studentsystem.model.Grade;
import main.com.java.studentsystem.service.GradeService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeUI extends JFrame {
    private GradeService gradeService;

    public GradeUI() {
        gradeService = new GradeService();
        setTitle("成绩管理");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10)); // 使用网格布局，6行2列，间距10

        JLabel idLabel = new JLabel("学号");
        JTextField idField = new JTextField();
        JLabel subjectLabel = new JLabel("科目");
        JTextField subjectField = new JTextField();
        JLabel scoreLabel = new JLabel("成绩:");
        JTextField scoreField = new JTextField();

        JButton addButton = new JButton("添加学生成绩");
        JButton viewButton = new JButton("一键查看全部成绩");
        JButton generateChartButton = new JButton("生成柱状图");

        // 添加成绩按钮
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentId = idField.getText();
                String subject = subjectField.getText();
                double score;
                try {
                    score = Double.parseDouble(scoreField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "非法输入");
                    return;
                }

                Grade grade = new Grade(studentId, subject, score);
                if (gradeService.addGrade(grade)) {
                    JOptionPane.showMessageDialog(null, "成绩添加成功");
                } else {
                    JOptionPane.showMessageDialog(null, "成绩添加失败");
                }
            }
        });

        // 查看成绩按钮
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 打开一个新的窗口显示所有成绩信息
                JFrame viewFrame = new JFrame("All Grades");
                viewFrame.setSize(600, 400);
                viewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                viewFrame.setLocationRelativeTo(null);

                JTextArea textArea = new JTextArea();
                for (Grade grade : gradeService.getAllGrades()) {
                    textArea.append(grade.toString() + "\n");
                }

                viewFrame.add(new JScrollPane(textArea));
                viewFrame.setVisible(true);
            }
        });

        // 生成柱状图按钮
        generateChartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GradeChart chart = new GradeChart(gradeService);
                chart.setVisible(true);
            }
        });

        panel.add(idLabel);
        panel.add(idField);
        panel.add(subjectLabel);
        panel.add(subjectField);
        panel.add(scoreLabel);
        panel.add(scoreField);
        panel.add(addButton);
        panel.add(viewButton);
        panel.add(generateChartButton);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GradeUI frame = new GradeUI();
            frame.setVisible(true);
        });
    }
}
