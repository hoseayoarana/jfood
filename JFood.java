
/**
 * Write a description of class JFood here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JFood
{
        /**
     * Constructor for objects of class JFood
     */
    public static void main(String[] args)
    {
        Location location1 = new Location("Jawa Barat", "tes", "Bogor");
        Seller seller1 = new Seller(1, "Jamal", "jamal@gmail.com", "0812345678", location1);
        Food allalayam = new Food(1, "Ayam", seller1, 10000, "makanan");
        Customer customer1 = new Customer(1, "Hosea", "hoseayoarana@gmail.com", "123456", "27/02/2020");
        Invoice invoice1 = new Invoice(1, 100, "27/02/2020", customer1, 10000);
        System.out.println(allalayam.getName());
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
}
