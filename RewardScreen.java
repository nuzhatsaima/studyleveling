package ui;

import models.Reward;
import models.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RewardScreen extends JFrame {
    private final java.util.List<Reward> rewards = new ArrayList<>();

    public RewardScreen() {
        setTitle("Reward Shop");
        setSize(400, 300);
        setLayout(new GridLayout(0, 1));

        rewards.add(new Reward("Cool Avatar", 100));
        rewards.add(new Reward("Night Theme", 150));
        rewards.add(new Reward("Badge of Honor", 200));

        for (Reward r : rewards) {
            JButton btn = new JButton(r.name + " - " + r.cost + " coins");
            btn.setEnabled(!r.isUnlocked);
            btn.addActionListener(e -> {
                if (MainMenu.user.coins >= r.cost && !r.isUnlocked) {
                    MainMenu.user.coins -= r.cost;
                    r.isUnlocked = true;
                    btn.setText(r.name + " (Unlocked)");
                    btn.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Not enough coins!");
                }
            });
            add(btn);
        }

        setVisible(true);
}
}
