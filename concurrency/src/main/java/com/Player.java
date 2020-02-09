package com;

import java.util.concurrent.Semaphore;

public class Player implements Runnable {

	Host host;
	String name;
	Semaphore semaphorTaburet;
	private boolean stop = true;
	private boolean hasChair = false;

	public boolean hasChair() {
		return hasChair;
	}

	public void setHasChair(boolean hasChair) {
		this.hasChair = hasChair;
	}

	public void stopThread() {
		stop = false;
	}

	public String getName() {
		return name;
	}

	public Player(String name, Semaphore semaphorTaburet, Host host) {
		this.host = host;
		this.name = name;
		this.semaphorTaburet = semaphorTaburet;
	}

	public Player() {

	}

	@Override
	public void run() {
		while (stop) {

			synchronized (host) {
				try {
					host.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			try {
				semaphorTaburet.acquire();
				setHasChair(true);
//				System.out.println(name + " has chair");
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

		}
		System.out.println(name + " dies");
	}
}
