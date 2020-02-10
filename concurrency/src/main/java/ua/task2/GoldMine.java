package ua.task2;
public class GoldMine {

    private volatile int gold = 100;


    public synchronized int getGold() {
        return gold;
    }

    public synchronized void setGold(int gold) {
        this.gold = gold;
    }
}
