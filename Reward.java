package models;

public class Reward {
    public String name;
    public int cost;
    public boolean isUnlocked;

    public Reward(String name, int cost) {
        this.name = name;
        this.cost = cost;
        this.isUnlocked =false;
}
}