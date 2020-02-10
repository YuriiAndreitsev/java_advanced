package ua.task1;

public class Main {
	public static void main(String[] args) {
		Cashier cashier = new Cashier();
		
//		new Thread(new Customer ("A", cashier)).start();
//		new Thread(new Customer ("B", cashier)).start();
//		new Thread(new Customer ("C", cashier)).start();
//		new Thread(new Customer ("D", cashier)).start();
//		new Thread(new Customer ("E", cashier)).start();
		new Customer ("A", cashier);
		new Customer ("B", cashier);
		new Customer ("C", cashier);
		new Customer ("D", cashier);
		new Customer ("E", cashier);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(cashier).start();
		
		try {
			Thread.sleep(3000);
			System.out.println(Thread.activeCount());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
