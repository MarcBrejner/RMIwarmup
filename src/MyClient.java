import java.net.MalformedURLException;
import java.rmi.*;
public class MyClient{
    public void start() throws NotBoundException, MalformedURLException, RemoteException, InterruptedException {
        String hostname = "localhost";
        String port = "5000";
        String connectLocation = "//" + hostname + ":" + port + "/car";

        API stub= (API) Naming.lookup(connectLocation);
        System.out.println("Ost");

        Car c = stub.getCar();
        c.run();
        c.setWheels(100);
        c.run();
        stub.putCar(c);
    }
}  