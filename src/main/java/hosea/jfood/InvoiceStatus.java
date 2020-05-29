package hosea.jfood;

/**
 * Class yang digunakan untuk menetapkan invoiceStatus untuk setiap invoice
 *
 * @author Hosea Yoarana/ NPM: 1706042913
 * @version 27 Mei 2020
 */
public enum InvoiceStatus
{
    ONGOING("Ongoing"), FINISHED("Finished"), CANCELLED("Cancelled");
    
    private String status;

    /**
     * method yang digunakan untuk menetapkan status dari invoice
     * @param status
     */
    private InvoiceStatus(String status)
    {
        this.status = status;
    }
    
    public String toString()
    {
        return status;
    }
}
