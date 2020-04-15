package hosea.jfood;
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

    public static Seller getSellerById(int id) throws SellerNotFoundException
    {
        for(Seller s : SELLER_DATABASE)
        {
            if(s.getId() == id){
                return s;
            }
        }
        throw new SellerNotFoundException(id);
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
    
    public static boolean removeSeller(int id) throws SellerNotFoundException
    {
        for(Seller s : SELLER_DATABASE)
        {
            if(s.getId() == id){
                return false;
            }
        }
        throw new SellerNotFoundException(id);
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
