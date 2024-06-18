package main.com.java.studentsystem.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.com.java.studentsystem.service.UserService;




public class LoginUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private UserService userService;

    public LoginUI() {
        userService = new UserService();
        setTitle("管理员登录");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        placeComponents(panel);
        add(panel);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("管理员名：");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(100, 20, 165, 25);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("密码：");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 50, 165, 25);
        panel.add(passwordField);

        loginButton = new JButton("登录");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);
        // 添加右侧图片
        String imagePath = "/Users/xiechen/Desktop/截屏2024-05-30 11.26.59.png";
        ImageIcon icon = new ImageIcon(imagePath);
        JLabel imageLabel = new JLabel(icon);
        panel.add(imageLabel, BorderLayout.EAST);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (userService.validateUser(username, password)) {
                    JOptionPane.showMessageDialog(null, "登录成功");
                    // 跳转到主界面
                    dispose();
                    MainUI mainUI = new MainUI();
                    mainUI.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "用户名或者密码错误");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginUI frame = new LoginUI();
                frame.setVisible(true);
            }
        });
    }
}
