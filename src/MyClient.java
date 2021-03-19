import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyClient{
    public void start(String host) throws NotBoundException, MalformedURLException, RemoteException, InterruptedException {
        int port = 1099;
        System.setProperty("java.rmi.server.host", host);

        Registry registry = LocateRegistry.getRegistry(host,port);
        API stub = (API) registry.lookup("Car");
        System.out.println("Stub received from: "+host);
        Car c = stub.getCar();
        c.run();
        c.binaryTree.add(11);
        c.setWheels(100);
        c.run();
        stub.putCar(c);
    }
}  