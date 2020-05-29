package hosea.jfood;
/**
 * Class Food berisi id, name, seller, price, category untuk dijadikan sebuah objek dari Food
 *
 * @author Hosea Yoarana
 * @version 27 Feb 2020
 */
public class Food
{
    // bagian ini berisi variabel yang nantinya digunakan sebagai parameter objek
    private int id;             // id dari food
    private String name;        // name dari food
    private Seller seller;      // seller dari food
    private int price;          // price dari food
    private FoodCategory category;    // category dari food
    
    /**
     * Inisiasi variabel kedalam method public untuk datatype Food
     * @param id            id dari food
     * @param name          nama dari food
     * @param seller        seller dari food
     * @param price         price dari food
     * @param category      category dari food
     */
    public Food(int id, String name, Seller seller, int price, FoodCategory category)
    {
        this.id = id;
        this.name = name;
        this.seller = seller;
        this.price = price;
        this.category = category;
    }
    
    /**
     * accessor getId untuk mengembalikan id
     * @return id     mengembalikan id
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * accessor getName untuk mengambil nama
     * @return name     mengembalikan name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * accessor getSeller untuk mengambil seller
     * @return seller     mengembalikan seller
     */
    public Seller getSeller()
    {
        return seller;
    }
    
    /**
     * accessor getPrice untuk mengambil price
     * @return price     mengembalikan price
     */
    public int getPrice()
    {
        return price;
    }
    
    /**
     * accessor getCategory untuk mengambil category
     * @return category     mengembalikan category
     */
    public FoodCategory getCategory()
    {
        return category;
    }
    
    /**
     * mutator setId untuk menetapkan id
     * @param id        id dari customer
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * mutator setName untuk menetapkan name
     * @param name      name dari customer
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * mutator setSeller untuk menetapkan seller
     * @param seller      seller dari food
     */
    public void setSeller(Seller seller)
    {
        this.seller = seller;
    }
    
    /**
     * mutator setPrice untuk menetapkan price
     * @param price      price dari food
     */
    public void setPrice(int price)
    {
        this.price = price;
    }
    
    /**
     * mutator setCategory untuk menetapkan category
     * @param category      category dari food
     */
    public void setCategory(FoodCategory category)
    {
        this.category = category;   
    }
    
    /**
     * method printData untuk menampilkan getProvince()
     * @return Nothing.
     */
    public void printData()
    {
        System.out.println("===========Food===========");
        System.out.println("ID : "+id);
        System.out.println("Name : "+name);
        System.out.println("Seller : "+seller.getName());
        System.out.println("City : "+seller.getLocation().getCity());
        System.out.println("Price : "+price);
        System.out.println("Category : "+category);
    }
    
    public String toString()
    {
        return "Id = " + getId() + 
        "\nNama = " + getName() + 
        "\nSeller = " + getSeller().getName() + 
        "\nCity = " + getSeller().getLocation().getCity() + 
        "\nPrice = " + getPrice() + 
        "\nCategory = " + getCategory();
    }
}
