package hosea.jfood.controller;

import hosea.jfood.*;
import jdk.jfr.Category;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

/**
 * Merupakan class yang mengatur simple web application untuk Food.
 * Kelas ditandai sebagai @ RestController,
 * artinya siap digunakan oleh Spring MVC untuk menangani permintaan web.
 * @ RequestMapping maps / ke metode index (). Ketika dipanggil dari browser
 * atau dengan menggunakan url pada baris perintah, metode mengembalikan teks.
 *
 * @author Hosea Yoarana/ NPM: 1706042913
 * @version 27 Mei 2020
 */
@CrossOrigin(origins = "", allowedHeaders = "")
@RestController
public class FoodController {

    /**
     * Method yang digunakan untuk menghubungkan informasi seluruh food pada database food
     *
     * @RequestMapping /food dengan method GET
     * @return  Informasi seluruh food pada database food
     */
    @RequestMapping(value = "/food", method = RequestMethod.GET)
    public ArrayList<Food> getAllFood()
    {
        return DatabaseFoodPostgre.getFoodDatabase();
    }

    /**
     * Method yang digunakan untuk menghubungkan ID food pada database.
     * Method ini digunakan dalam mengambil food berdasarkan ID nya.
     *
     * @RequestMapping /food/{id} dengan method GET
     * @PathVariable int id
     * @return  ID food pada database food
     */
    @RequestMapping(value = "/food/{id}", method = RequestMethod.GET)
    public Food getFoodById(@PathVariable int id)
    {
        Food food = null;
        try {
            food = DatabaseFoodPostgre.getFoodById(id);
        }
        catch (FoodNotFoundException notfound) {
            System.out.println(notfound.getMessage());
        }
        return food;
    }

    /**
     * Method yang digunakan untuk menghubungkan informasi seluruh food pada database food
     * yang dimiliki oleh seller tertentu
     *
     * @RequestMapping /food/seller/{sellerId} degan method GET
     * @PathVariable int sellerId
     * @return  Informasi seluruh food berdasarkan sellerId pada database food
     */
    @RequestMapping(value = "/food/seller/{sellerId}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodBySeller(@PathVariable int sellerId)
    {
        return DatabaseFoodPostgre.getFoodBySeller(sellerId);
    }

    /**
     * Method yang digunakan untuk menghubungkan ID food pada database.
     * Method ini digunakan dalam mengambil food berdasarkan kategori nya.
     *
     * @RequestMapping /food/category/{category} dengan method GET
     * @PathVariable FoodCategory category
     * @return  ID food pada database food
     */
    @RequestMapping(value = "/food/category/{category}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodByCategory(@PathVariable FoodCategory category)
    {
        return DatabaseFood.getFoodByCategory(category);
    }

    /**
     * Method yang digunakan untuk menghubungkan ketika menambahkan food baru.
     *
     * @RequestMapping /food dengan method POST
     * @RequestParam name, price, category, sellerId
     * @return  food ke DatabaseFoodPostgre
     */
    @RequestMapping(value = "/food", method = RequestMethod.POST)
    public Food addFood(@RequestParam(value="name") String name,
                        @RequestParam(value="price") int price,
                        @RequestParam(value="category") FoodCategory category,
                        @RequestParam(value="sellerId") int sellerId)
    {
        Food food = null;
        try {
            food = new Food(DatabaseFoodPostgre.getLastId() + 1, name, DatabaseSellerPostgre.getSellerById(sellerId), price, category);
            DatabaseFoodPostgre.addFood(food);
        } catch (SellerNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return food;
    }
}