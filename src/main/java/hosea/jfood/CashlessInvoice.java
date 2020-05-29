package hosea.jfood;
import java.lang.Object;
import java.util.*;
import java.util.regex.*;
import java.text.Format;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Class untuk membuat dan mendefinisikan invoice yang bersifat Cashless
 * @see Invoice
 *
 * @author Hosea Yoarana/ NPM: 1706042913
 * @version 27 Mei 2020
 */
public class CashlessInvoice extends Invoice
{
    private final static PaymentType PAYMENT_TYPE = PaymentType.CASHLESS;
    private Promo promo;

    /**
     * Constructor untuk objek class CashlessInvoice
     *
     * @param  id
     * @param foods
     * @param customer
     * @see Invoice
     */
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        super(id, foods, customer);
    }

    /**
     * Constructor untuk objek class CashlessInvoice
     *
     * @param  id
     * @param foods
     * @param customer
     * @param promo
     * @see Invoice
     */
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer, Promo promo)
    {
        super(id, foods, customer);
        this.promo = promo;
    }

    /**
     * Method accessor untuk mengambil Payment Type dari suatu invoice
     *
     * @return PAYMENT_TYPE
     */
    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }

    /**
     * Method accessor untuk mengambil promo dari suatu invoice
     *
     * @return promo
     */
    public Promo getPromo()
    {
        return promo;
    }

    /**
     * Method mutator untuk set promo untuk suatu invoice
     *
     * @param promo
     */
    public void setPromo(Promo promo)
    {
        this.promo = promo;
    }

    /**
     * Method mutator untuk set totalPrice untuk suatu invoice
     *
     */
    public void setTotalPrice()
    {
        super.totalPrice=0;
        for(Food foodList : getFoods()) {
            super.totalPrice=super.totalPrice+foodList.getPrice();
        }
        if (promo != null && getPromo().getActive() == true && super.totalPrice > getPromo().getMinPrice()) {
            super.totalPrice = super.totalPrice  - promo.getDiscount();
        }else {
            super.totalPrice = super.totalPrice + 0;
        }
        
    }

    public String toString()
    {
        String foods = "";
        for (Food foodList : getFoods()) {
            foods = foods + foodList.getName() + ", ";
        }
        foods = foods.substring(0, foods.length() - 2);
        setTotalPrice();
        String format = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        if(super.getDate() != null)
        {
            format = sdf.format(super.getDate().getTime());
        }

        if(promo == null || promo.getActive() == false || super.totalPrice  < getPromo().getMinPrice())
        {
            return "============INVOICE============" +
        "\nId = " + super.getId() +  
        "\nFood = " + foods +
        "\nDate: " + format +
        "\nCustomer: " +super.getCustomer().getName() +
        "\nTotal Price: " + totalPrice +
        "\nStatus: " +super.getInvoiceStatus() +
        "\nPayment Type: " +PAYMENT_TYPE +
        "\nPromo: " +promo.getCode();
        }else{
            return "============INVOICE============" +
        "\nId = " + super.getId() +  
        "\nFood = " + foods +
        "\nDate: " + format +
        "\nCustomer: " +super.getCustomer().getName() +
        "\nTotal Price: " + totalPrice +
        "\nStatus: " +super.getInvoiceStatus() +
        "\nPayment Type: " +PAYMENT_TYPE +
        "\nPromo: tidak promo";
        }
    }
}
