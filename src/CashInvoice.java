import java.lang.Object;
import java.util.*;
import java.util.regex.*;
import java.text.Format;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 * Write a description of class CashInvoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CashInvoice extends Invoice
{
    // instance variables - replace the example below with your own
    private final static PaymentType PAYMENT_TYPE = PaymentType.CASH;
    private int deliveryFee;

    /**
     * Constructor for objects of class CashlessInvoice
     */
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        // initialise instance variables
        super(id,foods,customer);
    }
    
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer,  int deliveryFee)
    {
        // initialise instance variables
        super(id, foods, customer);
        this.deliveryFee = deliveryFee;
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
    
    public int getDeliveryFee()
    {
        return deliveryFee;
    }
    
    public void setDeliveryFee(int deliveryFee)
    {
        this.deliveryFee = deliveryFee;
    }
    
    public void setTotalPrice()
    {
        super.totalPrice=0;
        for(Food foodList : getFoods())
        {
            super.totalPrice=super.totalPrice+foodList.getPrice();
        }
        super.totalPrice=super.totalPrice+deliveryFee;
        
    }
    
    /*public void printData()
    {
        System.out.println("============INVOICE============");
        System.out.println("ID: " +super.getId());
        System.out.println("Food: " +super.getFoods().getName());
        System.out.println("Date: " +super.getDate());
        System.out.println("Customer: " +super.getCustomer().getName());
        if (deliveryFee != 0)
        {
            System.out.println("Delivery Fee: " +deliveryFee);
        }
        System.out.println("Total Price: " +totalPrice);
        System.out.println("Status: " +super.getInvoiceStatus());
        System.out.println("Payment Type: " +PaymentType.CASH);
    }*/
    
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
