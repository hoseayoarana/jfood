package hosea.jfood;

/**
 * Class custom exception untuk mengendalikan seller ketika tidak ditemukan
 * satupun seller yang dicari
 *
 * @author Hosea Yoarana/ NPM: 1706042913
 * @version 27 Mei 2020
 */
public class SellerNotFoundException extends Exception
{
    private int seller_error;

    /**
     * constructor untuk mengatur keluaran jika ditemukan exception
     *
     * @param seller_input
     */
    public SellerNotFoundException(int seller_input)
    {
        super("Seller ID: ");
        seller_error = seller_input;
    }

    /**
     * method getMessage untuk menampilkan customer mana yang tidak ditemukan
     *
     * @return message
     */
    public String getMessage()
    {
        return super.getMessage() + seller_error + " not found.";
    }
}
