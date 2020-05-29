package hosea.jfood;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Class database postgre yang digunakan untuk mengatur seluruh objek invoice yang dibuat
 * dan dimasukkan ke database yang ada di postgre
 *
 * @author Hosea Yoarana/ NPM: 1706042913
 * @version 27 Mei 2020
 */
public class DatabaseInvoicePostgre
{
    private static ArrayList<Invoice> INVOICE_DATABASE;
    private static ArrayList<Invoice> INVOICE_DATABASE_CUSTOMER;
    private static int lastId = 0;

    /**
     * method accessor yang digunakan untuk mengambil seluruh invoice
     * pada DB
     * @return seluruh invoice pada DB
     */
    public static ArrayList<Invoice> getInvoiceDatabase()
    {
        INVOICE_DATABASE = new ArrayList<>();
        String getInvoiceDatabaseQuery = "SELECT * FROM invoice;";

        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(getInvoiceDatabaseQuery);
            while(rs.next()) {
                int invoiceId = rs.getInt("id");
                Array invoiceFood = rs.getArray("food");
                Date invoiceDate = rs.getDate("date");
                int invoiceTotalPrice = rs.getInt("totalPrice");
                int invoiceCustomer = rs.getInt("customer");
                String invoicePromo = rs.getString("promo");
                int invoiceDeliveryFee = rs.getInt("deliveryFee");
                String invoiceStatus = rs.getString("invoiceStatus");

                String[] food = (String[]) invoiceFood.getArray();
                ArrayList<Food> foods = new ArrayList<>();

                for (int i = 0; i < food.length; i++) {
                    foods.add(DatabaseFoodPostgre.getFoodById(Integer.parseInt(food[i])));
                }

                if (invoicePromo != null) {
                    Invoice cashlessInvoice = new CashlessInvoice(invoiceId, foods, DatabaseCustomerPostgre.getCustomerById(invoiceCustomer), DatabasePromoPostgre.getPromoByCode(invoicePromo));
                    cashlessInvoice.setInvoiceStatus(InvoiceStatus.valueOf(invoiceStatus.toUpperCase()));
                    cashlessInvoice.setTotalPrice();
                    INVOICE_DATABASE.add(cashlessInvoice);
                }
                else {
                    Invoice cashInvoice = new CashInvoice(invoiceId, foods, DatabaseCustomerPostgre.getCustomerById(invoiceCustomer), invoiceDeliveryFee);
                    cashInvoice.setInvoiceStatus(InvoiceStatus.valueOf(invoiceStatus.toUpperCase()));
                    cashInvoice.setTotalPrice();
                    INVOICE_DATABASE.add(cashInvoice);
                }
            }
            rs.close();
            stmt.close();
            c.commit();
            c.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return INVOICE_DATABASE;
    }

    /**
     * method accessor yang digunakan untuk mengambil ID terkahir yang ada
     * pada DB
     * @return ID terakhir pada database invoice
     */
    public static int getLastId()
    {
        String getLastInvoiceIdQuery = "SELECT * FROM invoice ORDER BY id DESC LIMIT 1";
        lastId = 0;

        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(getLastInvoiceIdQuery);
            while (rs.next()) {
                lastId = rs.getInt("id");
            }
            rs.close();
            stmt.close();
            c.commit();
            c.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return lastId;
    }

    /**
     * method accessor yang digunakan untuk mengambil invoice berdasarkan
     * ID pada DB
     * @param id
     * @return invoice berdasarkan ID
     * @throws InvoiceNotFoundExeption
     */
    public static Invoice getInvoiceById (int id) throws InvoiceNotFoundExeption
    {
        Invoice invoice = null;
        String getInvoiceByIdQuery = "SELECT * FROM invoice WHERE id = " + id + ";";

        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(getInvoiceByIdQuery);
            while(rs.next()) {
                int invoiceId = rs.getInt("id");
                Array invoiceFood = rs.getArray("food");
                Date invoiceDate = rs.getDate("date");
                int invoiceTotalPrice = rs.getInt("totalPrice");
                int invoiceCustomer = rs.getInt("customer");
                String invoicePromo = rs.getString("promo");
                int invoiceDeliveryFee = rs.getInt("deliveryFee");
                String invoiceStatus = rs.getString("invoiceStatus");

                String[] food = (String[]) invoiceFood.getArray();
                ArrayList<Food> foods = new ArrayList<>();

                for (int i = 0; i < food.length; i++) {
                    foods.add(DatabaseFoodPostgre.getFoodById(Integer.parseInt(food[i])));
                }

                if (invoicePromo != null) {
                    invoice = new CashlessInvoice(invoiceId, foods, DatabaseCustomerPostgre.getCustomerById(invoiceCustomer), DatabasePromoPostgre.getPromoByCode(invoicePromo));
                    invoice.setInvoiceStatus(InvoiceStatus.valueOf(invoiceStatus.toUpperCase()));
                    invoice.setTotalPrice();
                }
                else {
                    invoice = new CashInvoice(invoiceId, foods, DatabaseCustomerPostgre.getCustomerById(invoiceCustomer), invoiceDeliveryFee);
                    invoice.setInvoiceStatus(InvoiceStatus.valueOf(invoiceStatus.toUpperCase()));
                    invoice.setTotalPrice();
                }
            }
            rs.close();
            stmt.close();
            c.commit();
            c.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return invoice;
    }

    /**
     * method accessor yang digunakan untuk mengambil invoice
     * berdasarkan customer pada DB
     *
     * @param customerId    ID customer yang dicari
     * @return  Informasi invoice yang dicari
     */
    public static ArrayList<Invoice> getInvoiceByCustomer (int customerId)
    {
        INVOICE_DATABASE_CUSTOMER = new ArrayList<>();
        String getInvoiceByCustomerQuery = "SELECT * FROM invoice WHERE customer = " + customerId + ";";

        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(getInvoiceByCustomerQuery);
            while(rs.next()) {
                int invoiceId = rs.getInt("id");
                Array invoiceFood = rs.getArray("food");
                Date invoiceDate = rs.getDate("date");
                int invoiceTotalPrice = rs.getInt("totalPrice");
                int invoiceCustomer = rs.getInt("customer");
                String invoicePromo = rs.getString("promo");
                int invoiceDeliveryFee = rs.getInt("deliveryFee");
                String invoiceStatus = rs.getString("invoiceStatus");

                String[] food = (String[]) invoiceFood.getArray();
                ArrayList<Food> foods = new ArrayList<>();

                for (int i = 0; i < food.length; i++) {
                    foods.add(DatabaseFoodPostgre.getFoodById(Integer.parseInt(food[i])));
                }

                if (invoicePromo != null && !invoicePromo.equals("null")) {
                    Invoice cashlessInvoice = new CashlessInvoice(invoiceId, foods, DatabaseCustomerPostgre.getCustomerById(invoiceCustomer), DatabasePromoPostgre.getPromoByCode(invoicePromo));
                    cashlessInvoice.setInvoiceStatus(InvoiceStatus.valueOf(invoiceStatus.toUpperCase()));
                    cashlessInvoice.setTotalPrice();
                    INVOICE_DATABASE_CUSTOMER.add(cashlessInvoice);
                }else if(invoicePromo != null && invoicePromo.equals("null")){
                    Invoice cashlessInvoice = new CashlessInvoice(invoiceId, foods, DatabaseCustomerPostgre.getCustomerById(invoiceCustomer));
                    cashlessInvoice.setInvoiceStatus(InvoiceStatus.valueOf(invoiceStatus.toUpperCase()));
                    cashlessInvoice.setTotalPrice();
                    INVOICE_DATABASE_CUSTOMER.add(cashlessInvoice);
                }
                else {
                    Invoice cashInvoice = new CashInvoice(invoiceId, foods, DatabaseCustomerPostgre.getCustomerById(invoiceCustomer), invoiceDeliveryFee);
                    cashInvoice.setInvoiceStatus(InvoiceStatus.valueOf(invoiceStatus.toUpperCase()));
                    cashInvoice.setTotalPrice();
                    INVOICE_DATABASE_CUSTOMER.add(cashInvoice);
                }
            }
            rs.close();
            stmt.close();
            c.commit();
            c.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return INVOICE_DATABASE_CUSTOMER;
    }

    /**
     * method yang digunakan untuk menambahkan invoice
     * pada DB
     * @param invoice
     * @return true apabila dapat masuk, false apabila sudah ada yang ONGOING dan mengeluarkan exception
     * @throws OngoingInvoiceAlreadyExistExeption
     */
    public static boolean addInvoice (Invoice invoice) throws OngoingInvoiceAlreadyExistExeption
    {
        String foodIdList = "";
        String checkInvoiceQuery = "SELECT * FROM invoice WHERE customer = " + invoice.getCustomer().getId() + ";";

        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery(checkInvoiceQuery);
            while (rs.next()) {
                String invoiceStatus = rs.getString("invoiceStatus");
                if (invoiceStatus.equals("Ongoing")) {
                    throw new OngoingInvoiceAlreadyExistExeption(invoice);
                }
            }

            for (Food foods : invoice.getFoods()) {
                int foodId = foods.getId();
                foodIdList = foodIdList + '"' +foodId + '"' + ",";
            }
            foodIdList = foodIdList.substring(0, foodIdList.length()-1);

            if (invoice.getPaymentType() == PaymentType.CASH) {
                CashInvoice cashInvoice = (CashInvoice) invoice;
                String addCashInvoiceQuery = "INSERT INTO invoice (id, food, date, totalPrice, customer, promo, deliveryFee, invoiceStatus) VALUES (" + invoice.getId() + ", '{" + foodIdList + "}', '" + invoice.getDate().getTime() + "', " + invoice.getTotalPrice() + ", " + invoice.getCustomer().getId() + ", " + null + ", " +  cashInvoice.getDeliveryFee() + ", '" + invoice.getInvoiceStatus() + "');";
                System.out.println(addCashInvoiceQuery);
                stmt.executeUpdate(addCashInvoiceQuery);
            }
            else if (invoice.getPaymentType() == PaymentType.CASHLESS) {
                CashlessInvoice cashlessInvoice = (CashlessInvoice) invoice;
                if(((CashlessInvoice) invoice).getPromo() != null){
                    String addCashlessInvoiceQuery = "INSERT INTO invoice (id, food, date, totalPrice, customer, promo, deliveryFee, invoiceStatus) VALUES (" + invoice.getId() + ", '{" + foodIdList + "}', '" + invoice.getDate().getTime() + "', " + invoice.getTotalPrice() + ", " + invoice.getCustomer().getId() + ", '" + cashlessInvoice.getPromo().getCode() + "', " + null + ", '" + invoice.getInvoiceStatus() + "');";
                    stmt.executeUpdate(addCashlessInvoiceQuery);
                }else{
                    String addCashlessInvoiceQuery = "INSERT INTO invoice (id, food, date, totalPrice, customer, promo, deliveryFee, invoiceStatus) VALUES (" + invoice.getId() + ", '{" + foodIdList + "}', '" + invoice.getDate().getTime() + "', " + invoice.getTotalPrice() + ", " + invoice.getCustomer().getId() + ",'"+ "null',"+ null + ", '" + invoice.getInvoiceStatus() + "');";
                    stmt.executeUpdate(addCashlessInvoiceQuery);
                }
            }
            stmt.close();
            c.commit();
            c.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return true;
    }

    /**
     * method yang digunakan untuk mengubah status invoice
     * dari ONGOING menjadi FINISHED atau CANCELLED
     * @param id
     * @param invoiceStatus
     * @return true apabila dapat diubah, false apabila tidak ditemukan dan mengeluarkan exception
     */
    public static boolean changeInvoiceStatus (int id, InvoiceStatus invoiceStatus)
    {
        String changeInvoiceStatusQuery = "UPDATE invoice SET invoiceStatus = '" + invoiceStatus + "' WHERE id = " + id + ";";

        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            stmt.executeUpdate(changeInvoiceStatusQuery);
            stmt.close();
            c.commit();
            c.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return true;
    }

    /**
     * method yang digunakan menghapus invoice dari DB
     * @param id
     * @return true apabila dapat dihapus, false apabila tidak ditemukan dan mengeluarkan exception
     * @throws InvoiceNotFoundExeption
     */
    public static boolean removeInvoice (int id) throws InvoiceNotFoundExeption
    {
        String removeInvoiceQuery = "DELETE FROM invoice WHERE id = " + id + ";";

        try {
            Connection c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            stmt.executeUpdate(removeInvoiceQuery);
            stmt.close();
            c.commit();
            c.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return true;
    }
}

