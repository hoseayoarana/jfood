
/**
 * Class Location berisi province, description, dan city untuk dijadikan sebuah objek dari location
 *
 * @author Hosea Yoarana
 * @version 27-02-2020
 */
public class Location
{
    // bagian ini berisi variabel yang nantinya digunakan sebagai parameter objek
    private String province;        // provinsi yang digunakan untuk class seller
    private String description;     // deskripsi singkat seller
    private String city;            // kota yang digunakan untuk class seller
    
    /**
     * Inisiasi variabel kedalam method public untuk datatype Location
     * @param city              kota dari yang akan digunakan class seller
     * @param province          provinsi dari yang akan digunakan class seller
     * @param description       deskripsi singkat yang akan digunakan class seller
     * @return Nothing.         mengembalikan Nothing
     */
    public Location(String city, String province, String description)
    {
        this.city = city;
        this.province = province;
        this.description = description;
    }
    
    /**
     * accessor getProvince untuk mengembalikan province
     * @return province     mengembalikan province
     */
    public String getProvince()
    {
        return province;
    }
    
    /**
     * accessor getCity untuk mengembalikan city
     * @return city     mengembalikan city
     */
    public String getCity()
    {
        return city;
    }
    
    /**
     * accessor getDescription untuk mengembalikan description
     * @return description     mengembalikan description
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * mutator setProvince untuk menetapkan province
     * @param province     menetapkan province
     */
    public void setProvince(String province)
    {
        this.province = province;
    }
    
    /**
     * mutator setCity untuk menetapkan city
     * @param city     menetapkan city
     */
    public void setCity(String city)
    {
        this.city = city;
    }
    
    /**
     * mutator setDescription untuk menetapkan description
     * @return city     menetapkan description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    /**
     * method printData untuk menampilkan getProvince()
     * @return Nothing.
     */
    public void printData()
    {
        System.out.println(getProvince());
    }
}
