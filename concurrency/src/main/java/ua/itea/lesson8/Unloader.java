package ua.itea.lesson8;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class Unloader implements Runnable {

	public static final int UNLOAD_GOLD = 1;
	Warehouse warehouse;
	Cart cart;
	Exchanger<Cart> transporterUnloader;
	private boolean stop = false;

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public Unloader(Warehouse warehouse, Cart cart, Exchanger<Cart> transporterUnloader) {
		this.warehouse = warehouse;
		this.cart = cart;
		this.transporterUnloader = transporterUnloader;
	}

	public Unloader(Warehouse warehouse, Exchanger<Cart> transporterUnloader) {
		this.warehouse = warehouse;
		this.transporterUnloader = transporterUnloader;
	}

	public void run() {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (true) {
			try {
//				cart.setGold(0);
				System.out.println("UNLOADER : exchanging with Transporter");
				cart = transporterUnloader.exchange(cart);
				System.out.println("UNLOADER : put gold in warehouse");
				warehouse.setGold(warehouse.getGold() + cart.getGold());
				System.out.println("WAREHOUSE : " + warehouse.getGold() + " gold in Warehouse");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
