package hosea.jfood.controller;

import hosea.jfood.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class InvoiceController {

    @RequestMapping(value = "/invoice", method = RequestMethod.GET)
    public ArrayList<Invoice> getAllInvoice()
    {
        return DatabaseInvoice.getInvoiceDatabase();
    }

    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.GET)
    public Invoice getInvoiceById(@PathVariable int id) {
        Invoice invoice = null;
        try
        {
            invoice = DatabaseInvoice.getInvoiceById(id);
        }
        catch (InvoiceNotFoundExeption e)
        {
            System.out.println(e.getMessage());
        }
        return invoice;
    }

    @RequestMapping(value = "/invoice/customer/{customerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoice(@PathVariable int id) {
        return DatabaseInvoice.getInvoiceByCustomer(id);
    }

    @RequestMapping(value = "/invoice/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@RequestBody int id, @RequestBody InvoiceStatus status)
    {
        Invoice invoice = null;
        if(status == InvoiceStatus.ONGOING)
        {
            DatabaseInvoice.changeInvoiceStatus(id, status);
            try
            {
                invoice = DatabaseInvoice.getInvoiceById(id);
            }
            catch (InvoiceNotFoundExeption e)
            {
                System.out.println(e.getMessage());
            }
            return invoice;
        }return null;
    }

    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@PathVariable int id)
    {
        try
        {
            DatabaseInvoice.removeInvoice(id);
        }
        catch (InvoiceNotFoundExeption e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @RequestMapping(value = "/invoice/createCashInvoice", method = RequestMethod.POST)
    public Invoice addCashInvoice(@RequestParam(value="FoodIdList") ArrayList<Integer> foodIdList,
                          @RequestParam(value="customerId") int customerId,
                          @RequestParam(value="deliveryFee") int deliveryFee){
        Invoice cashInvoice = null;
        ArrayList<Food> foodList = new ArrayList<>();
        for(Integer foodId : foodIdList){
            try {
                foodList.add(DatabaseFood.getFoodById(foodId));
            } catch (FoodNotFoundException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        try {
            cashInvoice = new cashInvoice(DatabaseInvoice.getLastId()+1,foodList,DatabaseCustomer.getCustomerById(customerId));
        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
