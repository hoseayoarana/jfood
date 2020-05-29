package hosea.jfood;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class database postgre yang digunakan untuk mengatur seluruh objek seller yang dibuat
 * dan dimasukkan ke database yang ada di postgre
 *
 * @author Hosea Yoarana/ NPM: 1706042913
 * @version 27 Mei 2020
 */
public class DatabaseSellerPostgre
{
    private static ArrayList<Seller> SELLER_DATABASE;
    private static int lastId = 0;

    /**
     * method accessor yang digunakan untuk mengambil seluruh isi dari table seller
     * pada DB
     * @return SELLER_DATABASE
     */
    public static ArrayList<Seller> getSellerDatabase()
    {
        SELLER_DATABASE = new ArrayList<>();
        String getSellerDatabaseQuery = "SELECT * FROM seller;";

        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(getSellerDatabaseQuery);
            while(rs.next()) {
                int sellerId = rs.getInt("id");
                String sellerName = rs.getString("name");
                String sellerEmail = rs.getString("email");
                String sellerPhoneNumber = rs.getString("phoneNumber");
                String sellerCity = rs.getString("city");
                String sellerProvince = rs.getString("province");
                String sellerDescription = rs.getString("description");
                Location sellerLocation = new Location(sellerCity, sellerProvince, sellerDescription);
                SELLER_DATABASE.add(new Seller(sellerId, sellerName, sellerEmail, sellerPhoneNumber, sellerLocation));
            }
            rs.close();
            stmt.close();
            c.commit();
            c.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return SELLER_DATABASE;
    }

    /**
     * method accessor yang digunakan untuk mengambil id terkahir yang ada
     * pada DB
     * @return id terakhir pada DB
     */
    public static int getLastId()
    {
        String getLastSellerIdQuery = "SELECT * FROM seller ORDER BY id DESC LIMIT 1";
        lastId = 0;
        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(getLastSellerIdQuery);
            while (rs.next()) {
                lastId = rs.getInt("id");
            }
            rs.close();
            stmt.close();
            c.commit();
            c.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return lastId;
    }

    /**
     * method yang digunakan untuk mengambil seller berdasarkan ID
     * pada DB
     * @param id
     * @return seller
     * @throws SellerNotFoundException
     */
    public static Seller getSellerById(int id) throws SellerNotFoundException
    {
        Seller seller = null;
        String getSellerByIdQuery = "SELECT * FROM seller WHERE id = " + id + ";";

        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(getSellerByIdQuery);
            while(rs.next()) {
                int sellerId = rs.getInt("id");
                String sellerName = rs.getString("name");
                String sellerEmail = rs.getString("email");
                String sellerPhoneNumber = rs.getString("phoneNumber");
                String sellerCity = rs.getString("city");
                String sellerProvince = rs.getString("province");
                String sellerDescription = rs.getString("description");
                Location sellerLocation = new Location(sellerCity, sellerProvince, sellerDescription);
                seller = new Seller(sellerId, sellerName, sellerEmail, sellerPhoneNumber, sellerLocation);
            }
            rs.close();
            stmt.close();
            c.commit();
            c.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return seller;
    }

    /**
     * method yang digunakan untuk menambahkan seller pada DB
     * @param seller
     * @return seller
     */
    public static boolean addSeller (Seller seller)
    {
        String addSellerQuery = "INSERT INTO seller (id, name, email, phoneNumber, city, province, description) VALUES (" + seller.getId() + ", '" + seller.getName() + "', '" + seller.getEmail() + "', '" + seller.getPhoneNumber() + "', '" + seller.getLocation().getCity() + "', '" + seller.getLocation().getProvince() + "', '" + seller.getLocation().getDescription() + "');";

        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            stmt.executeUpdate(addSellerQuery);
            stmt.close();
            c.commit();
            c.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return true;
    }

    /**
     * method yang digunakan untuk menghapus seller pada DB
     * @param id
     * @return true apabila dapat dihapus, false apabila tidak ditemukan dan mengeluarkan exception
     * @throws SellerNotFoundException
     */
    public static boolean removeSeller (int id) throws SellerNotFoundException
    {
        String removeSellerQuery = "DELETE FROM seller WHERE id = " + id + ";";

        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            stmt.executeUpdate(removeSellerQuery);
            stmt.close();
            c.commit();
            c.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return true;
    }
}

