public class Worker extends Thread {
	public static final int AMOUNT_OF_GOLD = 3;
	private int totalGoldMined = 0;

	private GoldMine goldMine;

	public Worker(GoldMine goldMine) {
		setDaemon(true);
		this.goldMine = goldMine;
	}
	
	

	public int getTotalGoldMined() {
		return totalGoldMined;
	}



	public void setTotalGoldMined(int totalGoldMined) {
		this.totalGoldMined = totalGoldMined;
	}



	public void run() {
		System.out.println("Hi, i am a new Worker (" + Thread.currentThread().getName() + ")");
		while (true) {
			try {
				System.out.println(Thread.currentThread().getName() + " - started mining : " + goldMine.getGold());
				if (goldMine.getGold() <= 3) {
					mining(goldMine.getGold());
					setTotalGoldMined(getTotalGoldMined()+goldMine.getGold());
				} else {
					mining(AMOUNT_OF_GOLD);
					setTotalGoldMined(getTotalGoldMined()+AMOUNT_OF_GOLD);
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void mining(int goldPerSecond) {
		goldMine.setGold(goldMine.getGold() - goldPerSecond);
		System.out.println(goldMine.getGold() + " Gold Left In The Mine (" + Thread.currentThread().getName() + ")");
		System.out.println(Thread.currentThread().getName()+ " have mined "+getTotalGoldMined()+ " gold;");
	}
}
