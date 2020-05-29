package hosea.jfood.controller;

import hosea.jfood.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


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
@RequestMapping("/customer")
@CrossOrigin(origins = "", allowedHeaders = "")
@RestController
public class CustomerController {

    /**
     * Method yang digunakan untuk menghubungkan informasi seluruh customer pada database customer
     *
     * @RequestMapping "" = String kosong, menandakan sama dengan requestMapping pada class.
     * @return  Informasi seluruh customer pada database customer
     */
    @RequestMapping("")
    public ArrayList<Customer> indexPage()
    {
        return DatabaseCustomer.getCustomerDatabase();
    }

    /**
     * Method yang digunakan untuk menghubungkan ID customer pada database.
     * Method ini digunakan dalam mengambil customer berdasarkan ID nya.
     *
     * @RequestMapping /{id} dengan method GET
     * @PathVariable int id
     * @return  ID customer pada database customer
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable int id)
    {
        Customer customer = null;
        try {
            customer = DatabaseCustomerPostgre.getCustomerById(id);
        } catch (CustomerNotFoundException e) {
            e.getMessage();
            return null;
        }
        return customer;
    }

    /**
     * Method yang digunakan untuk menghubungkan ketika mendaftarkan customer baru.
     *
     * @RequestMapping /register dengan method POST
     * @RequestParam name, email, password
     * @return  customer ke DatabaseCustomerPostgre
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Customer registerCustomer(@RequestParam(value="name") String name,
                                @RequestParam(value="email") String email,
                                @RequestParam(value="password") String password)
    {
        Customer customer = new Customer(DatabaseCustomerPostgre.getCustomerLastId()+1, name, email, password);
        try {
            DatabaseCustomerPostgre.insertCustomer(customer);
        } catch (EmailAlreadyExistsException e) {
            e.getMessage();
            return null;
        }
        return customer;
    }

    /**
     * Method yang digunakan untuk menghubungkan ID customer pada database.
     * Method ini digunakan dalam mengambil customer berdasarkan ID nya.
     *
     * @RequestMapping /logincust dengan method POST
     * @RequestParam email, password
     * @return  email dan password
     */
    @RequestMapping(value = "/logincust", method = RequestMethod.POST)
    public Customer loginCust( @RequestParam(value="email") String email,
                               @RequestParam(value="password") String password)
    {
        return DatabaseCustomerPostgre.CustomerLogin(email, password);
    }
}