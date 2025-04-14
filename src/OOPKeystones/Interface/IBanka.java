package OOPKeystones.Interface;

public interface IBanka {

    final String hostIpAddress = "127.0.0.1";
    final int portNumber = 3000;

    boolean connect(String ipAddress, int port);
    boolean payment(double price, String cardNumber, String expiryDate, String cvv);
}
