public class GoldMine {

    private volatile int gold = 1000;

    public synchronized int getGold() {
        return gold;
    }

    public synchronized void setGold(int gold) {
        this.gold = gold;
    }
}
