package ua.task2;
public class Transporter extends Thread {
    private Cart cart;
    private Boolean ownerOfCart;

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public boolean getOwnerOfCart() {
        return ownerOfCart;
    }

    public void setOwnerOfCart(boolean ownerOfCart) {
        this.ownerOfCart = ownerOfCart;
    }

    public void run() {
        while (true) {

            synchronized (cart) {
                while (getOwnerOfCart() != true) {
                    try {
                        cart.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    giveCart();
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cart.notifyAll();
            }
        }
    }

    public void giveCart(){
        if (cart.unloaderWorker.isAwaitingForUnloading()){
            giveCartToUnloader();
        }else giveCartToLoader();
    }

    public void giveCartToLoader(){
        cart.loaderWorker.setOwnerOfCart(true);
        setOwnerOfCart(false);
        System.out.println("going to load gold");
        System.out.println("------------");
    }

    public void giveCartToUnloader(){
        setOwnerOfCart(false);
        cart.unloaderWorker.setOwnerOfCart(true);
        System.out.println("going to unload gold");
        System.out.println("------------------");
    }
}
