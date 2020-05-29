package hosea.jfood;

/**
 * Class custom exception untuk mengendalikan food ketika tidak ditemukan
 * satupun food yang dicari
 *
 * @author Hosea Yoarana/ NPM: 1706042913
 * @version 27 Mei 2020
 */
public class FoodNotFoundException extends Exception
{
    private int food_error;

    /**
     * constructor untuk mengatur keluaran jika ditemukan exception
     *
     * @param food_input
     */
    public FoodNotFoundException( int food_input)
    {
        super("Food ID: ");
        food_error = food_input;
    }

    /**
     * method getMessage untuk menampilkan customer mana yang tidak ditemukan
     *
     * @return message
     */
    public String getMessage()
    {
        return super.getMessage() + food_error + " not found.";
    }
}
