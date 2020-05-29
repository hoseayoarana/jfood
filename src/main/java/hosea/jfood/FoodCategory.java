package hosea.jfood;

/**
 * Class yang digunakan untuk menetapkan category untuk setiap food
 *
 * @author Hosea Yoarana/ NPM: 1706042913
 * @version 27 Mei 2020
 */
public enum FoodCategory
{
    BEVERAGES ("Beverages"), COFFEE ("Coffee"), WESTERN ("Western"),
    SNACKS ("Snacks"), RICE ("Rice"), NOODLES ("Noodles"), 
    BAKERY ("Bakery"), JAPANESE ("Japanese");
    
    private String category;

    /**
     * method yang digunakan untuk menetapkan category dari food
     * @param category
     */
    private FoodCategory(String category)
    {
        this.category = category;
    }
    
    public String toString()
    {
        return category;
    }
}
