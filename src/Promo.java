
/**
 * Write a description of class Promo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Promo
{
    // instance variables - replace the example below with your own
    private int id;
    private String code;
    private int discount;
    private int minPrice;
    private boolean active;

    /**
     * Constructor for objects of class Promo
     */
    public Promo(int id, String code, int discount, int minPrice, boolean active)
    {
        // initialise instance variables
        this.id = id;
        this.code = code;
        this.discount = discount;
        this.minPrice = minPrice;
        this.active = active;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getId()
    {
        // put your code here
        return id;
    }
    
    public String getCode()
    {
        return code;
    }
    
    public int getDiscount()
    {
        return discount;
    }
    
    public int getMinPrice()
    {
        return minPrice;
    }
    
    public boolean getActive()
    {
        return active;
    }
    
    public void setId()
    {
        this.id = id;
    }
    
    public void setCode()
    {
        this.code = code;
    }
    
    public void setDiscount()
    {
        this.discount = discount;
    }
    
    public void setMinPrice()
    {
        this.minPrice = minPrice;
    }
    
    public void setActive(boolean b)
    {
        this.active = active;
    }
    
    public void printData()
    {
        System.out.println("===========Promo===========");
        System.out.println("ID : "+id);
        System.out.println("Code : "+code);
        System.out.println("Discount : "+discount);
        System.out.println("Min Price : "+minPrice);
        System.out.println("Active : "+active);
    }
    
    public String toString()
    {
        return "Id = " + getId() + 
        "\nCode = " + getCode() + 
        "\nDiscount = " + getDiscount() + 
        "\nMin Price = " + getMinPrice() + 
        "\nActive Status= " + getActive();
    }
}
