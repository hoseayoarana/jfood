package hosea.jfood;
public class PromoCodeAlreadyExistsException extends Exception{
    private Promo promo_error;
    public PromoCodeAlreadyExistsException(Promo promo_input) {
        super("Promo code: ");
        promo_error = promo_input;
    }

    public String getExMessage() {
        return super.getMessage() + promo_error.getCode() + " already exists.";
    }
}
