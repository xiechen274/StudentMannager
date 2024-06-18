package main.com.java.studentsystem.ui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import main.com.java.studentsystem.model.Grade;
import main.com.java.studentsystem.service.GradeService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GradeChart extends JFrame {

    private GradeService gradeService;
    private JComboBox<String> subjectComboBox;
    private ChartPanel chartPanel;

    public GradeChart(GradeService gradeService) {
        this.gradeService = gradeService;
        setTitle("学生成绩柱状图");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 创建下拉列表
        Set<String> subjects = gradeService.getAllGrades().stream()
                .map(Grade::getSubject)
                .collect(Collectors.toSet());
        subjectComboBox = new JComboBox<>(subjects.toArray(new String[0]));

        // 添加下拉列表的事件监听
        subjectComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateChart((String) subjectComboBox.getSelectedItem());
            }
        });

        // 初始化图表面板
        chartPanel = new ChartPanel(null);
        chartPanel.setPreferredSize(new Dimension(800, 500));

        // 布局设置
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.add(new JLabel("选择科目:"), BorderLayout.WEST);
        topPanel.add(subjectComboBox, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);
        add(chartPanel, BorderLayout.CENTER);

        // 显示默认科目的图表
        if (subjects.size() > 0) {
            updateChart(subjects.iterator().next());
        }
    }

    private void updateChart(String subject) {
        DefaultCategoryDataset dataset = createDataset(subject);
        JFreeChart barChart = ChartFactory.createBarChart(
                "学生成绩分布 - " + subject,
                "学生",
                "成绩",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        chartPanel.setChart(barChart);
    }

    private DefaultCategoryDataset createDataset(String subject) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        List<Grade> grades = gradeService.getAllGrades();
        Map<String, Double> studentScores = grades.stream()
                .filter(g -> g.getSubject().equals(subject))
                .collect(Collectors.groupingBy(
                        Grade::getStudentId,
                        Collectors.averagingDouble(Grade::getScore)
                ));

        for (Map.Entry<String, Double> entry : studentScores.entrySet()) {
            dataset.addValue(entry.getValue(), subject, entry.getKey());
        }

        return dataset;
    }
}
