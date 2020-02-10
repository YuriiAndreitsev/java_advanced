package ua.task2;
public class Cart {
    protected LoaderWorker loaderWorker;
    protected Transporter transporter;
    protected UnloaderWorker unloaderWorker;
    private int gold;

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Cart(LoaderWorker loaderWorker, Transporter transporter, UnloaderWorker unloaderWorker) {
        this.loaderWorker = loaderWorker;
        this.transporter = transporter;
        this.unloaderWorker = unloaderWorker;
    }

    public void loaderHasCart(boolean bool) {
        loaderWorker.setOwnerOfCart(bool);
    }

    public void transporterHasCart(boolean bool) {
        transporter.setOwnerOfCart(bool);
    }

    public void unloaderHasCart(boolean bool) {
        unloaderWorker.setOwnerOfCart(bool);
    }
}
