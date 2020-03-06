
/**
 * Class Invoice berisi id, idFood, date, totalPrice, dan customer untuk dijadikan sebuah invoice
 *
 * @author Hosea Yoarana
 * @version 27-02-2020
 */
public class Invoice
{
    // bagian ini berisi variabel yang nantinya digunakan sebagai parameter objek
    private int id;                 // id dari invoice
    private int idFood;             // idFood dari invoice
    private String date;            // tanggal dari invoice
    private int totalPrice;         // totalPrice dari invoice
    private Customer customer;      // data customer
    private PaymentType paymentType;
    private InvoiceStatus status;

    /**
     * Inisiasi variabel kedalam method public untuk datatype Invoice
     * @param id            id dari invoice
     * @param idFood        idFood dari invoice
     * @param date          tanggal dari invoice
     * @param customer      data customer
     * @param totalPrice    totalPrice dari customer
     */
    public Invoice(int id, int idFood, String date, Customer customer, int totalPrice, InvoiceStatus status)
    {
        this.id = id;
        this.idFood = idFood;
        this.date = date;
        this.customer = customer;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    /**
     * accessor getId untuk mengambil id
     * @return id       mengembalikan id
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * accessor getIdFood untuk mengambil idFood
     * @return idFood       mengembalikan idFood
     */
    public int getIdFood()
    {
        return idFood;
    }
    
    /**
     * accessor getDate untuk mengambil date
     * @return date     mengembalikan date
     */
    public String getDate()
    {
        return date;
    }
    
    /**
     * accessor getTotalPrice untuk mengambil totalPrice
     * @return totalPrice     mengembalikan totalPrice
     */
    public int getTotalPrice()
    {
        return totalPrice;   
    }
    
    /**
     * accessor getCustomer untuk mengambil customer
     * @return totalPrice     mengembalikan customer
     */
    public Customer getCustomer()
    {
        return customer;
    }
    
    public PaymentType getPaymentType()
    {
        return paymentType;
    }
    
    public InvoiceStatus getInvoiceStatus()
    {
        return status;
    }
    
    /**
     * mutator setId untuk menetapkan id
     * @param id        id dari invoice
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * mutator setIdFoods untuk menetapkan idFood
     * @param idFood        idFood dari invoice
     */
    public void setIdFoods(int idFood)
    {
        this.idFood = idFood;
    }
    
    /**
     * mutator setDate untuk menetapkan date
     * @param date        date dari invoice
     */
    public void setDate(String date)
    {
        this.date = date;
    }
    
    /**
     * mutator setTotalPrice untuk menetapkan totalProce
     * @param totalPrice        totalPrice dari invoice
     */
    public void setTotalPrice(int totalPrice)
    {
        this.totalPrice = totalPrice;
    }
    
    /**
     * mutator setCustomer untuk menetapkan customer
     * @param customer        customer dari invoice
     */
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    
    public void setPaymentType(PaymentType paymentType)
    {
        this.paymentType = paymentType;
    }
    
    public void setInvoiceStatus(InvoiceStatus invoiceStatus)
    
    {
        this.status = status;
    }
    
    /**
     * mutator printData untuk menampilkan getTotalPrice()
     * @return Nothing.        mengembalikan Nothing
     */
    public void printData()
    {
        System.out.println("===========Invoice===========");
        System.out.println("ID : "+id);
        System.out.println("Food ID : "+idFood);
        System.out.println("Date : "+date);
        System.out.println("Customer : "+customer.getName());
        System.out.println("Total Price : "+totalPrice);
        System.out.println("Status : "+status);
    }
}
