package hosea.jfood.controller;

import hosea.jfood.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import jdk.jfr.Frequency;
import org.springframework.web.bind.annotation.*;

/**
 * Merupakan class yang mengatur simple web application untuk Customer.
 * Kelas ditandai sebagai @ RestController,
 * artinya siap digunakan oleh Spring MVC untuk menangani permintaan web.
 * @ RequestMapping maps / ke metode index (). Ketika dipanggil dari browser
 * atau dengan menggunakan url pada baris perintah, metode mengembalikan teks.
 *
 * @author Hosea Yoarana/ NPM: 1706042913
 * @version 27 Mei 2020
 */
@CrossOrigin(origins = "", allowedHeaders = "")
@RestController
public class InvoiceController
{
    /**
     * Method yang digunakan untuk menghubungkan informasi seluruh invoice pada database invoice
     *
     * @RequestMapping /invoice dengan method GET
     * @return  Informasi seluruh customer pada database customer
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/invoice", method = RequestMethod.GET)
    public ArrayList<Invoice> getAllInvoice()
    {
        ArrayList<Invoice> invoice = new ArrayList<Invoice>();
        try{
            invoice = DatabaseInvoicePostgre.getInvoiceDatabase();
        }catch(Exception ex){
            ex.getMessage();
            return null;
        }
        return invoice;
    }

    /**
     * Method yang digunakan untuk menghubungkan ID invoice pada database.
     * Method ini digunakan dalam mengambil invoice berdasarkan ID nya.
     *
     * @RequestMapping /invoice/{idInvoice} dengan method GET
     * @PathVariable int idInvoice
     * @return  ID invoice pada database invoice
     */
    @RequestMapping(value = "/invoice/{idInvoice}", method = RequestMethod.GET)
    public Invoice getInvoiceById(@PathVariable int idInvoice)
    {
        Invoice invoice = null;
        try {
            invoice = DatabaseInvoicePostgre.getInvoiceById(idInvoice);
        }
        catch (InvoiceNotFoundExeption e) {
            e.getMessage();
            return null;
        }
        return invoice;
    }

    /**
     * Method yang digunakan untuk menghubungkan ID invoice pada database.
     * Method ini digunakan dalam mengambil invoice berdasarkan Customer ID nya.
     *
     * @RequestMapping /invoice/invoice/{customerId} dengan method GET
     * @PathVariable int customerId
     * @return  customer invoice pada database invoice
     */
    @RequestMapping(value = "/invoice/invoice/{customerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByCustomerId(@PathVariable int customerId)
    {
        ArrayList<Invoice> customer = null;
        try {
            customer = DatabaseInvoicePostgre.getInvoiceByCustomer(customerId);
        }
        catch (Exception e) {
            e.getMessage();
            return null;
        }
        return customer;
    }

    /**
     * Method yang digunakan untuk menghubungkan ID invoice pada database.
     * Method ini digunakan dalam mengambil invoice berdasarkan Customer ID nya.
     *
     * @RequestMapping /invoice/customer/{customerId} dengan method GET
     * @PathVariable int customerId
     * @return  customer invoice pada database invoice
     */
    @RequestMapping(value = "invoice/customer/{customerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByCustomer(@PathVariable int customerId)
    {
        ArrayList<Invoice> invoice = null;
        try {
            invoice = DatabaseInvoicePostgre.getInvoiceByCustomer(customerId);
        }
        catch (Exception e) {
            e.getMessage();
            return null;
        }
        return invoice;
    }

    /**
     * Method yang digunakan untuk menghubungkan perubahan invoicestatus pada database.
     * Method ini digunakan dalam mengambil invoicestatus berdasarkan id invoice.
     *
     * @RequestMapping invoice/invoiceStatus/{id} dengan method PUT
     * @PathVariable int id
     * @RequestParam status
     * @throws InvoiceNotFoundExeption
     * @return ubah invoicestatus
     */
    @RequestMapping(value = "invoice/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id,
                                       @RequestParam(value = "status") InvoiceStatus status) throws InvoiceNotFoundExeption
    {
        if (DatabaseInvoicePostgre.changeInvoiceStatus(id, status)){
            return DatabaseInvoicePostgre.getInvoiceById(id);
        }
        return null;
    }

    /**
     * Method yang digunakan untuk menghubungkan ketika menghapus invoice.
     *
     * @RequestMapping invoice/{id} dengan method DELETE
     * @PathVariable int id
     * @return  false ketika tidak ada invoice, true ketika invoice berhasil dihapus
     */
    @RequestMapping(value = "invoice/{id}", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@PathVariable int id)
    {
        try{
            DatabaseInvoicePostgre.removeInvoice(id);
        }catch (Exception e){
            e.getMessage();
            return false;
        }
        return true;
    }

    /**
     * Method yang digunakan untuk menghubungkan ketika menambahkan cash invoice baru.
     *
     * @RequestMapping invoice/createCashInvoice dengan method POST
     * @RequestParam makanan, customer, deliveryFee
     * @return  invoice ke DatabaseInvoicePostgre
     */
    @RequestMapping(value = "invoice/createCashInvoice", method = RequestMethod.POST)
    public Invoice addCashInvoice(@RequestParam(value="makanan") ArrayList<Integer> makanan,
                                  @RequestParam(value="customer") int customer,
                                  @RequestParam(value="deliveryFee", defaultValue = "0") int deliveryFee)
    {
        ArrayList<Food> foods = new ArrayList<>();
        for (int food : makanan) {
            try {
                foods.add(DatabaseFoodPostgre.getFoodById(food));
            } catch (FoodNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        Invoice invoice = null;
        try {
            invoice = new CashInvoice(DatabaseInvoicePostgre.getLastId() + 1,foods, DatabaseCustomerPostgre.getCustomerById(customer), deliveryFee);
            invoice.setTotalPrice();
            DatabaseInvoicePostgre.addInvoice(invoice);
        } catch (CustomerNotFoundException | OngoingInvoiceAlreadyExistExeption e) {
            System.out.println(e.getMessage());
            return null;
        }
        return invoice;
    }

    /**
     * Method yang digunakan untuk menghubungkan ketika menambahkan cashless invoice baru.
     *
     * @RequestMapping invoice/createCashlessInvoice dengan method POST
     * @RequestParam makanan, customer, promoCode
     * @throws CustomerNotFoundException
     * @return  invoice ke DatabaseInvoicePostgre
     */
    @RequestMapping(value = "invoice/createCashlessInvoice", method = RequestMethod.POST)
    public Invoice addCashlessInvoice(@RequestParam(value="makanan") ArrayList<Integer> makanan,
                                      @RequestParam(value="customer") int customer,
                                      @RequestParam(value="promoCode", defaultValue = "", required = false) String promoCode) throws CustomerNotFoundException
    {
        ArrayList<Food> foods = new ArrayList<>();
        for (int food : makanan) {
            try {
                foods.add(DatabaseFoodPostgre.getFoodById(food));
            } catch (FoodNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        Invoice newCashlessInvoice = new CashlessInvoice(DatabaseInvoicePostgre.getLastId() + 1, foods, DatabaseCustomerPostgre.getCustomerById(customer), DatabasePromoPostgre.getPromoByCode(promoCode));
        newCashlessInvoice.setTotalPrice();
        try{
            DatabaseInvoicePostgre.addInvoice(newCashlessInvoice);
        } catch (OngoingInvoiceAlreadyExistExeption e) {
            e.getMessage();
            return null;
        }
        return newCashlessInvoice;
    }
}
