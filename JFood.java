
/**
 * Class JFood berisi objek dari seluruh class yang ada dalam project
 *
 * @author Hosea Yoarana
 * @version 27-02-2020
 */
public class JFood
{
    /**
     * Inisiasi variabel kedalam method public untuk datatype JFood
     * @param String[] args     mengambil argumen sebelumnya
     * @return Nothing.         mengembalikan Nothing
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
}
