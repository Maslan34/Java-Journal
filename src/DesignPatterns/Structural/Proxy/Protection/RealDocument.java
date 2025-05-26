package DesignPatterns.Structural.Proxy.Protection;

public class RealDocument implements Document {

    private String USERNAME = "Muharrem";
    private String PASSSWORD = "12345";
    private String DATA = "SENSETIVE_DATA";

    @Override
    public String getDocument(String username, String password) throws Exception {
        if (username.equals(USERNAME) && password.equals(PASSSWORD))
            return DATA;
        else
            throw new Exception("Access Denied");

    }
}
