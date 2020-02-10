package ua.task1;

public class Cashier implements Runnable {

	private static final double CHANCE_TO_CLOSE = 0.3;

	private boolean isFree = false;
	private boolean stopThread = false;

	public void stopThread() {
		this.stopThread = true;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	@Override
	public void run() {
		System.out.println("Started working");
		while (!stopThread) {
			synchronized (this) {

				try {
					setFree(true);
					System.out.println("Waiting for the next Customer");
					Thread.sleep(1000);
					this.notifyAll();
					this.wait();

					// STOPPING THE CASHIER
					double random = (Math.random());
					if (random < CHANCE_TO_CLOSE) {
						System.out.println("STOP WORKING");
						stopThread();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Finished working");
	}

}
