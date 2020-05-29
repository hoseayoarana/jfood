package hosea.jfood;
import java.lang.Object;
import java.util.*;
import java.util.regex.*;
import java.text.Format;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Class untuk membuat dan mendefinisikan invoice yang bersifat Cash
 * @see Invoice
 *
 * @author Hosea Yoarana/ NPM: 1706042913
 * @version 27 Mei 2020
 */
public class CashInvoice extends Invoice
{
    private final static PaymentType PAYMENT_TYPE = PaymentType.CASH;
    private int deliveryFee;

    /**
     * Constructor untuk objek class CashInvoice
     *
     * @param  id
     * @param customer
     * @param foods
     * @see Invoice
     */
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        super(id,foods,customer);
    }

    /**
     * Constructor untuk objek class CashInvoice
     *
     * @param  id
     * @param customer
     * @param foods
     * @param deliveryFee
     * @see Invoice
     */
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer,  int deliveryFee)
    {
        super(id, foods, customer);
        this.deliveryFee = deliveryFee;
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
     * Method accessor untuk mengambil deliveryFee dari suatu invoice
     *
     * @return deliveryFee
     */
    public int getDeliveryFee()
    {
        return deliveryFee;
    }

    /**
     * Method mutator untuk set deliveryFee untuk suatu invoice
     *
     * @param deliveryFee
     */
    public void setDeliveryFee(int deliveryFee)
    {
        this.deliveryFee = deliveryFee;
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
        super.totalPrice=super.totalPrice+deliveryFee;
        
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
        
        if (deliveryFee != 0)
        {
            return "============INVOICE============" +
        "\nId = " + super.getId() +  
        "\nFood = " + foods +
        "\nDate: " + format +
        "\nCustomer: " +super.getCustomer().getName() +
        "\nTotal Price: " + totalPrice +
        "\nStatus: " +super.getInvoiceStatus() +
        "\nPayment Type: " +PAYMENT_TYPE +
        "\nDelivery Fee: " +deliveryFee;
        }else{
            return "============INVOICE============" +
        "\nId = " + super.getId() +  
        "\nFood = " + foods +
        "\nDate: " + format +
        "\nCustomer: " +super.getCustomer().getName() +
        "\nTotal Price: " + totalPrice +
        "\nStatus: " +super.getInvoiceStatus() +
        "\nPayment Type: " +PAYMENT_TYPE +
        "\nDelivery Fee: 0";
        }
    }
}
