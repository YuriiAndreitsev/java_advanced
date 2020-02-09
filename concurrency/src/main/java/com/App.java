package com;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		
		Set<Player> playerSet = new HashSet<Player>();
		Host host = new Host(playerSet);
		Semaphore semaphore = new Semaphore(host.allowedPermits);
		

		Player p1 = new Player("A", semaphore, host);
		Player p2 = new Player("B", semaphore, host);
		Player p3 = new Player("C", semaphore, host);
		Player p4 = new Player("D", semaphore, host);
		Player p5 = new Player("E", semaphore, host);
		Player p6 = new Player("F", semaphore, host);

		playerSet.add(p1);
		playerSet.add(p2);
		playerSet.add(p3);
		playerSet.add(p4);
		playerSet.add(p5);
		playerSet.add(p6);

		ExecutorService es = Executors.newFixedThreadPool(host.allowedPermits + 1);

		for (Player player : playerSet) {
			es.execute(player);

		}

		Thread hostThread = new Thread(host);
		hostThread.start();

		es.shutdown();
		while (hostThread.isAlive()) {
			
		}
		System.exit(0);
	}
}
