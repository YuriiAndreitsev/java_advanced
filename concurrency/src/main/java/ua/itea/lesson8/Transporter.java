package ua.itea.lesson8;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class Transporter implements Runnable {

	public static final int TRANSPORTATION_TIME_MS = 2000;
	private Cart cart;
	private Exchanger<Cart> loaderTransporter;
	private Exchanger<Cart> transporterUnloader;
	private boolean stop = false;
	
	private void stopThread() {
		this.stop = true;
	}

	public Transporter(Cart cart, Exchanger<Cart> receiveCartFromLoader, Exchanger<Cart> giveCartToUnloader) {
		this.cart = cart;
		this.loaderTransporter = receiveCartFromLoader;
		this.transporterUnloader = giveCartToUnloader;
	}

	private boolean switchDestination = true;

	public void run() {

		while (!stop) {
			
			try {
//				TimeUnit.MILLISECONDS.sleep(TRANSPORTATION_TIME_MS);
				if (switchDestination) {
					cart = null;
					cart = loaderTransporter.exchange(cart);
					if (cart.isNoGoldinMine()) {
						stopThread();
					}
					System.out.println("TRANSPORTER : Received cart from Loader, giving Cart to UnLoader");
					cart = transporterUnloader.exchange(cart);
					System.out.println("TRANSPORTER : Gave cart to Unloader");					
					switchDestination = false;
				} else {
					switchDestination = true;
					System.out.println("Returning cart to Loader");
					loaderTransporter.exchange(cart);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("TRANSPORTER FINISHED");
	}

}
