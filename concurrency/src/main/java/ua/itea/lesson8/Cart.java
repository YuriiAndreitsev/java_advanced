package ua.itea.lesson8;

public class Cart {
	private volatile int gold;
	public boolean mineIsOutOfGold = false;
	public synchronized int getGold() {
		return gold;
	}

	public synchronized void setGold(int gold) {
		this.gold = gold;
	}

	public Cart(int gold) {
		super();
		this.gold = gold;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
