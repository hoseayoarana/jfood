package hosea.jfood;

/**
 * Class custom exception untuk mengendalikan promo ketika ditemukan
 * promo code yang sama
 *
 * @author Hosea Yoarana/ NPM: 1706042913
 * @version 27 Mei 2020
 */
public class PromoCodeAlreadyExistsException extends Exception
{
    private Promo promo_error;

    /**
     * constructor untuk mengatur keluaran jika ditemukan exception
     *
     * @param promo_input
     */
    public PromoCodeAlreadyExistsException(Promo promo_input)
    {
        super("Promo code: ");
        promo_error = promo_input;
    }

    /**
     * method getMessage untuk menampilkan customer mana yang tidak ditemukan
     *
     * @return message
     */
    public String getExMessage()
    {
        return super.getMessage() + promo_error.getCode() + " already exists.";
    }
}
