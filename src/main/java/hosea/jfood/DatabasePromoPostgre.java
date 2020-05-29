package hosea.jfood;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class database postgre yang digunakan untuk mengatur seluruh objek promo yang dibuat
 * dan dimasukkan ke database yang ada di postgre
 *
 * @author Hosea Yoarana/ NPM: 1706042913
 * @version 27 Mei 2020
 */
public class DatabasePromoPostgre
{
    private static ArrayList<Promo> PROMO_DATABASE;
    private static int lastId = 0;

    /**
     * method accessor yang digunakan untuk mengambil seluruh isi table promo
     * pada DB
     * @return PROMO_DATABASE
     */
    public static ArrayList<Promo> getPromoDatabase()
    {
        PROMO_DATABASE = new ArrayList<>();
        String getPromoDatabaseQuery = "SELECT * FROM promo;";

        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(getPromoDatabaseQuery);
            while(rs.next()) {
                int promoId = rs.getInt("id");
                String promoName = rs.getString("code");
                int promoDiscount = rs.getInt("discount");
                int promoMinPrice = rs.getInt("minPrice");
                boolean promoActive = rs.getBoolean("active");
                PROMO_DATABASE.add(new Promo(promoId, promoName, promoDiscount, promoMinPrice, promoActive));
            }
            rs.close();
            stmt.close();
            c.commit();
            c.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return PROMO_DATABASE;
    }

    /**
     * method yang digunakan untuk mengambil id terakhir yang ada
     * pada DB
     * @return id terkahir yang ada pada DB
     */
    public static int getLastId()
    {
        String getLastPromoIdQuery = "SELECT * FROM promo ORDER BY id DESC LIMIT 1";
        lastId = 0;

        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(getLastPromoIdQuery);
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
     * method accessor yang digunakan untuk mengambil promo berdasarkan ID
     * pada DB
     * @param id
     * @return true apabila ditemukan, false apabila tidak ditemukan dan mengeluarkan exception
     * @throws PromoNotFoundException
     */
    public static Promo getPromoById (int id) throws PromoNotFoundException
    {
        Promo promo = null;
        String getPromoByIdQuery = "SELECT * FROM promo WHERE id = " + id + ";";

        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(getPromoByIdQuery);
            while(rs.next()) {
                int promoId = rs.getInt("id");
                String promoName = rs.getString("code");
                int promoDiscount = rs.getInt("discount");
                int promoMinPrice = rs.getInt("minPrice");
                boolean promoActive = rs.getBoolean("active");
                promo = new Promo(promoId, promoName, promoDiscount, promoMinPrice, promoActive);
            }
            rs.close();
            stmt.close();
            c.commit();
            c.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return promo;
    }

    /**
     * method accessor yang digunakan untuk mengambil promo berdasarkan code
     * pada DB
     * @param code
     * @return promo
     */
    public static Promo getPromoByCode (String code)
    {
        Promo promo = null;
        String getPromoByCodeQuery = "SELECT * FROM promo WHERE code = '" + code + "';";

        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(getPromoByCodeQuery);
            while(rs.next()) {
                int promoId = rs.getInt("id");
                String promoName = rs.getString("code");
                int promoDiscount = rs.getInt("discount");
                int promoMinPrice = rs.getInt("minPrice");
                boolean promoActive = rs.getBoolean("active");
                promo = new Promo(promoId, promoName, promoDiscount, promoMinPrice, promoActive);
            }
            rs.close();
            stmt.close();
            c.commit();
            c.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return promo;
    }

    /**
     * method yang digunakan untuk menambahkan promo pada DB
     * @param promo
     * @return true apabila dapat masuk, false apabila sudah ada dan mengeluarkan exception
     * @throws PromoCodeAlreadyExistsException
     */
    public static boolean addPromo(Promo promo) throws PromoCodeAlreadyExistsException
    {
        String addPromoQuery = "INSERT INTO promo (id, code, discount, minPrice, active) VALUES (" + promo.getId() + ", '" + promo.getCode() + "', " + promo.getDiscount() + ", " + promo.getMinPrice() + ", " + promo.getActive() + ");";

        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            stmt.executeUpdate(addPromoQuery);
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
     * method yang digunakan untuk mengaktifkan promo pada DB
     * @param id
     * @return active
     */
    public static boolean activatePromo (int id)
    {
        String activatePromoQuery = "UPDATE promo SET active = true WHERE id = " + id + ";";

        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            stmt.executeUpdate(activatePromoQuery);
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
     * method yang digunakan untuk me-nonaktifkan promo pada DB
     * @param id
     * @return deactive
     */
    public static boolean deactivatePromo (int id)
    {
        String deactivatePromoQuery = "UPDATE promo SET active = false WHERE id = " + id + ";";

        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            stmt.executeUpdate(deactivatePromoQuery);
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
     * method yang digunakan untuk menghapus promo pada DB
     * @param id
     * @return true apabila dapat dihapus, false apabila tidak ditemukan dan mengeluarkan exception
     * @throws PromoNotFoundException
     */
    public static boolean removePromo (int id) throws PromoNotFoundException {
        String removePromoQuery = "DELETE FROM promo WHERE id = " + id + ";";

        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            stmt.executeUpdate(removePromoQuery);
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

