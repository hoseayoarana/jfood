package hosea.jfood;

/**
 * Class untuk mengatur, membuat, dan mendefinisikan promo
 *
 * @author Hosea Yoarana/ NPM: 1706042913
 * @version 27 Mei 2020
 */
public class Promo
{
    private int id;
    private String code;
    private int discount;
    private int minPrice;
    private boolean active;

    /**
     * Constructor untuk objek class Promo
     */
    public Promo(int id, String code, int discount, int minPrice, boolean active)
    {
        this.id = id;
        this.code = code;
        this.discount = discount;
        this.minPrice = minPrice;
        this.active = active;
    }

    /**
     * method accessor yang digunakan untuk mengambil ID promo
     * @return id promo
     */
    public int getId()
    {
        return id;
    }

    /**
     * method accessor yang digunakan untuk mengambil code promo
     * @return code promo
     */
    public String getCode()
    {
        return code;
    }

    /**
     * method accessor yang digunakan untuk mengambil discount yang diberikan promo
     * @return discount promo
     */
    public int getDiscount()
    {
        return discount;
    }

    /**
     * method accessor yang digunakan untuk mengambil minimal price yang
     * harus dibayarkan agar promo aktif
     * @return minPrice promo
     */
    public int getMinPrice()
    {
        return minPrice;
    }

    /**
     * method accessor yang digunakan untuk mengambil status dari promo
     * @return active promo
     */
    public boolean getActive()
    {
        return active;
    }

    /**
     * method mutator yang digunakan untuk menetapkan id untuk promo
     */
    public void setId()
    {
        this.id = id;
    }

    /**
     * method mutator yang digunakan untuk menetapkan code untuk promo
     */
    public void setCode()
    {
        this.code = code;
    }

    /**
     * method mutator yang digunakan untuk menetapkan discount untuk promo
     */
    public void setDiscount()
    {
        this.discount = discount;
    }

    /**
     * method mutator yang digunakan untuk menetapkan minPrice untuk promo
     */
    public void setMinPrice()
    {
        this.minPrice = minPrice;
    }

    /**
     * method mutator yang digunakan untuk menetapkan status active untuk promo
     */
    public void setActive(boolean b)
    {
        this.active = active;
    }
    
    public void printData()
    {
        System.out.println("===========Promo===========");
        System.out.println("ID : "+id);
        System.out.println("Code : "+code);
        System.out.println("Discount : "+discount);
        System.out.println("Min Price : "+minPrice);
        System.out.println("Active : "+active);
    }
    
    public String toString()
    {
        return "Id = " + getId() + 
        "\nCode = " + getCode() + 
        "\nDiscount = " + getDiscount() + 
        "\nMin Price = " + getMinPrice() + 
        "\nActive Status= " + getActive();
    }
}
