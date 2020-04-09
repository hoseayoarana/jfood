import java.util.ArrayList;

/**
 * Write a description of class DatabasePromo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DatabasePromo
{
    // instance variables - replace the example below with your own
    private static ArrayList<Promo> PROMO_DATABASE = new ArrayList<>();
    private static int lastId;

    /**
     * Constructor for objects of class DatabasePromo
     */
    /*public DatabasePromo()
    {
        // initialise instance variables
        
    }
    */
    public static ArrayList<Promo> getPromoDatabase()
    {
        return PROMO_DATABASE;
    }

    public static int getLastId()
    {
        return lastId;
    }

    public static Promo getPromoById(int id) throws PromoNotFoundException
    {
        for(Promo p : PROMO_DATABASE)
        {
            if(p.getId() == id){
                return p;
            }
        }
        throw new PromoNotFoundException(id);
    }

    public static Promo getPromoByCode(String code)
    {
        for(Promo promo : PROMO_DATABASE)
        {
            if(promo.getCode().equals(code))
            {
                return promo;
            }
        }
        return null;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  promo  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static boolean addPromo(Promo promo) throws PromoCodeAlreadyExistsException
    {
        for(Promo p : PROMO_DATABASE)
        {
            for(int i = 0; i < PROMO_DATABASE.size(); i++){
                if(promo.getCode().equals(PROMO_DATABASE.get(i).getCode())){
                    throw new PromoCodeAlreadyExistsException(promo);
                }
            }
        }
        PROMO_DATABASE.add(promo);
        lastId = promo.getId()+1;
        return true;
    }

    public static boolean activePromo(int id)
    {
        for(Promo promo : PROMO_DATABASE)
        {
            if(promo.getId() == id)
            {
                promo.setActive(true);
                return true;
            }
        }
        return false;
    }

    public static boolean deactivePromo(int id)
    {
        for (Promo promo : PROMO_DATABASE) {
            if (promo.getId() == id)
            {
                promo.setActive(false);
                return true;
            }
        }
        return false;
    }
    public static boolean removePromo(int id) throws PromoNotFoundException
    {
        for(Promo p : PROMO_DATABASE)
        {
            if(p.getId() == id){
                return false;
            }
        }
        throw new PromoNotFoundException(id);
    }

//    public static boolean getPromo()
//    {
//        return true;
//    }
//
//    public static boolean removePromo()
//    {
//        return true;
//    }
//
//    public static String[] getListPromo()
//    {
//        return listPromo;
//    }
    
    
    
}
