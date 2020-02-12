package ua.itea.lesson8;

public class GoldMine {

	private volatile int gold;

	public synchronized int getGold() {
		return gold;
	}

	public synchronized void setGold(int gold) {
		this.gold = gold;
	}

	public GoldMine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GoldMine(int gold) {
		super();
		this.gold = gold;
	}

	@Override
	public String toString() {
		return "GoldMine [gold=" + gold + "]";
	}

}
