package ua.task1;

public class Customer implements Runnable {
	String name;
	Cashier cashier;
	private boolean stopThread = false;

	public void stopThread() {
		this.stopThread = true;
	}

	public Customer(String name, Cashier cashier) {
		this.name = name;
		this.cashier = cashier;
		Thread t = new Thread(this);
		t.setDaemon(true);
		t.start();
	}

	public Customer() {
		super();
	}

	@Override
	public void run() {
		System.out.println(name + " : came to the Cash Desk");
		while (!stopThread) {
			synchronized (cashier) {
				try {
					if (cashier.isFree()) {

						int timeToServe = 3 + (int) (Math.random() * 2);
						System.out.println(name + " : Serving by Cashier for " + timeToServe + " seconds");

						Thread.sleep(timeToServe * 1000);
						System.out.println(name + " :  Finished Shopping");
						cashier.setFree(false);
						stopThread();
						cashier.notify();
					} else {
						cashier.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}

}
