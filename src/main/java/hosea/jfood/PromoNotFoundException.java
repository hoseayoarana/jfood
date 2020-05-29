package hosea.jfood;

/**
 * Class custom exception untuk mengendalikan promo ketika tidak ditemukan
 * satupun promo yang dicari
 *
 * @author Hosea Yoarana/ NPM: 1706042913
 * @version 27 Mei 2020
 */
public class PromoNotFoundException extends Exception
{
    private int promo_error;

    /**
     * constructor untuk mengatur keluaran jika ditemukan exception
     *
     * @param promo_input
     */
    public PromoNotFoundException(int promo_input)
    {
        super("Promo ID: ");
        promo_error = promo_input;
    }

    /**
     * method getMessage untuk menampilkan customer mana yang tidak ditemukan
     *
     * @return message
     */
    public String getMessage()
    {
        return super.getMessage() + promo_error + " not found.";
    }
}
