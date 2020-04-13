public class PriceCalculator implements Runnable{

    private Invoice multhread;

    public PriceCalculator(Invoice invoice){

        this.multhread = invoice;

    }

    public void run(){

        System.out.println("Calculating Invoice ID : " + multhread.getId());
        multhread.setTotalPrice();
        System.out.println("Finish Calculating Invoice ID : " + multhread.getId());

    }

}
