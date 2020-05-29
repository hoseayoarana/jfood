package hosea.jfood.controller;

import hosea.jfood.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

/**
 * Merupakan class yang mengatur simple web application untuk seller.
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
public class SellerController
{
    /**
     * Method yang digunakan untuk menghubungkan informasi seluruh seller pada database seller
     *
     * @RequestMapping /seller
     * @return  Informasi seluruh seller pada database seller
     */
    @RequestMapping(value = "/seller", method = RequestMethod.GET)
    public ArrayList<Seller> getAllSeller()
    {
        return DatabaseSellerPostgre.getSellerDatabase();
    }

    /**
     * Method yang digunakan untuk menghubungkan ID seller pada database.
     * Method ini digunakan dalam mengambil seller berdasarkan ID nya.
     *
     * @RequestMapping /{id}
     * @PathVariable int id
     * @return  ID customer pada database customer
     */
    @RequestMapping(value = "/seller/{id}", method = RequestMethod.GET)
    public Seller getSellerById(@PathVariable int id)
    {
        Seller seller = null;
        try {
            seller = DatabaseSellerPostgre.getSellerById(id);
        }
        catch (SellerNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return seller;
    }

    /**
     * Method yang digunakan untuk menghubungkan ketika menambahkan seller baru.
     *
     * @RequestMapping /seller
     * @RequestParam name, email, email, phonenumber, province, description, city
     * @return  customer ke DatabaseCustomerPostgre
     */
    @RequestMapping(value = "/seller", method = RequestMethod.POST)
    public Seller addSeller(@RequestParam(value="name") String name,
                        @RequestParam(value="email") String email,
                        @RequestParam(value="phoneNumber") String phoneNumber,
                        @RequestParam(value="province") String province,
                        @RequestParam(value="description") String description,
                        @RequestParam(value="city") String city)
    {
        Seller seller = new Seller(DatabaseSellerPostgre.getLastId() + 1, name, email, phoneNumber, new Location(province, city, description));
        if(DatabaseSellerPostgre.addSeller(seller)){
            return seller;
        }
        return null;
    }
}