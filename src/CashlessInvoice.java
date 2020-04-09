import java.lang.Object;
import java.util.*;
import java.util.regex.*;
import java.text.Format;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 * Write a description of class CashlessInvoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CashlessInvoice extends Invoice
{
    // instance variables - replace the example below with your own
    private final static PaymentType PAYMENT_TYPE = PaymentType.CASHLESS;
    private Promo promo;

    /**
     * Constructor for objects of class CashlessInvoice
     */
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        // initialise instance variables
        super(id, foods, customer);
    }
    
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer, Promo promo)
    {
        // initialise instance variables
        super(id, foods, customer);
        this.promo = promo;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public PaymentType getPaymentType()
    {
        // put your code here
        return PAYMENT_TYPE;
    }
    
    public Promo getPromo()
    {
        return promo;
    }
    
    public void setPromo(Promo promo)
    {
        this.promo = promo;
    }
    
    public void setTotalPrice()
    {
        super.totalPrice=0;
        for(Food foodList : getFoods())
        {
            super.totalPrice=super.totalPrice+foodList.getPrice();
        }
        if (promo != null && getPromo().getActive() == true && super.totalPrice > getPromo().getMinPrice())
        {
            super.totalPrice = super.totalPrice  - promo.getDiscount();
        }

        else {
            super.totalPrice = super.totalPrice + 0;
        }
        
    }
    
    /*
    public void printData()
    {
        System.out.println("============INVOICE============");
        System.out.println("ID: " +super.getId());
        System.out.println("Food: " +super.getFoods().getName());
        System.out.println("Date: " +super.getDate());
        System.out.println("Customer: " +super.getCustomer().getName());
        if (promo != null && super.getFood().getPrice() >= promo.getMinPrice() && promo.getActive() == true)
        {
            System.out.println("Promo: " +promo.getCode());
        }
        System.out.println("Total Price: " +totalPrice);
        System.out.println("Status: " +super.getInvoiceStatus());
        System.out.println("Payment Type: " +PaymentType.CASHLESS);
    }
    */
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
