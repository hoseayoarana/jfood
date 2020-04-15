package hosea.jfood;
public class OngoingInvoiceAlreadyExistExeption extends Exception{
    private Invoice invoice_error;
    public OngoingInvoiceAlreadyExistExeption(Invoice invoice_input) {
        super("Invoice Status: ");
        invoice_error = invoice_input;
    }

    public String getMessage() {
        return super.getMessage() + invoice_error.getInvoiceStatus() + " already Exist.";
    }
}
