import java.util.ArrayList;

/**
 * Write a description of class DatabaseCustomer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DatabaseInvoice
{
    // instance variables - replace the example below with your own
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<>();
    private static int lastId;

    /**
     * Constructor for objects of class DatabaseCustomer
     */
    public DatabaseInvoice()
    {
        // initialise instance variables

    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */

    public static ArrayList<Invoice> getInvoiceDatabase()
    {
        return INVOICE_DATABASE;
    }

    public static int getLastId()
    {
        return lastId;
    }

    public static Invoice getInvoiceById(int id)
    {
        for(Invoice invoice : INVOICE_DATABASE)
        {
            if(invoice.getId() == id)
            {
                return invoice;
            }
        }
        return null;
    }

    public static ArrayList<Invoice> getInvoiceByCustomer(int customerId)
    {
        ArrayList<Invoice> ini = new ArrayList<Invoice>();
        for(Invoice invoice : INVOICE_DATABASE)
        {
            if(invoice.getId() == customerId)
            {
                ini.add(invoice);
            }
        }
        if(ini.isEmpty())
        {
            return null;
        }
        return ini;
    }

    public static boolean addInvoice(Invoice invoice)
    {
        for(Invoice ini : INVOICE_DATABASE)
        {
            if(ini.getInvoiceStatus().equals(InvoiceStatus.ONGOING))
            {
                return false;
            }
        }
        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;
    }

    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus)
    {
        for(Invoice invoice : INVOICE_DATABASE)
        {
            if(invoice.getId() == id && invoice.getInvoiceStatus().equals(InvoiceStatus.ONGOING))
            {
                invoice.setId(id);
                invoice.setInvoiceStatus(InvoiceStatus.ONGOING);
                return true;
            }
        }
        return false;
    }

    public static boolean removeCustomer(int id)
    {
        for(Invoice invoice : INVOICE_DATABASE)
        {
            if(invoice.getId() == id)
            {
                INVOICE_DATABASE.remove(invoice);
                return true;
            }
        }
        return false;
    }
}
