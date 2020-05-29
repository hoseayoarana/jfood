package hosea.jfood;

/**
 * Class yang digunakan untuk menghitung price untuk setiap order
 *
 * @author Hosea Yoarana/ NPM: 1706042913
 * @version 27 Mei 2020
 */
public class PriceCalculator implements Runnable{

    private Invoice multhread;

    /**
     * method yang digunakan untuk menghitung price berbarengan dengan pembuatan invoice
     * @param invoice
     */
    public PriceCalculator(Invoice invoice){

        this.multhread = invoice;

    }

    public void run()
    {
        System.out.println("Calculating Invoice ID : " + multhread.getId());
        multhread.setTotalPrice();
        System.out.println("Finish Calculating Invoice ID : " + multhread.getId());

    }

}
