package ua.task2;
public class UnloaderWorker extends Thread {

    private Cart cart;
    private boolean awaitingForUnloading;
    private boolean ownerOfCart;
    private Warehouse warehouse;
    private boolean finish =false;

    public void setFinish(boolean bool){
        this.finish = bool;
    }

    public UnloaderWorker(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public boolean isAwaitingForUnloading() {
        return awaitingForUnloading;
    }

    public void setAwaitingForUnloading(boolean awaitingForUnloading) {
        this.awaitingForUnloading = awaitingForUnloading;
    }

    public boolean isOwnerOfCart() {
        return ownerOfCart;
    }

    public void setOwnerOfCart(boolean ownerOfCart) {
        this.ownerOfCart = ownerOfCart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void run() {
        while (true) {
            synchronized (cart) {
                while (!isOwnerOfCart()) {
                    try {
                        cart.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    System.out.println("unloading gold");
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                unloadCart();
                if (finish == true){
                    finish();
                }

                cart.notifyAll();
            }
        }


    }

    public void unloadCart(){
        System.out.println("gold is unloaded");
        System.out.println("-----------------");
        setAwaitingForUnloading(false);
        cart.loaderWorker.setAwaitingForLoading(true);
        setOwnerOfCart(false);
        cart.transporter.setOwnerOfCart(true);
        warehouse.setGold(warehouse.getGold()+cart.getGold());
        cart.setGold(0);

        System.out.println(warehouse.getGold()+ " Gold is in a Warehouse");
    }

    public void finish(){
        System.exit(0);
    }


}
