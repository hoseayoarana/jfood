
/**
 * Class Customer berisi id, nama, email, password, dan joinDate dari customer
 *
 * @author Hosea Yoarana
 * @version 27-02-2020
 */
public class Customer
{
    // bagian ini berisi variabel yang nantinya digunakan sebagai parameter objek
    private int id;                 //id dari customer
    private String name;            //name dari customer
    private String email;           //email dari customer
    private String password;        //password dari customer
    private String joinDate;        //joinDate dari customer

    /**
     * Inisiasi variabel kedalam method public untuk datatype Customer
     * @param id            id dari customer
     * @param name          name dari customer
     * @param email         email dari customer
     * @param password      password dari customer
     * @param joinDate      joinDate dari customer
     */
    public Customer(int id, String name, String email, String password, String joinDate)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
    }
    
    /**
     * accessor getId untuk mengambil id
     * @return id       mengembalikan id
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
     * accessor getPassword untuk mengambil password
     * @return password     mengembalikan password
     */
    public String getPassword()
    {
        return password;
    }
    
    /**
     * accessor getJoinDate untuk mengambil joinDate
     * @return joinDate     mengembalikan joinDate
     */
    public String getJoinDate()
    {
        return joinDate;
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
     * mutator setPassword untuk menetapkan password
     * @param password      password dari customer
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    /**
     * mutator setJoinDate untuk menetapkan joinDate
     * @param joinDate      joinDate dari customer
     */
    public void setJoinDate(String joinDate)
    {
        this.joinDate = joinDate;
    }
    
    /**
     * method printDate untuk menampilkan getName()
     * @return Nothing.     tidak mengembalikan apapun
     */
    public void printData()
    {
        System.out.println(getName());      //menampilkan name dari customer
    }
}
