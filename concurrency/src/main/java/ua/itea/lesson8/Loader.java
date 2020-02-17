package ua.itea.lesson8;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class Loader implements Runnable {

	public static final int LOAD_GOLD = 3;

	private GoldMine goldMine;
	private Cart cart;
	private Exchanger<Cart> giveCartToTransporter;
	public boolean allowTransportation = false;
	private boolean awaitingForLoading = true;

	public boolean isAwaitingForLoading() {
		return awaitingForLoading;
	}

	public void setAwaitingForLoading(boolean awaitingForLoading) {
		this.awaitingForLoading = awaitingForLoading;
	}

	public Loader(GoldMine goldMine, Cart cart, Exchanger<Cart> giveCartToTransporter) {
		super();
		this.goldMine = goldMine;
		this.cart = cart;
		this.giveCartToTransporter = giveCartToTransporter;
	}

	public void run() {
		System.out.println("LOADER : Gold in GoldMine = " + goldMine.getGold());
		while (goldMine.getGold() > 0) {
			if (awaitingForLoading) {
				awaitingForLoading = false;
				try {
					if (goldMine.getGold() < 3) {
						cart.setGold(goldMine.getGold());
						goldMine.setGold(0);
						cart.setNoGoldinMine(true);
					} else {
						goldMine.setGold(goldMine.getGold() - LOAD_GOLD);
						cart.setGold(LOAD_GOLD);
					}
					cart = giveCartToTransporter.exchange(cart);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				try {
					awaitingForLoading = true;
					cart = null;
					cart = giveCartToTransporter.exchange(cart);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("LOADER FINISHED");
	}
}
