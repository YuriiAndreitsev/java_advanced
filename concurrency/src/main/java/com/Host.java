package com;

import java.util.HashSet;
import java.util.Set;
import java.util.TimerTask;

public class Host extends TimerTask {

	public int allowedPermits = 5;
	Set<Player> playerSet = new HashSet<Player>();

	public long musicPlaying;
	private int rounds = 4;
	private boolean stop = true;

	public Host(Set<Player> playerSet) {
		super();
		this.playerSet = playerSet;
	}

	public void stopThread() {
		stop = false;
	}

	@Override
	public void run() {
		while (stop) {
			do {

				musicPlaying = (long) ((2 + Math.random() * 1) * 1000);

				System.out.println("Music is playing for :" + musicPlaying + " seconds");

				try {
					synchronized (this) {
						Thread.sleep(musicPlaying);
						notifyAll();
						System.out.println(" SIT DOWN NOW !!!!!!");
					}
					Thread.sleep(500);

					Player playerToRemove = null;

					for (Player player : playerSet) {
						if (!player.hasChair()) {
							System.out.println("PLAYER " + player.getName() + " has no chair");
							playerToRemove = player;
							player.stopThread();
						} else {

							System.out.println(player.name + " has chair");
						}
					}

					playerSet.remove(playerToRemove);

					if (allowedPermits > 0)
						allowedPermits = allowedPermits - 1;

				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				rounds = rounds - 1;

				for (Player player : playerSet) {
					player.semaphorTaburet.release();
					player.setHasChair(false);
				}

			} while (rounds >= 0);
			
			System.out.println(playerSet.stream().iterator().next().name + "  HAS WON!!!");

			System.out.println("GAME IS OVER");

			stopThread();
		}
	}
}
