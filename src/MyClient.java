import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyClient{
    public static void main(String args[]){
        try{
            String hostname = "192.168.0.107";
            String port = "5000";
            String connectLocation = "//" + hostname + ":" + port + "/car";

            Registry registry = LocateRegistry.getRegistry(5000);
            API stub = (API) registry.lookup(connectLocation);
            System.out.println("Ost");

            Car c = stub.getCar();
            System.out.println("qq");
            c.run();
            c.binaryTree.add(11);
            c.setWheels(100);
            c.run();
            stub.putCar(c);

        }catch(Exception e){System.out.println(e);}
    }
}