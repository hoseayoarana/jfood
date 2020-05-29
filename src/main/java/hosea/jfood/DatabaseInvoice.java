package hosea.jfood;
import java.util.ArrayList;

/**
 * Class DatabaseFood berisi listFood
 *
 * @author Hosea Yoarana
 * @version 27 Feb 2020
 */
public class DatabaseInvoice
{
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<>();
    private static int lastId;

    /**
     * Constructor untuk objek class DatabaseCustomer
     */
    public DatabaseInvoice()
    {

    }

    /**
     * method accessor yang digunakan untuk mengambil seluruh isi DB invoice
     * @return INVOICE_DATABASE
     */
    public static ArrayList<Invoice> getInvoiceDatabase()
    {
        return INVOICE_DATABASE;
    }

    /**
     * method yang digunakan untuk mengambil ID terkahir yang ada di DB
     * @return ID terakhir dalam DB
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * method accessor yang digunakan untuk mengambil invoice berdasarkan ID pada DB
     * @param id
     * @return invoice berdasarkan ID
     * @throws InvoiceNotFoundExeption
     */
    public static Invoice getInvoiceById(int id) throws InvoiceNotFoundExeption
    {
        for(Invoice invoice : INVOICE_DATABASE) {
            if(invoice.getId() == id){
                return invoice;
            }
        }
        throw new InvoiceNotFoundExeption(id);
    }

    /**
     * method accessor yang digunakan untuk mengambil invoice berdasarkan customer
     * @param customerId
     * @return invoice dari customer
     */
    public static ArrayList<Invoice> getInvoiceByCustomer(int customerId)
    {
        ArrayList<Invoice> ini = new ArrayList<Invoice>();
        for(Invoice invoice : INVOICE_DATABASE) {
            if(invoice.getCustomer().getId() == customerId) {
                ini.add(invoice);
            }
        }
        if(ini.isEmpty()) {
            return null;
        }
        return ini;
    }

    /**
     * method yang digunakan untuk menambahkan invoice pada DB
     * @param invoice
     * @return true apabila dapat masuk, false ketika invoice sudah ada dan mengeluarkan exception
     * @throws OngoingInvoiceAlreadyExistExeption
     */
    public static boolean addInvoice(Invoice invoice) throws OngoingInvoiceAlreadyExistExeption
    {
        for(Invoice i : INVOICE_DATABASE)
        {
            if(i.getInvoiceStatus().equals(invoice.getInvoiceStatus())){
                throw new OngoingInvoiceAlreadyExistExeption(invoice);
            }
        }
        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;
    }

    /**
     * method yang digunakan untuk mengubah invoicestatus dari ONGOING ke FINISHED atau CANCELLED
     * @param id
     * @param invoiceStatus
     * @return invoiceStatus yang sudah berubah
     */
    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus)
    {
        for(Invoice invoice : INVOICE_DATABASE) {
            if(invoice.getId() == id && invoice.getInvoiceStatus().equals(InvoiceStatus.ONGOING)) {
                invoice.setInvoiceStatus(invoiceStatus);
                return true;
            }
        }
        return false;
    }

    /**
     * method yang digunakan untuk menghapus invoice yang sudah ada dalam DB
     * @param id
     * @return true apabila dapat dihapus, false apabila tidak ditemukan dan mengeluarkan exception
     * @throws InvoiceNotFoundExeption
     */
    public static boolean removeInvoice(int id) throws InvoiceNotFoundExeption
    {
        for(Invoice i : INVOICE_DATABASE)
        {
            if(i.getId() == id){
                return false;
            }
        }
        throw new InvoiceNotFoundExeption(id);
    }
}
