package hosea.jfood;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 * Class database postgre yang digunakan untuk mengatur seluruh objek customer yang dibuat
 * dan dimasukkan ke database yang ada di postgre
 *
 * @author Hosea Yoarana/ NPM: 1706042913
 * @version 27 Mei 2020
 */
public class DatabaseCustomerPostgre
{
    private static ArrayList<Customer> CUSTOMER_DATABASE;
    static int lastIdInsert;

    /**
     * method accessor yang digunakan untuk mendapatkan seluruh isi dari table customer pada DB
     * @return CUSTOMER_DATABASE
     */
    public static ArrayList<Customer> getCustomerDatabase()
    {
        CUSTOMER_DATABASE = new ArrayList<>();
        String getCustomerDatabaseQuery = "SELECT * FROM customer;";

        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(getCustomerDatabaseQuery);
            while(rs.next()) {
                int customerId = rs.getInt("id");
                String customerName = rs.getString("name");
                String customerEmail = rs.getString("email");
                String customerPassword = rs.getString("password");
                Date customerJoinDate = rs.getDate("joinDate");
                CUSTOMER_DATABASE.add(new Customer(customerId, customerName, customerEmail, customerPassword));
            }
            rs.close();
            stmt.close();
            c.commit();
            c.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return CUSTOMER_DATABASE;
    }

    /**
     * method yang digunakan untuk menambahkan customer,
     * memasukkan customer baru kedalam DB
     * @param customer
     * @return true ketika customer dapat dimasukkan, false ketika customer tidak dapat dimasukkan
     * dan mengeluarkan exception
     * @throws EmailAlreadyExistsException
     */
    public static boolean insertCustomer(Customer customer) throws EmailAlreadyExistsException
    {
        try{
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT email FROM customer WHERE email ='"+customer.getEmail()+"';");
            if (rs.next()){
                throw new EmailAlreadyExistsException(customer);
            }
            Date date = customer.getJoinDate().getTime();

            String sql = "INSERT INTO customer (id,name,email,password,joinDate)" +
                    "VALUES ("
                    +customer.getId()+",'"
                    +customer.getName()+"','"
                    +customer.getEmail()+"','"
                    +customer.getPassword()+"','"
                    +date+
                    "');";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Data Gabisa Masuk Bos");
        }return true;
    }

    /**
     * method accessor untuk mendapatkan ID customer yang masuk terakhir pada DB.
     * method ini digunakan untuk membuat customer baru dengan ID setelah ID terakhir di DB.
     *
     * @return ID terakhir pada DB
     */
    public static int getCustomerLastId()
    {
        lastIdInsert = 0;
        try{
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customer ORDER BY id DESC LIMIT 1");
            while (rs.next()){
                lastIdInsert = rs.getInt("id");
            }
            rs.close();
            stmt.close();
            c.commit();
            c.close();
        }catch (Exception e){
            e.printStackTrace();
        }return lastIdInsert;
    }

    /**
     * method accessor yang digunakan untuk mengambil customer berdasarkan ID pada DB
     * @param id
     * @return customer
     * @throws CustomerNotFoundException
     */
    public static Customer getCustomerById(int id) throws CustomerNotFoundException
    {
        Customer customer = null;
        try{
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customer WHERE id ="+ id +";");
            while (rs.next()){
                id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                customer = new Customer(id,name,email,password);
            }
            rs.close();
            stmt.close();
            c.commit();
            c.close();
        }catch (Exception e){
            e.printStackTrace();
        }return customer;
    }

    /**
     * method yang digunakan untuk menghapus customer dari DB
     * @param id
     * @return hapus customer
     * @throws CustomerNotFoundException
     */
    public static boolean removeCustomer(int id) throws CustomerNotFoundException
    {
        try{
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customer WHERE id="+id+";");
            if (rs.next()){
                String sql = "DELETE from customer WHERE id ="+ id +";";
                stmt.executeUpdate(sql);
            }else {
                stmt.close();
                c.commit();
                c.close();
                throw new CustomerNotFoundException(id);
            }
            stmt.close();
            c.commit();
            c.close();
        }catch (Exception e){
            e.printStackTrace();
        }return true;
    }

    /**
     * method yang digunakan untuk mengambil informasi pada DB,
     * digunakan untuk mengakses dan menggunakan aplikasi
     * @param email
     * @param password
     * @return
     */
    public static Customer CustomerLogin(String email, String password)
    {
        Customer customer = null;
        try{
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customer WHERE email='"+email+"' AND password='"+password+"';");
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String emailTemp = rs.getString("email");
                String passwordTemp = rs.getString("password");
                customer = new Customer(id, name, emailTemp, passwordTemp);
            }
            stmt.close();
            c.commit();
            c.close();
        }catch (Exception e){
            e.printStackTrace();
        }return customer;
    }
}
