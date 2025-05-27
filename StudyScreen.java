package ui;

import models.Task;

import javax.swing.*;
import java.awt.*;

public class StudyScreen extends JFrame {
    private final DefaultListModel<Task> taskListModel = new DefaultListModel<>();
    private final JList<Task> taskList = new JList<>(taskListModel);
    private final JTextField taskField = new JTextField();
    private final JTextField xpField = new JTextField("50", 3);
    private final JTextField coinField = new JTextField("20", 3);
    private final MainMenu mainMenu;

    public StudyScreen(MainMenu mainMenu) {
        this.mainMenu = mainMenu;

        setTitle("Study Tasks");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JButton addTask = new JButton("Add Task");
        JButton completeTask = new JButton("Complete Task");
        JButton deleteTask = new JButton("Delete Task");

        // Add Task logic
        addTask.addActionListener(e -> {
            String desc = taskField.getText().trim();
            if (!desc.isEmpty()) {
                try {
                    int xp = Integer.parseInt(xpField.getText().trim());
                    int coins = Integer.parseInt(coinField.getText().trim());
                    taskListModel.addElement(new Task(desc, xp, coins));
                    taskField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "XP and Coins must be numbers.");
                }
            }
        });

        // Complete Task logic
        completeTask.addActionListener(e -> {
            Task task = taskList.getSelectedValue();
            if (task != null && !task.isCompleted) {
                task.isCompleted = true;
                MainMenu.user.addXP(task.xpReward);
                MainMenu.user.coins += task.coinReward;

                JOptionPane.showMessageDialog(this,
                        "Task Completed!\n+ " + task.xpReward + " XP\n+ " + task.coinReward + " Coins");

                taskList.repaint();
                mainMenu.refreshStats();
            }
        });

        // Delete Task logic
        deleteTask.addActionListener(e -> {
            Task selected = taskList.getSelectedValue();
            if (selected != null) {
                taskListModel.removeElement(selected);
            }
        });

        // Input Panels
        JPanel inputPanel = new JPanel(new BorderLayout());
        JPanel rewardPanel = new JPanel(new GridLayout(1, 4));
        rewardPanel.add(new JLabel("XP:"));
        rewardPanel.add(xpField);
        rewardPanel.add(new JLabel("Coins:"));
        rewardPanel.add(coinField);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(taskField, BorderLayout.CENTER);
        topPanel.add(addTask, BorderLayout.EAST);
        inputPanel.add(topPanel, BorderLayout.NORTH);
        inputPanel.add(rewardPanel, BorderLayout.SOUTH);

        JPanel buttons = new JPanel();
        buttons.add(completeTask);
        buttons.add(deleteTask);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(taskList), BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);

        setVisible(true);
}
}