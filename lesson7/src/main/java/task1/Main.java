package task1;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

	public static void main(String[] args) {
		BlockingQueue<Customer> queue = new ArrayBlockingQueue<Customer>(5);
		queue.addAll(Arrays.asList(new Customer(), new Customer(), new Customer(), new Customer()));
		
		
		Cashier c = new Cashier(queue);
		
		Thread t = new Thread(c.r);
		t.setDaemon(true);
		t.start();

		while (!t.isInterrupted()) {
			
		}
	}

}
