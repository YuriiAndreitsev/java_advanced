package com.randomizer;

/**
 * Hello world!
 *
 */
public class App extends Thread {
	public int getFiveRandomIntegers() {
		int step = 0;
		int sum = 0;
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
//		System.out.println(sum + " - is sum");
		return sum;

	}
	
//	public static void main(String[] args) {
//		new App().getFiveRandomIntegers();
//	}
}
