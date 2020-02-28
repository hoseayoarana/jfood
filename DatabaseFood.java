
/**
 * Class DatabaseFood berisi listFood
 *
 * @author Hosea Yoarana
 * @version 27-02-2020
 */
public class DatabaseFood
{
    // bagian ini berisi variabel yang nantinya digunakan sebagai parameter objek
    private String[] listFood;      //string dari listFood

    /**
     * Inisiasi variabel kedalam method public untuk datatype DatabaseFood
     */
    public DatabaseFood()
    {
        
    }
    
    /**
     * method addFood untuk menambahkan food
     * @param food      food dari DatabaseFood
     * @return true     mengembalikan true
     */
    public boolean addFood(Food food)
    {
        return true;
    }
    
    /**
     * method removeFood untuk menghilangkan food
     * @param food      food dari DatabaseFood
     * @return true     mengembalikan true
     */
    public boolean removeFood(Food food)
    {
        return true;
    }
    
    /**
     * method getFood untuk mengambil food
     * @return null     mengembalikan null
     */
    public Food getFood()
    {
        return null;
    }
    
    /**
     * accessor getListFood untuk memanggil listFood
     * @return listFood     mengembalikan listFood
     */
    public String[] getListFood()
    {
        return listFood;
    }
}
