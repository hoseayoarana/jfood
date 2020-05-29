package hosea.jfood;

/**
 * Class custom exception untuk mengendalikan email ketika ditemukan
 * email yang sama
 *
 * @author Hosea Yoarana/ NPM: 1706042913
 * @version 27 Mei 2020
 */
public class EmailAlreadyExistsException extends Exception
{
    private Customer customer_error;

    /**
     * constructor untuk mengatur keluaran jika ditemukan exception
     *
     * @param customer_input
     */
    public EmailAlreadyExistsException(Customer customer_input)
    {
        super("Customer Email: ");
        customer_error = customer_input;
    }

    /**
     * method getMessage untuk menampilkan customer mana yang tidak ditemukan
     *
     * @return message
     */
    public String getExMessage()
    {
        return super.getMessage() + customer_error.getEmail() +  " already exists.";
    }
}
