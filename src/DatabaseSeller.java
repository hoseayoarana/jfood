import java.util.ArrayList;

/**
 * Write a description of class DatabaseSeller here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DatabaseSeller
{
    // instance variables - replace the example below with your own
    private static ArrayList<Seller> SELLER_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    /**
     * Constructor for objects of class DatabaseSeller
     */
    public DatabaseSeller()
    {
        // initialise instance variables
        
    }

    public static ArrayList<Seller> getSellerDatabase()
    {
        return SELLER_DATABASE;
    }

    public static int getLastId()
    {
        return lastId;
    }

    public static Seller getSellerById(int id)
    {
        for(Seller seller : SELLER_DATABASE)
        {
            if(seller.getId() == id)
            {
                return seller;
            }
        }
        return null;
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  seller  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static boolean addSeller(Seller seller)
    {
        // put your code here
        SELLER_DATABASE.add(seller);
        lastId = seller.getId();
        return true;
    }
    
    public static boolean removeSeller(int id)
    {
        for(Seller seller : SELLER_DATABASE)
        {
            if(seller.getId() == id)
            {
                SELLER_DATABASE.remove(seller);
                return true;
            }
        }
        return false;
    }
    
//    public static Seller getSeller()
//    {
//        return null;
//    }
//
//    public static String[] getListSeller()
//    {
//        return listSeller;
//    }
    
}
