package ua.itea;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		FatCat fc = new FatCat("Fat1", "red", 2);
		HomelessCat hc = new HomelessCat("Homeless1", "black", 2);
		CleanCat cc = new CleanCat("Clean1", "white", 2);
		
		Class[] cats = new Class[] { fc.getClass(), hc.getClass(), cc.getClass() };
//		Class[] cats = new Class[] { FatCat.class, HomelessCat.class, CleanCat.class };
		CatFactory factory = new CatFactory();

		factory.produceFarsh(cats);
	}
}
