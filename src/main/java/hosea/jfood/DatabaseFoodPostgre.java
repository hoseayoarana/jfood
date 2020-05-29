package hosea.jfood;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class database postgre yang digunakan untuk mengatur seluruh objek food yang dibuat
 * dan dimasukkan ke database yang ada di postgre
 *
 * @author Hosea Yoarana/ NPM: 1706042913
 * @version 27 Mei 2020
 */
public class DatabaseFoodPostgre
{
    private static ArrayList<Food> FOOD_DATABASE;
    private static ArrayList<Food> FOOD_DATABASE_SELLER;
    private static ArrayList<Food> FOOD_DATABASE_CATEGORY;
    private static int lastId = 0;

    /**
     * method accessor yang digunakan untuk mengambil seluruh isi table food pada DB
     * @return Informasi seluruh food pada database food
     */
    public static ArrayList<Food> getFoodDatabase()
    {
        FOOD_DATABASE = new ArrayList<>();
        String getFoodDatabaseQuery = "SELECT * FROM food;";

        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(getFoodDatabaseQuery);
            while(rs.next()) {
                int foodId = rs.getInt("id");
                String foodName = rs.getString("name");
                int foodSeller = rs.getInt("seller");
                int foodPrice = rs.getInt("price");
                String foodCategory = rs.getString("category");
                FOOD_DATABASE.add(new Food(foodId, foodName, DatabaseSellerPostgre.getSellerById(foodSeller), foodPrice, FoodCategory.valueOf(foodCategory.toUpperCase())));
            }
            rs.close();
            stmt.close();
            c.commit();
            c.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return FOOD_DATABASE;
    }

    /**
     * method accessor yang digunakan untuk mengambil ID terakhir yang dimasukkan pada DB
     *
     * @return  ID terakhir pada database food
     */
    public static int getLastId()
    {
        String getLastFoodIdQuery = "SELECT * FROM food ORDER BY id DESC LIMIT 1";
        lastId = 0;

        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(getLastFoodIdQuery);
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
     * method accessor yang digunakan untuk mengambil food berdasarkan ID pada DB
     *
     * @param id    ID food yang dicari
     * @return  Informasi food yang dicari
     * @throws FoodNotFoundException
     */
    public static Food getFoodById (int id) throws FoodNotFoundException
    {
        Food food = null;
        String getFoodByIdQuery = "SELECT * FROM food WHERE id = " + id + ";";

        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(getFoodByIdQuery);
            while(rs.next()) {
                int foodId = rs.getInt("id");
                String foodName = rs.getString("name");
                int foodSeller = rs.getInt("seller");
                int foodPrice = rs.getInt("price");
                String foodCategory = rs.getString("category");
                food = new Food(foodId, foodName, DatabaseSellerPostgre.getSellerById(foodSeller), foodPrice, FoodCategory.valueOf(foodCategory.toUpperCase()));
            }
            rs.close();
            stmt.close();
            c.commit();
            c.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return food;
    }

    /**
     * method accessor yang digunakan untuk mengambil food berdasarkan seller pada DB
     *
     * @param sellerId  ID seller yang menjual food
     * @return  Informasi food yang dicari
     */
    public static ArrayList<Food> getFoodBySeller (int sellerId)
    {
        FOOD_DATABASE_SELLER = new ArrayList<>();
        String getFoodBySellerQuery = "SELECT * FROM food WHERE seller = '" + sellerId + "';";

        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(getFoodBySellerQuery);
            while(rs.next()) {
                int foodId = rs.getInt("id");
                String foodName = rs.getString("name");
                int foodSeller = rs.getInt("seller");
                int foodPrice = rs.getInt("price");
                String foodCategory = rs.getString("category");
                FOOD_DATABASE_SELLER.add(new Food(foodId, foodName, DatabaseSeller.getSellerById(foodSeller), foodPrice, FoodCategory.valueOf(foodCategory.toUpperCase())));
            }
            rs.close();
            stmt.close();
            c.commit();
            c.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return FOOD_DATABASE_SELLER;
    }

    /**
     * method accessor yang digunakan untuk mengambil food berdasarkan category pada DB
     *
     * @param category  Kategori makanan
     * @return  Informasi food yang dicari
     */
    public static ArrayList<Food> getFoodByCategory (FoodCategory category)
    {
        FOOD_DATABASE_CATEGORY = new ArrayList<>();
        String getFoodBySellerQuery = "SELECT * FROM food WHERE category = '" + category + "';";

        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(getFoodBySellerQuery);
            while(rs.next()) {
                int foodId = rs.getInt("id");
                String foodName = rs.getString("name");
                int foodSeller = rs.getInt("seller");
                int foodPrice = rs.getInt("price");
                String foodCategory = rs.getString("category");
                FOOD_DATABASE_CATEGORY.add(new Food(foodId, foodName, DatabaseSeller.getSellerById(foodSeller), foodPrice, FoodCategory.valueOf(foodCategory.toUpperCase())));
            }
            rs.close();
            stmt.close();
            c.commit();
            c.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return FOOD_DATABASE_CATEGORY;
    }

    /**
     * method yang digunakan untuk menambahkan food baru ke table pada DB
     * @param food  Informasi food yang diberikan
     * @return  Apakah food berhasil dibuat dan dimasukkan pada database atau tidak
     */
    public static boolean addFood (Food food)
    {
        String addFoodQuery = "INSERT INTO food (id, name, seller, price, category) VALUES (" + food.getId() + ", '" + food.getName() + "', " + food.getSeller().getId() + ", " + food.getPrice() + ", '" + food.getCategory() + "');";

        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            stmt.executeUpdate(addFoodQuery);
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
     * method yang digunakan untuk menghapus food dari table pada DB
     *
     * @param id    ID food yang ingin dihapus
     * @return  true ketika food berhasil dihapus, false apabila tidak ditemukan dan mengeluarkan exception
     * @throws FoodNotFoundException
     */
    public static boolean removeFood (int id) throws FoodNotFoundException
    {
        String removeFoodQuery = "DELETE FROM food WHERE id = " + id + ";";

        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            stmt.executeUpdate(removeFoodQuery);
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

