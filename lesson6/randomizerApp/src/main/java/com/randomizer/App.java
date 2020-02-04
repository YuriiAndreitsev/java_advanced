package com.randomizer;

/**
 * Hello world!
 *
 */
public class App extends Thread {

//		System.out.println(sum + " - is sum");

	int sum = 0;
	

	public void run() {
		int step = 0;
		
		do {
			try {
				Thread.sleep(500);
				int random = (int) (Math.random() * 100);
//				System.out.println(random + " - is random");
				sum += random;
				step++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} while (step < 5);
	}


	public int getSum() {
		return sum;
	}


	public void setSum(int sum) {
		this.sum = sum;
	}


}
