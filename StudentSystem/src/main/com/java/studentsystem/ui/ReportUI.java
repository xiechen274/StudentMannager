package main.com.java.studentsystem.ui;


import main.com.java.studentsystem.service.ReportService;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReportUI extends JFrame {
    private ReportService reportService;

    public ReportUI() {
        reportService = new ReportService();
        setTitle("学生信息报告");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        JButton saveButton = new JButton("保存到本地");

        List<Map<String, Object>> report = reportService.generateStudentReport();
        for (Map<String, Object> studentReport : report) {
            textArea.append(studentReport.toString() + "\n");
        }

        saveButton.addActionListener(e -> {
            try (FileWriter writer = new FileWriter("student_report2.txt")) {
                for (Map<String, Object> studentReport : report) {
                    writer.write(studentReport.toString() + "\n");
                }
                JOptionPane.showMessageDialog(null, "成功保存为student_report.txt");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "到处失败");
            }
        });

        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(saveButton, BorderLayout.SOUTH);

        add(panel);
    }


}

