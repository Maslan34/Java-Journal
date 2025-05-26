package DesignPatterns.Structural.Proxy.Protection;

public class DocumentProxy implements Document {

    RealDocument realDocument = new RealDocument();


    @Override
    public String getDocument(String username, String password) {

        try {
            String data = realDocument.getDocument(username, password);
            return data;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }


    }

}
