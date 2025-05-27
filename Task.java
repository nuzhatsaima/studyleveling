package models;

public class Task {
    public String description;
    public boolean isCompleted;
    public int xpReward;
    public int coinReward;

    public Task(String description, int xpReward, int coinReward) {
        this.description = description;
        this.xpReward = xpReward;
        this.coinReward = coinReward;
        this.isCompleted = false;
    }

    @Override
    public String toString() {
        return (isCompleted ? "[✓] " : "[ ] ") + description + " (XP: " + xpReward + ", Coins: " +coinReward+")";}
}