package hosea.jfood;
import java.util.ArrayList;

/**
 * Class DatabaseFood berisi listFood
 *
 * @author Hosea Yoarana
 * @version 27 Feb 2020
 */
public class DatabaseFood
{
    // bagian ini berisi variabel yang nantinya digunakan sebagai parameter objek
    private static ArrayList<Food> FOOD_DATABASE = new ArrayList<>();      //string dari listFood
    private static int lastId;
    /**
     * Inisiasi variabel kedalam method public untuk datatype DatabaseFood
     */
    public DatabaseFood()
    {

    }

    /**
     * method accessor untuk mengambil keseluruhan isi dari database food
     * @return DB food
     */
    public static ArrayList<Food> getFoodDatabase()
    {
        return FOOD_DATABASE;
    }

    /**
     * method accessor untuk mengambil ID terakhir yang ada pada DB
     * @return lastId pada DB
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * method accessor untuk mengambil food berdasarkan Id pada DB
     * @param id
     * @return food ketika ditemukan yang sama dengan Id yang diminta
     * @throws FoodNotFoundException
     */
    public static Food getFoodById(int id) throws FoodNotFoundException
    {
        for(Food f : FOOD_DATABASE) {
            if(f.getId() == id){
                return f;
            }
        }
        throw new FoodNotFoundException(id);
    }

    /**
     * method accessor yang digunakan untuk mengambil food berdasarkan seller pada DB
     * @param sellerId
     * @return list food yang dimiliki oleh seller tertentu
     */
    public static ArrayList<Food> getFoodBySeller(int sellerId)
    {
        ArrayList<Food> foodList = new ArrayList<Food>();
        for (Food food : FOOD_DATABASE) {
            if (food.getSeller().getId() == sellerId) {
                foodList.add(food);
            }
        }
        return foodList;
    }

    /**
     * method accessor yang digunakan untuk mengambil food berdasarkan category pada DB
     * @param category
     * @return list food berdasarkan category
     */
    public static ArrayList<Food> getFoodByCategory(FoodCategory category)
    {
        ArrayList<Food> foodList = new ArrayList<Food>();
        for (Food food : FOOD_DATABASE) {
            if (food.getCategory() == category) {
                foodList.add(food);
            }
        }
        return foodList;
    }

    /**
     * method addFood untuk menambahkan food
     * @param food      food dari DatabaseFood
     * @return true     mengembalikan true
     */
    public static boolean addFood(Food food)
    {
        FOOD_DATABASE.add(food);
        lastId = food.getId();
        return true;
    }
    
    /**
     * method removeFood untuk menghilangkan food
     * @param id      food dari DatabaseFood
     * @return true     mengembalikan true
     */
    public static boolean removeFood(int id) throws FoodNotFoundException
    {
        for(Food f : FOOD_DATABASE) {
            if(f.getId() == id){
                return false;
            }
        }
        throw new FoodNotFoundException(id);
    }
}
