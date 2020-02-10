package ua.task2;
public class Worker extends Thread {

    GoldMine goldMine;

    public Worker(GoldMine goldMine) {
        setDaemon(true);
        this.goldMine = goldMine;
    }

    public void run() {
        System.out.println("Hi, I am a new Worker ("+ Thread.currentThread().getName()+")");
        while(true) {
                try {
                    if(goldMine.getGold()<3) {
                        mining(goldMine.getGold());
                    } else {
                        mining(3);
                    }
                    Thread.sleep(1000 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

    public void mining(int goldPerSecond) {
            goldMine.setGold(goldMine.getGold() - goldPerSecond);
            System.out.println(goldMine.getGold() + " Gold Left In The Mine (" + Thread.currentThread().getName() + ")");
    }
}
