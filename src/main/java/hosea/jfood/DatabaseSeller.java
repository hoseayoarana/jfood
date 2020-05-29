package hosea.jfood;
import java.util.ArrayList;

/**
 * Class DatabaseFood berisi listFood
 *
 * @author Hosea Yoarana
 * @version 27 Feb 2020
 */
public class DatabaseSeller
{
    private static ArrayList<Seller> SELLER_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    /**
     * Constructor untuk objek class DatabaseSeller
     */
    public DatabaseSeller()
    {
        
    }

    /**
     * method accessor yang digunakan untuk mengambil seluruh isi table seller
     * pada DB
     * @return SELLER_DATABASE
     */
    public static ArrayList<Seller> getSellerDatabase()
    {
        return SELLER_DATABASE;
    }

    /**
     * method yang digunakan mengambil ID terakhir yang ada
     * pada DB
     * @return id  terkahir pada DB
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * method yang digunakan untuk mengambil seller berdasarkan ID
     * pada DB
     * @param id
     * @return true apabila ditemukan, false apabila tidak ditemukan dan mengeluarkan exceptoin
     * @throws SellerNotFoundException
     */
    public static Seller getSellerById(int id) throws SellerNotFoundException
    {
        for(Seller s : SELLER_DATABASE) {
            if(s.getId() == id) {
                return s;
            }
        }
        throw new SellerNotFoundException(id);
    }

    /**
     * method yang digunakan untuk menambahkan seller pada DB
     * @param seller
     * @return seller
     */
    public static boolean addSeller(Seller seller)
    {
        SELLER_DATABASE.add(seller);
        lastId = seller.getId();
        return true;
    }

    /**
     * method yang digunakan untuk menghapus seller pada DB
     * @param id
     * @return true apabila dapat dihapus, false apabila tidak ditemukan dan mengeluarkan exception
     * @throws SellerNotFoundException
     */
    public static boolean removeSeller(int id) throws SellerNotFoundException
    {
        for(Seller s : SELLER_DATABASE) {
            if(s.getId() == id) {
                return false;
            }
        }
        throw new SellerNotFoundException(id);
    }
}
