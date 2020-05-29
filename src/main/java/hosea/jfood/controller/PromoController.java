package hosea.jfood.controller;

import hosea.jfood.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

/**
 * Merupakan class yang mengatur simple web application untuk promo.
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
public class PromoController
{
    /**
     * Method yang digunakan untuk menghubungkan informasi seluruh promo pada database promo
     *
     * @RequestMapping /promo dengan method GET
     * @return  Informasi seluruh promo pada database promo
     */
    @RequestMapping(value = "/promo", method = RequestMethod.GET)
    public ArrayList<Promo> getAllPromo()
    {
        return DatabasePromoPostgre.getPromoDatabase();
    }

    /**
     * Method yang digunakan untuk menghubungkan code promo pada database.
     * Method ini digunakan dalam mengambil promo berdasarkan code nya.
     *
     * @RequestMapping promo/{code} dengan method GET
     * @PathVariable String code
     * @return promo customer pada database customer
     */
    @RequestMapping(value = "/promo/{code}", method = RequestMethod.GET)
    public Promo getPromoByCode(@PathVariable String code)
    {
        return DatabasePromoPostgre.getPromoByCode(code);
    }

    /**
     * Method yang digunakan untuk menghubungkan ketika menambahkan food baru.
     *
     * @RequestMapping /promo dengan method POST
     * @RequestParam code, discount, minPrice, active
     * @return  promo ke DatabasePromoPostgre
     */
    @RequestMapping(value = "/promo", method = RequestMethod.POST)
    public Promo addPromo(@RequestParam(value="code") String code,
                        @RequestParam(value="discount") int discount,
                        @RequestParam(value="minPrice") int minPrice,
                        @RequestParam(value="active") boolean active)
    {
        Promo promo = null;
        try {
            promo = new Promo(DatabaseFoodPostgre.getLastId() + 1, code, discount, minPrice, active);
            DatabasePromoPostgre.addPromo(promo);
        } catch (PromoCodeAlreadyExistsException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return promo;
    }
}
