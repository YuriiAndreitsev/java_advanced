package ua.itea.lesson8;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws InterruptedException {

		Exchanger<Cart> fromLoaderToTransporter = new Exchanger<Cart>();
		Exchanger<Cart> fromTransporterToUnloader = new Exchanger<Cart>();

		GoldMine goldMine = new GoldMine(100);
		Cart cart = new Cart();
		Warehouse warehouse = new Warehouse();

		Loader loader = new Loader(goldMine, cart, fromLoaderToTransporter);
		Transporter transporter = new Transporter(cart, fromLoaderToTransporter, fromTransporterToUnloader);
		Unloader unloader = new Unloader(warehouse, cart, fromTransporterToUnloader);

		ExecutorService es = Executors.newFixedThreadPool(3);

		es.execute(loader);
		es.execute(transporter);
		es.execute(unloader);
		
		es.shutdown();
		
		
//		TimeUnit.SECONDS.sleep(3);		
//		System.out.println(Thread.activeCount());
//		
//		System.out.println("MAIN FINISHED");
	}
}
