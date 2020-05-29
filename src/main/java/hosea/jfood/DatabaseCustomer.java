package hosea.jfood;
import java.util.ArrayList;

/**
 * Class database sementara yang digunakan untuk mengatur seluruh objek customer yang dibuat
 *
 * @author Hosea Yoarana/ NPM: 1706042913
 * @version 27 Feb 2020
 */
public class DatabaseCustomer
{
    private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<>();
    private static int lastId;

    /**
     * Constructor untuk objek class DatabaseCustomer
     */
    public DatabaseCustomer()
    {
        
    }

    /**
     * method accessor untuk mendapatkan seluruh isi dari
     * database customer
     */
    public static ArrayList<Customer> getCustomerDatabase()
    {
        return CUSTOMER_DATABASE;
    }

    /**
     * method accessor untuk mendapatkan lastId atau id terakhir yang dimasukkan
     * pada database customer
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * method accessor untuk mendapatkan customer dari database customer berdasarkan ID nya.
     * @param id
     * @return customer dari database
     * @throws CustomerNotFoundException
     */
    public static Customer getCustomerById(int id) throws CustomerNotFoundException
    {
        for(Customer customer : CUSTOMER_DATABASE) {
            if(customer.getId() == id){
                return customer;
            }
        }
        throw new CustomerNotFoundException(id);
    }

    /**
     * method yang digunakan untuk menambahkan customer ke database customer(jika belum ada),
     * jika sudah ada maka tidak akan dimasukkan kembali dan mengeluarkan exception.
     * @param customer
     * @return true ketika customer dapat dimasukkan, false ketika tidak dapat dimasukkan dan mengeluarkan exception
     * @throws EmailAlreadyExistsException
     */
    public static boolean addCustomer(Customer customer) throws EmailAlreadyExistsException
    {
        for(Customer c : CUSTOMER_DATABASE) {
            if(c.getEmail().equals(customer.getEmail())) {
                throw new EmailAlreadyExistsException(customer);
            }
        }
        CUSTOMER_DATABASE.add(customer);
        lastId = customer.getId();
        return true;
    }

    /**
     * method yang digunakan untuk menghapus customer ke database customer(jika ada),
     * jika tidak ada maka tidak akan dijalankan dan mengeluarkan exception.
     * @param id
     * @return true ketika berhasil dihapus, false ketika tidak ditemukan customer dan mengeluarkan exception
     * @throws CustomerNotFoundException
     */
    public static boolean removeCustomer(int id) throws CustomerNotFoundException
    {
        for(Customer c : CUSTOMER_DATABASE) {
            if(c.getId() == id){
                return false;
            }
        }
        throw new CustomerNotFoundException(id);
    }

    /**
     * method yang digunakan untuk mengecek ketika customer akan login
     * email dan password harus sama dengan apa yang ada di dalam database customer,
     * jika sama maka customer dapat login,
     * jika berbeda maka dikeluarkan exception.
     * @param email
     * @param password
     * @return CUSTOMER_DATABASE
     */
    public static Customer CustomerLogin(String email, String password)
    {
        for (Customer c: CUSTOMER_DATABASE) {
            if (c.getEmail().equals(email)){
                if (c.getPassword().equals(password)){
                    return c;
                }
            }
        }
        return null;
    }
}
