package ua.itea.lesson8;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class Loader implements Runnable {

	public static final int LOAD_GOLD = 3;

	private GoldMine goldMine;
	private Cart cart;
	private Exchanger<Cart> giveCartToTransporter;
	public boolean allowTransportation = false;

	public Loader(GoldMine goldMine, Cart cart, Exchanger<Cart> giveCartToTransporter) {
		super();
		this.goldMine = goldMine;
		this.cart = cart;
		this.giveCartToTransporter = giveCartToTransporter;
	}

	public void run() {
		System.out.println("LOADER : Gold in GoldMine = " + goldMine.getGold());
		while (goldMine.getGold() > 0) {

			try {
				if (goldMine.getGold() < 3) {
					cart.setGold(goldMine.getGold());
					goldMine.setGold(0);
				} else {
					goldMine.setGold(goldMine.getGold() - LOAD_GOLD);
					cart.setGold(LOAD_GOLD);
				}
				System.out.println("LOADER : Put gold in cart = " + cart.getGold() + " , gave to transporter");
				giveCartToTransporter.exchange(cart);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
