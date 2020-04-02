
/**
 * Class Seller berisi id, name, email, phoneNumber, dan location untuk dijadikan sebuah objek dari seller
 *
 * @author Hosea Yoarana
 * @version 27-02-2020
 */
public class Seller
{
    // bagian ini berisi variabel yang nantinya digunakan sebagai parameter objek
    private int id;                 // id dari seller
    private String name;            // nama dari seller
    private String email;           // email dari seller
    private String phoneNumber;     // phoneNumber dari seller
    private Location location;      // location dari seller

    /**
     * Inisiasi variabel kedalam method public untuk datatype Seller
     * @param id            id dari seller
     * @param name          nama dari seller
     * @param email         email dari seller
     * @param phoneNumber   phoneNumber dari seller
     * @param location      location dari seller
     */
    public Seller(int id, String name, String email, String phoneNumber, Location location)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
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
     * accessor getEmail untuk mengambil email
     * @return email        mengembalikan email
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * accessor getPhoneNumber untuk mengambil phoneNumber
     * @return phoneNumber     mengembalikan phoneNumber
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    /**
     * method location untuk mengembalikan location
     * @return location     mengembalikan location
     */
    public Location getLocation()
    {
        return location;
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
     * mutator setEmail untuk menetapkan email
     * @param email     email dari customer
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    /**
     * mutator setPhoneNumber untuk menetapkan phoneNumber
     * @param phoneNumber     menetapkan phoneNumber
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * mutator setLocation untuk menetapkan location
     * @param location     menetapkan location
     */
    public void setLocation(Location location)
    {
        this.location = location;
    }
    
    /**
     * method printData untuk menampilkan getProvince()
     * @return Nothing.
     */
    public void printData()
    {
        System.out.println(getName());
    }
    
    public String toString()
    {
        return "Id = " + getId() + 
        "\nNama = " + getName() + 
        "\nPhone Number = " + getPhoneNumber() + 
        "\nLocation = " + getLocation();
    }
}
