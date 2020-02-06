package task1;

public class Customer {
	 private volatile boolean exit = false;

	 public void stop(){
	        exit = true;
	    }

	public Customer() {

		Thread t = new Thread(r);
		t.setDaemon(true);
		t.start();
	}

	Runnable r = () -> {		
		while (!exit) {
			
		}
	};
}
