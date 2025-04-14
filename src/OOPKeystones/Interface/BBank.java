package OOPKeystones.Interface;

public class BBank implements IBanka{
    private String bankName;
    private String terminalID;
    private String password;



    public BBank(String bankName, String terminalID, String password) {
        this.bankName = bankName;
        this.terminalID = terminalID;
        this.password = password;
    }




    @Override
    public boolean connect(String ipAddress, int port) {
        System.out.println("Connecting to B Bank with" + ipAddress + ":" + port);
        return true;
    }

    @Override
    public boolean payment(double price, String cardNumber, String expiryDate, String cvv) {
        System.out.println("Payment Success with card number"+cardNumber);
        return true;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getTerminalID() {
        return terminalID;
    }

    public void setTerminalID(String terminalID) {
        this.terminalID = terminalID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
