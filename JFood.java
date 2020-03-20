import java.lang.Object;
import java.util.*;
import java.util.regex.*;
import java.text.Format;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        Seller seller1 = new Seller(1, "HoseaYoarana", "hosea.yoarana@gmail.com", "081212343199", location1);
        Food ayam = new Food(1, "Ayam", seller1, 10000, FoodCategory.BEVERAGES);
        Food sapi = new Food (15, "Cowfee" , seller1, 15000, FoodCategory.COFFEE);
        Customer customer1 = new Customer(1, "Jamal", "jamal..@gmail.com", "Haha12",new GregorianCalendar(2020, 03, 13));
        Customer customer2 = new Customer(2, "Jamsan", "jamsan@gmail.com", "12345678",new GregorianCalendar(2020, 02, 12));
        Customer customer3 = new Customer(3, "Jamakun", "jamkun@gmail.com", "Haha65",new GregorianCalendar(2020, 01, 11));
        Promo promo1 = new Promo(1, "Gagah", 5000, 10000, true);
        int deliveryFee1 = 5000;
        CashlessInvoice cashless1 = new CashlessInvoice(1, ayam, "3/12/2020", customer1, InvoiceStatus.ONGOING);
        CashInvoice cash1 = new CashInvoice(1, ayam, "3/13/2020", customer1, InvoiceStatus.FINISHED);
        
        //cashless1.setTotalPrice();
        //CashlessInvoice cashless2 = new CashlessInvoice (2, sapi, "3/3/2020", customer1, InvoiceStatus.ONGOING, promo1);
        //cashless2.setTotalPrice();
        //CashlessInvoice cashless3 = new CashlessInvoice (3, sapi, "3/3/2020", customer1, InvoiceStatus.ONGOING, promo1);
        //cashless3.setTotalPrice();
        
        //cashless1.printData();
        //cashless2.printData();
        //cashless3.printData();
        
        //cash1.setTotalPrice();
        //CashInvoice cash2 = new CashInvoice (2, sapi, "3/13/2020", customer1, InvoiceStatus.FINISHED, deliveryFee1);
        //cash2.setTotalPrice();
        
        //cash1.printData();
        //cash2.printData();
        
        //Invoice invoice1 = new Invoice(1, ayam.getId(), "27/02/2020", customer1, 10000, InvoiceStatus.FINISHED);
        //ayam.printData();
        //invoice1.printData();
        //System.out.println(seller1.getName());
        //seller1.setName("Fathur");
        //System.out.println(seller1.getName());
        
        System.out.println(customer1.toString());
        System.out.println(customer2.toString());
        System.out.println(customer3.toString());
    }
}
