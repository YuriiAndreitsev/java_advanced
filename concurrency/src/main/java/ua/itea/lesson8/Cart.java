package ua.itea.lesson8;

public class Cart {
	private volatile int gold;
	private boolean noGoldinMine = false;

	public boolean isNoGoldinMine() {
		return noGoldinMine;
	}

	public void setNoGoldinMine(boolean noGoldinMine) {
		this.noGoldinMine = noGoldinMine;
	}

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

	}

	@Override
	public String toString() {
		return "Cart [gold=" + gold + "]" + isNoGoldinMine()+ " gold in mine";
	}

}
