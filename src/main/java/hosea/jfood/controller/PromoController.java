package hosea.jfood.controller;

import hosea.jfood.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class PromoController {

    @RequestMapping(value = "/promo", method = RequestMethod.GET)
    public ArrayList<Promo> getAllPromo()
    {
        return DatabasePromo.getPromoDatabase();
    }

    @RequestMapping(value = "/promo/{code}", method = RequestMethod.GET)
    public Promo getPromoByCode(@PathVariable String code) {
        return DatabasePromo.getPromoByCode(code);
    }

    @RequestMapping(value = "/promo", method = RequestMethod.POST)
    public Promo addPromo(@RequestParam(value="code") String code,
                        @RequestParam(value="discount") int discount,
                        @RequestParam(value="minPrice") int minPrice,
                        @RequestParam(value="active") boolean active) {
        Promo promo = null;
        try {
            promo = new Promo(DatabaseFood.getLastId() + 1, code, discount, minPrice, active);
            DatabasePromo.addPromo(promo);
        } catch (PromoCodeAlreadyExistsException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return promo;
    }
}
