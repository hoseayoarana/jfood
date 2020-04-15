package hosea.jfood;
import java.util.ArrayList;

/**
 * Class DatabaseFood berisi listFood
 *
 * @author Hosea Yoarana
 * @version 27-02-2020
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

    public static ArrayList<Food> getFoodDatabase()
    {
        return FOOD_DATABASE;
    }

    public static int getLastId()
    {
        return lastId;
    }

    public static Food getFoodById(int id) throws FoodNotFoundException
    {
        for(Food f : FOOD_DATABASE)
        {
            if(f.getId() == id){
                return f;
            }
        }
        throw new FoodNotFoundException(id);
    }

    public static ArrayList<Food> getFoodBySeller(int sellerId)
    {
        ArrayList<Food> foodList = new ArrayList<Food>();
        for (Food food : FOOD_DATABASE)
        {
            if (food.getSeller().getId() == sellerId)
            {
                foodList.add(food);
            }
        }
        return foodList;
    }

    public static ArrayList<Food> getFoodByCategory(FoodCategory category)
    {
        ArrayList<Food> foodList = new ArrayList<Food>();
        for (Food food : FOOD_DATABASE)
        {
            if (food.getCategory() == category)
            {
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
        for(Food f : FOOD_DATABASE)
        {
            if(f.getId() == id){
                return false;
            }
        }
        throw new FoodNotFoundException(id);
    }
    
    /**
     * method getFood untuk mengambil food
     * @return null     mengembalikan null
     */
//    public static Food getFood()
//    {
//        return null;
//    }
//
//    /**
//     * accessor getListFood untuk memanggil listFood
//     * @return listFood     mengembalikan listFood
//     */
//    public static String[] getListFood()
//    {
//        return listFood;
//    }
}
