package hosea.jfood;
/**
 * Enumeration class PaymentType - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum PaymentType
{
    CASH ("Cash"), CASHLESS ("Cashless");
    
    private String category;
    
    private PaymentType(String category)
    {
        this.category = category;
    }
    
    public String toString()
    {
        return category;
    }
        
}
