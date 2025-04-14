package OOPKeystones.Interface;

public interface PaymentProvider {

    // All functions in the interface are abstract.
    // These abstract functions are filled in subclasses that inherit from the interface.

        public boolean cancelCharge(int chargeId);
        public int charge(double totalPrice);
        public String loadInvoice(int chargeId);

}
