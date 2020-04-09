public class EmailAlreadyExistsException extends Exception {
    private Customer customer_error;
    public EmailAlreadyExistsException(Customer customer_input) {
        super("Customer Email: ");
        customer_error = customer_input;
    }

    public String getExMessage() {
        return super.getMessage() + customer_error.getEmail() +  " already exists.";
    }
}
