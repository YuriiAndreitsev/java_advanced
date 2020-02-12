package ua.itea.lesson8;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class Transporter implements Runnable {

	public static final int TRANSPORTATION_TIME_MS = 2000;
	private Cart cart = new Cart();
	private Exchanger<Cart> loaderTransporter;
	private Exchanger<Cart> transporterUnloader;


	public Transporter(Cart cart, Exchanger<Cart> receiveCartFromLoader, Exchanger<Cart> giveCartToUnloader) {
		super();
		this.cart = cart;
		this.loaderTransporter = receiveCartFromLoader;
		this.transporterUnloader = giveCartToUnloader;
	}

	private boolean switchDestination = true;

	public void run() {

		while (true) {
			try {
				TimeUnit.MILLISECONDS.sleep(TRANSPORTATION_TIME_MS);
				if (switchDestination) {
					switchDestination = false;

					System.out.println("TRANSPORTER : Received cart from Loader, giving Cart to UnLoader");
					cart = loaderTransporter.exchange(cart);

					System.out.println("TRANSPORTER : Gave cart to Unloader");
					cart = transporterUnloader.exchange(cart);

				} else {

					switchDestination = true;
					System.out.println("TRANSPORTER : Gave cart to Loader");
					cart = loaderTransporter.exchange(cart);

				}

			} catch (

			InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
