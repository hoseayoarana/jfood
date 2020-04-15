package hosea.jfood;
public class PromoNotFoundException extends Exception{
    private int promo_error;
    public PromoNotFoundException(int promo_input) {
        super("Promo ID: ");
        promo_error = promo_input;
    }

    public String getMessage() {
        return super.getMessage() + promo_error + " not found.";
    }
}
