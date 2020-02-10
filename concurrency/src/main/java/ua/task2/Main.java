package ua.task2;

public class Main {
    public static void main(String[] args) {

        Mine mine = new Mine();
        Warehouse warehouse = new Warehouse(0);
        Transporter transporter = new Transporter();
        LoaderWorker loader = new LoaderWorker(mine);
        UnloaderWorker unloader = new UnloaderWorker(warehouse);

        Cart cart = new Cart(loader, transporter,unloader);
        cart.transporterHasCart(false);
        cart.loaderHasCart(true);
        cart.unloaderHasCart(false);

        loader.setCart(cart);
        transporter.setCart(cart);
        unloader.setCart(cart);

        loader.start();
        transporter.start();
        unloader.start();


    }
}
