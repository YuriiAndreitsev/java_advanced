package task1;

import java.util.concurrent.BlockingQueue;

public class Cashier {
	double chanceToClose = 0.3;

	BlockingQueue<Customer> q;
	

	public Cashier(BlockingQueue<Customer> q) {
		this.q = q;
//		Thread t = new Thread(r);
//		t.setDaemon(true);
//		t.start();
	}

	Runnable r = () -> {
		try {
			while (!q.isEmpty() ) {
//				System.out.println("THREAD ACTIVE COUNT : "+ Thread.activeCount());
				Customer c = q.take();
				q.stream().forEach((e) -> Thread.currentThread().getName());

				int timeToServe = 3 + (int) (Math.random() * 2);
				System.out.println("serving " + timeToServe + " seconds");
				Thread.sleep(timeToServe * 1000);
				c.stop();

				double random = (Math.random());
System.out.println(random + " random");
				if (random < chanceToClose) {
					System.out.println("STOP WORKING");
					Thread.currentThread().interrupt();
//					stop();
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};

}
