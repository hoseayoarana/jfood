package hosea.jfood;

/**
 * Class custom exception untuk mengendalikan customer ketika tidak ditemukan
 * satupun customer yang dicari
 *
 * @author Hosea Yoarana/ NPM: 1706042913
 * @version 27 Mei 2020
 */
public class CustomerNotFoundException extends Exception
{
    private int customer_error;

    /**
     * constructor untuk mengatur keluaran jika ditemukan exception
     *
     * @param customer_input
     */
    public CustomerNotFoundException(int customer_input)
    {
        super("Customer ID: ");
        customer_error = customer_input;
    }

    /**
     * method getMessage untuk menampilkan customer mana yang tidak ditemukan
     *
     * @return message
     */
    public String getMessage()
    {
        return super.getMessage() + customer_error + " not found.";
    }
}
