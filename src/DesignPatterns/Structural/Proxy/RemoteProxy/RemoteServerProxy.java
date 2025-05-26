package DesignPatterns.Structural.Proxy.RemoteProxy;

public class RemoteServerProxy {
    private RealServer realServer;

    public void execute() {
        System.out.println("Remote call made to server from proxy...");
        realServer = new RealServer(); // burada gerçek uygulamada uzak bir sunucuya istek olur.
        realServer.execute();
    }
}
