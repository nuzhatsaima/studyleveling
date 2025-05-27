package models;

public class User {
    public String username;
    public int xp;
    public int level;
    public int coins;

    public User(String username) {
        this.username = username;
        this.xp = 0;
        this.level = 1;
        this.coins = 0;
    }

    public void addXP(int amount) {
        System.out.println("Adding XP: " + amount);
        System.out.println("Before → XP: " + xp + ", Level: " + level + ", Coins: " + coins);

        xp += amount;

        while (xp >= xpNeeded(level)) {
            xp -= xpNeeded(level);
            level++;
            coins += 50;
            System.out.println("Leveled up! → Level: " + level + ", Coins: " + coins);
        }

        System.out.println("After → XP: " + xp + ", Level: " + level + ", Coins: " + coins);
    }

    public int xpNeeded(int level) {
        return 100 * (int) Math.pow(1.5, level-1);
}
}