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
    public CashlessInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus)
    {
        // initialise instance variables
        super(id, food, customer, invoiceStatus);
    }
    
    public CashlessInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus, Promo promo)
    {
        // initialise instance variables
        super(id, food, customer, invoiceStatus);
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
        if(promo != null && promo.getActive() == true && getFood().getPrice() >= promo.getMinPrice()){
            super.totalPrice = getFood().getPrice() - promo.getDiscount();
        }else{
            super.totalPrice = getFood().getPrice();
        }
        
    }
    
    /*
    public void printData()
    {
        System.out.println("============INVOICE============");
        System.out.println("ID: " +super.getId());
        System.out.println("Food: " +super.getFood().getName());
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
        String format = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        if(super.getDate() != null)
        {
            format = sdf.format(super.getDate().getTime());
        }
        
        if (promo != null && super.getFood().getPrice() >= promo.getMinPrice() && promo.getActive() == true)
        {
            return "============INVOICE============" +
        "\nId = " + super.getId() +  
        "\nFood = " + super.getFood().getName() + 
        "\nDate: " + format +
        "\nCustomer: " +super.getCustomer().getName() +
        "\nTotal Price: " + totalPrice +
        "\nStatus: " +super.getInvoiceStatus() +
        "\nPayment Type: " +PAYMENT_TYPE +
        "\nPromo: " +promo.getCode();
        }else{
            return "============INVOICE============" +
        "\nId = " + super.getId() +  
        "\nFood = " + super.getFood().getName() + 
        "\nDate: " + format +
        "\nCustomer: " +super.getCustomer().getName() +
        "\nTotal Price: " + totalPrice +
        "\nStatus: " +super.getInvoiceStatus() +
        "\nPayment Type: " +PAYMENT_TYPE +
        "\nPromo: tidak promo";
        }
    }
}
