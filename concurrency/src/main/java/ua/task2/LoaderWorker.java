package ua.task2;

public class LoaderWorker extends Thread {
	private Cart cart;
	private Boolean ownerOfCart;
	private boolean awaitingForLoading;
	private Mine mine;

	public LoaderWorker(Mine mine) {
		this.mine = mine;
	}

	public void setAwaitingForLoading(boolean awaitingForLoading) {
		this.awaitingForLoading = awaitingForLoading;
	}

	public boolean isOwnerOfCart() {
		return ownerOfCart;
	}

	public void setOwnerOfCart(boolean ownerOfCart) {
		this.ownerOfCart = ownerOfCart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public void run() {
		while (true) {

			synchronized (cart) {
				while (!isOwnerOfCart()) {
					try {
						cart.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("loading gold");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (mine.getGold() < 3) {
					loadGold(mine.getGold());
					cart.unloaderWorker.setFinish(true);
				} else {
					loadGold(3);
				}
			}
		}
	}

	public void loadGold(int amountOfGold) {

		mine.setGold(mine.getGold() - amountOfGold);
		cart.setGold(amountOfGold);

		cart.unloaderWorker.setAwaitingForUnloading(true);
		cart.transporterHasCart(true);
		setOwnerOfCart(false);
		cart.notifyAll();
		System.out.println("loaded");
		System.out.println("---------------");

		System.out.println(mine.getGold() + " Gold left in the mine");

	}
}
