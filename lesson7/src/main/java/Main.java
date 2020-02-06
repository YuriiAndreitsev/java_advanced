import java.util.Timer;

public class Main {
    public static void main(String[] args) {
    	
        boolean exit = false;
        Timer timer = new Timer();
        GoldMine goldMine = new GoldMine();
        Barracks barracks = new Barracks(goldMine);

        for (int i = 0; i < 5; i++) {
            new Worker(goldMine).start();
        }

        timer.scheduleAtFixedRate(barracks, 0, 10000);
        while (!exit){
            if (goldMine.getGold()==0){
                exit=true;
                System.out.println("GOLD MINE HAS DEPLETED !!!! FING ANOTHER ONE!!!");
                timer.cancel();
            }
        }
    }
}
