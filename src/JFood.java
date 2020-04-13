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

        
//        Seller seller1 = new Seller(1, "HoseaYoarana", "hosea.yoarana@gmail.com", "081212343199", location1);
//
//        Food ayam = new Food(1, "Ayam", seller1, 10000, FoodCategory.BEVERAGES);
//        Food sapi = new Food (15, "Cowfee" , seller1, 15000, FoodCategory.COFFEE);
//
//        Customer customer1 = new Customer(1, "Jamal", "jamal..@gmail.com", "Haha12",new GregorianCalendar(2020, 03, 13));
//        Customer customer2 = new Customer(2, "Jamsan", "jamsan@gmail.com", "12345678",new GregorianCalendar(2020, 02, 12));
//        Customer customer3 = new Customer(3, "Jamakun", "jamkun@gmail.com", "Haha65",new GregorianCalendar(2020, 01, 11));
//
        Promo promo1 = new Promo(1, "Gagah", 5000, 10000, true);
        
//        int deliveryFee1 = 5000;
        
//        CashlessInvoice cashless1 = new CashlessInvoice(1, ayam, customer1, InvoiceStatus.ONGOING);
//        CashInvoice cash1 = new CashInvoice(1, ayam, customer1, InvoiceStatus.FINISHED);
        
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
        
        //System.out.println(customer1.toString());
        //System.out.println(customer2.toString());
        //System.out.println(customer3.toString());
        
//        cash1.setTotalPrice();
//        cashless1.setTotalPrice();
//
//        System.out.println(cash1.toString());
//        System.out.println(cashless1.toString());

//        Location location1 = new Location("Jawa Barat", "tes", "Bogor");
//
//        DatabaseSeller.addSeller(new Seller(1, "HoseaYoarana", "hosea.yoarana@gmail.com",
//                "081212343199", location1));
//
//        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Jamal", "jamal..@gmail.com",
//                "Haha12",new GregorianCalendar(2020, 03, 13)));
//        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Jamsan", "jamsan@gmail.com",
//                "12345678",new GregorianCalendar(2020, 02, 12)));
//        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Jamakun", "jamkun@gmail.com",
//                "Haha65",new GregorianCalendar(2020, 01, 11)));
//
//        System.out.println(DatabaseCustomer.getCustomerDatabase());
//        System.out.println("\n");
//
//        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1, "Ayam", DatabaseSeller.getSellerById(1), 10000, FoodCategory.BEVERAGES));
//        DatabaseFood.addFood(new Food (DatabaseFood.getLastId()+1, "Cowfee" , DatabaseSeller.getSellerById(1), 15000, FoodCategory.COFFEE));
//        DatabaseFood.addFood(new Food (DatabaseFood.getLastId()+1, "Safee" , DatabaseSeller.getSellerById(1), 15000, FoodCategory.COFFEE));
//
//        System.out.println(DatabaseFood.getFoodByCategory(FoodCategory.BEVERAGES));
//        System.out.println(DatabaseFood.getFoodByCategory(FoodCategory.COFFEE));
//
//        DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1, "JAFUT", 40000, 50000, false));
//        DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1, "JAFUT", 45000, 100000, false));
//        System.out.println(DatabasePromo.getPromoDatabase());
//        System.out.println("\n");
//
//        ArrayList<Food> food1 = new ArrayList<Food>();
//        food1.add(DatabaseFood.getFoodById(1));
//        food1.add(DatabaseFood.getFoodById(2));
//
//        ArrayList<Food> food2 = new ArrayList<Food>();
//        food2.add(DatabaseFood.getFoodById(1));
//        food2.add(DatabaseFood.getFoodById(2));
//
//        DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId()+1, food1, DatabaseCustomer.getCustomerById(1), 1));
//        DatabaseInvoice.getInvoiceByCustomer(DatabaseCustomer.getLastId()+1);
//        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, food1, DatabaseCustomer.getCustomerById(1), DatabasePromo.getPromoById(1)));
//        DatabaseInvoice.getInvoiceByCustomer(DatabaseCustomer.getLastId()+1);
//
//
//        for (Invoice invoice : DatabaseInvoice.getInvoiceByCustomer(1))
//        {
//            invoice.setTotalPrice();
//        }
//
//        for (Invoice invoice : DatabaseInvoice.getInvoiceByCustomer(1))
//        {
//            DatabaseInvoice.changeInvoiceStatus(2, InvoiceStatus.FINISHED);
//        }
//
//        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, food1, DatabaseCustomer.getCustomerById(2), DatabasePromo.getPromoById(1)));
//        DatabaseInvoice.getInvoiceByCustomer(DatabaseCustomer.getLastId()+1);
//
//        DatabasePromo.activePromo(DatabasePromo.getLastId());
//
//        for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase())
//        {
//            invoice.setTotalPrice();
//        }
        Location location = new Location("Bekasi", "Jawa Barat", "HOHO");
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Hosea", "hosea.y@jfood.com", "081212343199", location));

        try
        {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1,
                    "Jamal", "jamal@ui.ac.id", "12345678", new GregorianCalendar(2020, 1, 11)));
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1,
                    "Jamaludin", "jamal@ui.ac.id", "12345678", new GregorianCalendar(2020, 1, 12)));
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1,
                    "Jamalkamal", "JK@ui.ac.id", "Yamyam12", new GregorianCalendar(2020, 1, 13)));
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1,
                    "Jamalmalka", "JM@ui.ac.id", "tamtam12", new GregorianCalendar(2020, 1, 14)));
        }
        catch (EmailAlreadyExistsException exists)
        {
            System.out.println(exists.getMessage() + "\n");
        }

        try
        {
            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId() + 1, "JAFUT", 40000, 50000, true));
            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId() + 1, "JEFOD", 5000, 30000, true));
        }
        catch (PromoCodeAlreadyExistsException exists)
        {
            System.out.println(exists.getMessage() + "\n");
        }

        try
        {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Ayam", DatabaseSeller.getSellerById(1), 50000, FoodCategory.WESTERN));
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Kopi", DatabaseSeller.getSellerById(2), 30000, FoodCategory.COFFEE));
        }
        catch (SellerNotFoundException notfound)
        {
            System.out.println(notfound.getMessage() + "\n");
        }
        try
        {
            DatabasePromo.getPromoById(999);
        }
        catch (PromoNotFoundException notfound)
        {
            System.out.println(notfound.getMessage() + "\n");
        }

        try
        {
            DatabaseFood.getFoodById(11);
        }
        catch (FoodNotFoundException notfound)
        {
            System.out.println(notfound.getMessage() + "\n");
        }

        try
        {
            DatabaseCustomer.getCustomerById(999);
        }
        catch (CustomerNotFoundException notfound)
        {
            System.out.println(notfound.getMessage() + "\n");
        }

        ArrayList<Food> makan = new ArrayList<>();
        try
        {
            makan.add(DatabaseFood.getFoodById(1));
            makan.add(DatabaseFood.getFoodById(2));
        }
        catch (FoodNotFoundException notfound)
        {
            System.out.println(notfound.getMessage() + "\n");
        }

        try
        {
            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() + 1, makan, DatabaseCustomer.getCustomerById(1), promo1));
        }
        catch (CustomerNotFoundException notfound)
        {
            System.out.println(notfound.getMessage() + "\n");
        }

        try
        {
            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() + 1, makan, DatabaseCustomer.getCustomerById(2), promo1));
        }
        catch (CustomerNotFoundException notfound)
        {
            System.out.println(notfound.getMessage() + "\n");
        }

        try
        {
            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() + 1, makan, DatabaseCustomer.getCustomerById(3), promo1));
        }
        catch (CustomerNotFoundException notfound)
        {
            System.out.println(notfound.getMessage() + "\n");
        }

        for(Invoice invoice : DatabaseInvoice.getInvoiceDatabase()){

            Thread object = new Thread(new PriceCalculator(invoice));
            object.start();

        }

        System.out.println("=============================YANG MASUK DATABASE PROMO============================");
        System.out.println(DatabasePromo.getPromoDatabase());
        System.out.println("=============================YANG MASUK DATABASE SELLER============================");
        System.out.println(DatabaseSeller.getSellerDatabase());
        System.out.println("=============================YANG MASUK DATABASE FOOD============================");
        System.out.println(DatabaseFood.getFoodDatabase());
        System.out.println("=============================YANG MASUK DATABASE CUSTOMER============================");
        System.out.println(DatabaseCustomer.getCustomerDatabase());

        ArrayList<Food> pertama = new ArrayList<Food>();
        try {

            pertama.add(DatabaseFood.getFoodById(1));

        }
        catch(FoodNotFoundException error){

            System.out.println(error.getMessage());

        }

        try {

            DatabaseInvoice.addInvoice(new CashInvoice (DatabaseInvoice.getLastId() + 1, pertama, DatabaseCustomer.getCustomerById(1)));

        }
        catch(CustomerNotFoundException error){

            System.out.println(error.getMessage());

        }

        try {

            DatabaseInvoice.addInvoice(new CashInvoice (DatabaseInvoice.getLastId() + 1, pertama, DatabaseCustomer.getCustomerById(2)));

        }
        catch(CustomerNotFoundException error){

            System.out.println(error.getMessage());

        }

        try {

            DatabaseInvoice.addInvoice(new CashInvoice (DatabaseInvoice.getLastId() + 1, pertama, DatabaseCustomer.getCustomerById(3)));

        }
        catch(CustomerNotFoundException error){

            System.out.println(error.getMessage());

        }

        for(Invoice invoice : DatabaseInvoice.getInvoiceDatabase()){

            Thread object = new Thread(new PriceCalculator(invoice));
            object.start();

        }

        System.out.println("=============================YANG MASUK DATABASE INVOICE============================");
        System.out.println(DatabaseInvoice.getInvoiceDatabase());
    }
}
