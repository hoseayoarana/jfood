package hosea.jfood;

/**
 * Class yang digunakan untuk menetapkan PaymentType untuk setiap order yang akan dibuat
 *
 * @author Hosea Yoarana/ NPM: 1706042913
 * @version 27 Mei 2020
 */
public enum PaymentType
{
    CASH ("Cash"), CASHLESS ("Cashless");
    
    private String category;

    /**
     * method yang digunakan untuk menetapkan PaymentType dari order
     * @param category
     */
    private PaymentType(String category)
    {
        this.category = category;
    }
    
    public String toString()
    {
        return category;
    }
        
}
