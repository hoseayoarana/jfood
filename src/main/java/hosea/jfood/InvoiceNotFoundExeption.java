package hosea.jfood;

/**
 * Class custom exception untuk mengendalikan invoice ketika tidak ditemukan
 * satupun invoice yang dicari
 *
 * @author Hosea Yoarana/ NPM: 1706042913
 * @version 27 Mei 2020
 */
public class InvoiceNotFoundExeption extends Exception
{
    private int invoice_error;

    /**
     * constructor untuk mengatur keluaran jika ditemukan exception
     *
     * @param invoice_input
     */
    public InvoiceNotFoundExeption(int invoice_input)
    {
        super("Invoice ID: ");
        invoice_error = invoice_input;
    }

    /**
     * method getMessage untuk menampilkan customer mana yang tidak ditemukan
     *
     * @return message
     */
    public String getMessage()
    {
        return super.getMessage() + invoice_error  + " not found.";
    }
}
