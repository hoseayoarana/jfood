package hosea.jfood;
import java.util.ArrayList;

/**
 * Class DatabaseFood berisi listFood
 *
 * @author Hosea Yoarana
 * @version 27 Feb 2020
 */
public class DatabasePromo
{
    private static ArrayList<Promo> PROMO_DATABASE = new ArrayList<>();
    private static int lastId;
    public static ArrayList<Promo> getPromoDatabase()
    {
        return PROMO_DATABASE;
    }

    /**
     * method accessor untuk mendapatkan id terkahir yang ada pada DB
     * @return id terakhir dalam DB
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * method accessor yang digunakan untuk mengambil promo berdasarkan ID
     * pada DB
     * @param id
     * @return promo apabila ditemukan, apabila tidak maka keluar exception
     * @throws PromoNotFoundException
     */
    public static Promo getPromoById(int id) throws PromoNotFoundException
    {
        for(Promo p : PROMO_DATABASE) {
            if(p.getId() == id){
                return p;
            }
        }
        throw new PromoNotFoundException(id);
    }

    /**
     * method accessor yang digunakan untuk mengambil promo berdasarkan code
     * pada DB
     * @param code
     * @return promo apabila ditemukan, apabila tidak maka dianggap null
     */
    public static Promo getPromoByCode(String code)
    {
        for(Promo promo : PROMO_DATABASE) {
            if(promo.getCode().equals(code)) {
                return promo;
            }
        }
        return null;
    }

    /**
     * method yang digunakan untuk menambahkan promo
     * pada DB
     * @param promo
     * @return promo masuk ke DB
     * @throws PromoCodeAlreadyExistsException
     */
    public static boolean addPromo(Promo promo) throws PromoCodeAlreadyExistsException
    {
        for(Promo p : PROMO_DATABASE) {
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

    /**
     * method yang digunakan untuk mengaktifkan promo
     * @param id
     * @return active
     */
    public static boolean activePromo(int id)
    {
        for(Promo promo : PROMO_DATABASE) {
            if(promo.getId() == id) {
                promo.setActive(true);
                return true;
            }
        }
        return false;
    }

    /**
     * method yang digunakan untuk me-nonaktifkan promo
     * @param id
     * @return deactive
     */
    public static boolean deactivePromo(int id)
    {
        for (Promo promo : PROMO_DATABASE) {
            if (promo.getId() == id) {
                promo.setActive(false);
                return true;
            }
        }
        return false;
    }

    /**
     * method yang digunakan untuk menghapus promo
     * pada DB
     * @param id
     * @return true apabila dapat dihapus, false apabila tidak ditemukan dan mengeluarkan exception
     * @throws PromoNotFoundException
     */
    public static boolean removePromo(int id) throws PromoNotFoundException
    {
        for(Promo p : PROMO_DATABASE) {
            if(p.getId() == id) {
                return false;
            }
        }
        throw new PromoNotFoundException(id);
    }
}
