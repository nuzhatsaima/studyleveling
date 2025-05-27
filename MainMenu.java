// ui/MainMenu.java
package ui;

import models.User;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    public static User user = new User("GUEST");

    private JLabel levelLabel;
    private JLabel xpLabel;

    public MainMenu() {
        setTitle("📘 Study Leveling");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(173, 216, 230));

        JLabel userLabel = new JLabel("USER: " + user.username);
        userLabel.setBounds(30, 20, 200, 30);
        userLabel.setForeground(Color.WHITE);
        userLabel.setOpaque(true);
        userLabel.setBackground(new Color(199, 21, 133));
        userLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
        userLabel.setHorizontalAlignment(SwingConstants.CENTER);
        userLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        levelLabel = new JLabel("LEVEL: " + user.level);
        levelLabel.setBounds(570, 20, 180, 30);
        levelLabel.setForeground(Color.WHITE);
        levelLabel.setOpaque(true);
        levelLabel.setBackground(new Color(199, 21, 133));
        levelLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
        levelLabel.setHorizontalAlignment(SwingConstants.CENTER);

        xpLabel = new JLabel("XP: " + user.xp);
        xpLabel.setBounds(570, 60, 180, 30);
        xpLabel.setForeground(Color.WHITE);
        xpLabel.setOpaque(true);
        xpLabel.setBackground(new Color(199, 21, 133));
        xpLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
        xpLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel centralPanel = new JPanel();
        centralPanel.setBounds(200, 150, 400, 300);
        centralPanel.setBackground(Color.BLACK);
        centralPanel.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel title = new JLabel("STUDY LEVELING");
        title.setForeground(Color.YELLOW);
        title.setFont(new Font("Monospaced", Font.BOLD, 22));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JButton startButton = createStyledButton("START");
        JButton rewardsButton = createStyledButton("REWARDS");
        JButton progressButton = createStyledButton("PROGRESS");

        startButton.addActionListener(e -> new StudyScreen(this));
        rewardsButton.addActionListener(e -> new RewardScreen());
        progressButton.addActionListener(e -> new ProgressScreen());

        centralPanel.add(title);
        centralPanel.add(startButton);
        centralPanel.add(rewardsButton);
        centralPanel.add(progressButton);

        add(userLabel);
        add(levelLabel);
        add(xpLabel);
        add(centralPanel);

        setVisible(true);
    }

    public void refreshStats() {
        levelLabel.setText("LEVEL: " + user.level);
        xpLabel.setText("XP: " + user.xp);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setBackground(new Color(147, 112, 219));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Monospaced", Font.BOLD, 16));
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        return button;
    }

    public static void main(String[] args) {
        new MainMenu();
}
}

