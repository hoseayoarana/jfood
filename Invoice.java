
/**
 * Class Invoice berisi id, idFood, date, totalPrice, dan customer untuk dijadikan sebuah invoice
 *
 * @author Hosea Yoarana
 * @version 27-02-2020
 */
public abstract class Invoice
{
    // bagian ini berisi variabel yang nantinya digunakan sebagai parameter objek
    private int id;                 // id dari invoice
    private Food food;             // idFood dari invoice
    private String date;            // tanggal dari invoice
    protected int totalPrice;         // totalPrice dari invoice
    private Customer customer;      // data customer
    private PaymentType paymentType;
    private InvoiceStatus invoiceStatus;

    /**
     * Inisiasi variabel kedalam method public untuk datatype Invoice
     * @param id            id dari invoice
     * @param idFood        idFood dari invoice
     * @param date          tanggal dari invoice
     * @param customer      data customer
     * @param totalPrice    totalPrice dari customer
     */
    public Invoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus)
    {
        this.id = id;
        this.food = food;
        this.date = date;
        this.customer = customer;
        this.invoiceStatus = invoiceStatus;
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
    public Food getFood()
    {
        return food;
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
    protected int getTotalPrice()
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
    
    public abstract PaymentType getPaymentType();
    
    public InvoiceStatus getInvoiceStatus()
    {
        return invoiceStatus;
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
        this.food = food;
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
    public abstract void setTotalPrice();
    
    /**
     * mutator setCustomer untuk menetapkan customer
     * @param customer        customer dari invoice
     */
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    
    /*public void setPaymentType(PaymentType paymentType)
    {
        this.paymentType = paymentType;
    }
    */
    public void setInvoiceStatus(InvoiceStatus invoiceStatus)
    
    {
        this.invoiceStatus = invoiceStatus;
    }
    
    /**
     * mutator printData untuk menampilkan getTotalPrice()
     * @return Nothing.        mengembalikan Nothing
     */
    public abstract void printData();
    /*{
        System.out.println("===========Invoice===========");
        System.out.println("ID : "+id);
        System.out.println("Food ID : "+food);
        System.out.println("Date : "+date);
        System.out.println("Customer : "+customer.getName());
        System.out.println("Total Price : "+totalPrice);
        System.out.println("Status : "+invoiceStatus);
    }
    */
}
