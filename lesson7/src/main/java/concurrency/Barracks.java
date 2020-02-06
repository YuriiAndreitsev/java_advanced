import java.util.TimerTask;

public class Barracks extends TimerTask {
    GoldMine goldMine;

    public Barracks(GoldMine goldMine) {
        this.goldMine = goldMine;
    }

    public void run() {
        new Worker(goldMine).start();
    }
}
