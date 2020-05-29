package hosea.jfood;

/**
 * Class custom exception untuk mengendalikan invoice ketika ditemukan
 * masih ada ONGOING invoice
 *
 * @author Hosea Yoarana/ NPM: 1706042913
 * @version 27 Mei 2020
 */
public class OngoingInvoiceAlreadyExistExeption extends Exception
{
    private Invoice invoice_error;

    /**
     * constructor untuk mengatur keluaran jika ditemukan exception
     *
     * @param invoice_input
     */
    public OngoingInvoiceAlreadyExistExeption(Invoice invoice_input)
    {
        super("Invoice Status: ");
        invoice_error = invoice_input;
    }

    /**
     * method getMessage untuk menampilkan customer mana yang tidak ditemukan
     *
     * @return message
     */
    public String getMessage()
    {
        return super.getMessage() + invoice_error.getInvoiceStatus() + " already Exist.";
    }
}
