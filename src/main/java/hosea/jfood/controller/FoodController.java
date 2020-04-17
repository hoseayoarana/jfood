package hosea.jfood.controller;

import hosea.jfood.*;
import jdk.jfr.Category;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class FoodController {


    @RequestMapping(value = "/food", method = RequestMethod.GET)
    public ArrayList<Food> getAllFood()
    {
        return DatabaseFood.getFoodDatabase();
    }

    @RequestMapping(value = "/food/{id}", method = RequestMethod.GET)
    public Food getFoodById(@PathVariable int id) {
        Food food = null;
        try
        {
            food = DatabaseFood.getFoodById(id);
        }
        catch (FoodNotFoundException notfound)
        {
            System.out.println(notfound.getMessage());
        }
        return food;
    }

    @RequestMapping(value = "/food/seller/{sellerId}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodBySeller(@PathVariable int sellerId) {
        return DatabaseFood.getFoodBySeller(sellerId);
    }


    @RequestMapping(value = "/food/category/{category}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodByCategory(@PathVariable FoodCategory category){
        return DatabaseFood.getFoodByCategory(category);
    }

    @RequestMapping(value = "/food", method = RequestMethod.POST)
    public Food addFood(@RequestParam(value="name") String name,
                        @RequestParam(value="price") int price,
                        @RequestParam(value="category") FoodCategory category,
                        @RequestParam(value="sellerId") int sellerId) {
        Food food = null;
        try {
            food = new Food(DatabaseFood.getLastId() + 1, name, DatabaseSeller.getSellerById(sellerId), price, category);
            DatabaseFood.addFood(food);
        } catch (SellerNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return food;
    }
}