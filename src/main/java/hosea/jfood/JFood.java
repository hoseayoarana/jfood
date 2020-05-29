package hosea.jfood;
import java.lang.Object;
import java.util.*;
import java.util.regex.*;
import java.text.Format;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Class JFood berisi objek dari seluruh class yang ada dalam project
 *
 * @author Hosea Yoarana
 * @version 27 Feb 2020
 */
@SpringBootApplication
public class JFood
{
    /**
     * Inisiasi variabel kedalam method public untuk datatype JFood
     * @param  args     mengambil argumen sebelumnya
     * @return Nothing.         mengembalikan Nothing
     */
    public static void main(String[] args)
    {
        Location location1 = new Location("JakTim", "DKI Jakarta", "Penjual Tes 3");

        DatabaseSellerPostgre.addSeller(new Seller(DatabaseSellerPostgre.getLastId()+1, "Jaya Banget", "jaya.banget@jfood.com", "081212345678", location1));

        try{
            DatabaseFoodPostgre.addFood(new Food(DatabaseFoodPostgre.getLastId() + 1, "Nasi Goreng Jaya", DatabaseSellerPostgre.getSellerById(3), 10000, FoodCategory.RICE));
        }
        catch (SellerNotFoundException notfound) {
            System.out.println(notfound.getMessage() + "\n");
        }

        try{
            DatabaseFoodPostgre.addFood(new Food(DatabaseFoodPostgre.getLastId()+1, "Sushay(Temen Sushi)", DatabaseSellerPostgre.getSellerById(3), 50000, FoodCategory.JAPANESE));
        }
        catch (SellerNotFoundException notfound) {
            System.out.println(notfound.getMessage() + "\n");
        }

        try {
            DatabaseFoodPostgre.addFood(new Food(DatabaseFoodPostgre.getLastId()+1, "Roti Jawa", DatabaseSellerPostgre.getSellerById(3), 20000, FoodCategory.BAKERY));
        } catch (SellerNotFoundException e) {
            e.printStackTrace();
        }

//        try {
//            DatabasePromoPostgre.addPromo(new Promo(DatabasePromoPostgre.getLastId()+1, "hoho", 2000, 1, true));
//        } catch (PromoCodeAlreadyExistsException e) {
//            e.printStackTrace();
//        }
        SpringApplication.run(JFood.class, args);
    }
}
