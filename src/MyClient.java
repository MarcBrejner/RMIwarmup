import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyClient{
    public void start() throws NotBoundException, MalformedURLException, RemoteException, InterruptedException {
        String hostname = "192.168.0.107";
        int port = 5000;

        Registry registry = LocateRegistry.getRegistry(hostname,port);
        API stub = (API) registry.lookup("Car");
        System.out.println("Stub received from: "+hostname);
        Car c = stub.getCar();
        c.run();
        c.binaryTree.add(11);
        c.setWheels(100);
        c.run();
        stub.putCar(c);
    }
}  