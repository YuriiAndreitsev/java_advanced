package ua.itea.lesson8;

public class Warehouse {

	private int gold;

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public Warehouse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Warehouse(int gold) {
		super();
		this.gold = gold;
	}

	@Override
	public String toString() {
		return "Warehouse [gold=" + gold + "]";
	}

}
