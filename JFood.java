
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
        Customer customer1 = new Customer(1, "Jamal", "jamal@gmail.com", "123456", "27/02/2020");
        Promo promo1 = new Promo(1, "Gagah", 5000, 10000, true);
        CashlessInvoice cashless1 = new CashlessInvoice(1, ayam, "3/12/2020", customer1, InvoiceStatus.ONGOING);
        
        cashless1.setTotalPrice();
        CashlessInvoice cashless2 = new CashlessInvoice (2, sapi, "3/3/2020", customer1, InvoiceStatus.ONGOING, promo1);
        cashless2.setTotalPrice();
        CashlessInvoice cashless3 = new CashlessInvoice (3, sapi, "3/3/2020", customer1, InvoiceStatus.ONGOING, promo1);
        cashless3.setTotalPrice();
        
        cashless1.printData();
        cashless2.printData();
        cashless3.printData();
        //Invoice invoice1 = new Invoice(1, ayam.getId(), "27/02/2020", customer1, 10000, InvoiceStatus.FINISHED);
        //ayam.printData();
        //invoice1.printData();
        //System.out.println(seller1.getName());
        //seller1.setName("Fathur");
        //System.out.println(seller1.getName());
        
        
        
    }
}
