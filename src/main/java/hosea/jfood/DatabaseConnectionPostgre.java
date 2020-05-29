package hosea.jfood;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class untuk mengatur koneksi ke Database pada postgre
 *
 * @author Hosea Yoarana/ NPM: 1706042913
 * @version 27 Mei 2020
 */
public class DatabaseConnectionPostgre
{

    /**
     * Constructor yang mengatur koneksi ke DB
     */
    public static Connection connection()
    {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jfood",  "postgres", "1234");
            System.out.println("Opened database successfully");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }return c;
    }
}
