import java.lang.Object;
import java.util.*;
import java.util.regex.*;
import java.text.Format;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    private Calendar joinDate;        //joinDate dari customer

    /**
     * Inisiasi variabel kedalam method public untuk datatype Customer
     * @param id            id dari customer
     * @param name          name dari customer
     * @param email         email dari customer
     * @param password      password dari customer
     * @param joinDate      joinDate dari customer
     */
    public Customer(int id, String name, String email, String password, Calendar joinDate)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.joinDate = joinDate;
    }
    
    public Customer(int id, String name, String email, String password, int year, int month, int dayOfMonth)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        //this.joinDate = new GregorianCalendar(year,month,dayOfMonth);
        joinDate = new java.util.GregorianCalendar(year, month-1, dayOfMonth+1);
    }
    
    public Customer(int id, String name, String email, String password)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
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
    
    public Calendar getJoinDate()
    {
        //SimpleDateFormat sd = new SimpleDateFormat("dd MMMM yyyy");
        //String joinDateString = sd.format(joinDate.getTime());
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
        if (java.util.regex.Pattern.matches("(([a-zA-Z0-9&\\*_~]+(\\.?))+)[@]((\\w+)([\\.\\-]?))+", email))
        {
            this.email = email;
        }
        else{
            this.email = "";
        }
    }
    
    /**
     * mutator setPassword untuk menetapkan password
     * @param password      password dari customer
     */
    public void setPassword(String password)
    {
        if (java.util.regex.Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$", password))
        {
            this.password = password;
        }
        else{
            this.password = "";
        }
    }
    
    /**
     * mutator setJoinDate untuk menetapkan joinDate
     * @param joinDate      joinDate dari customer
     */
    public void setJoinDate(Calendar joinDate)
    {
        this.joinDate = joinDate;
    }
    
    public void setJoinDate(int year, int month, int dayOfMonth)
    {
        joinDate.set(java.util.Calendar.YEAR, year);
                joinDate.set(java.util.Calendar.MONTH, month);
                        joinDate.set(java.util.Calendar.DAY_OF_MONTH, dayOfMonth);
    }
    
    /**
     * method printDate untuk menampilkan getName()
     * @return Nothing.     tidak mengembalikan apapun
     */
    public void printData()
    {
        System.out.println(getName());      //menampilkan name dari customer
    }
    
    public String toString()
    {
        String format = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        if(joinDate != null)
        {
            format = sdf.format(joinDate.getTime());
        }
        
        return "Id = " + getId() + 
        "\nNama = " + getName() + 
        "\nEmail = " + getEmail() + 
        "\nPassword = " + getPassword() + 
        "\nJoin Date = " + format;
    }
}
