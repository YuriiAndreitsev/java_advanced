package ua.itea.lesson8;

import java.lang.ref.WeakReference;
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

		while (!cart.isNoGoldinMine()) {			
				try {
					cart = transporterUnloader.exchange(new Cart(0));					
					System.out.println("UNLOADER RECEIVED CART WITH " + cart);
					System.out.println("UNLOADER : exchanging with Transporter");
					warehouse.setGold(warehouse.getGold() + cart.getGold());

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("WAREHOUSE : " + warehouse.getGold() + " gold in Warehouse");
			
		}
		System.out.println("UNLOADER FINISHED");
	}

}
