import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.LinkedBlockingQueue;

public class CarFactory implements API {
    public static LinkedBlockingQueue<Car> cars = new LinkedBlockingQueue<Car>();
    public static LinkedBlockingQueue<Car> finishedCars = new LinkedBlockingQueue<Car>();

    public int add(int x,int y){return x+y;}

    public static void addNewCar(Car car){
        cars.add(car);
    }

    public Car getCar() throws InterruptedException{
        return cars.take();
    }

    public void putCar(Car ca) throws RemoteException{
        finishedCars.add(ca);
    }

    public void start() throws RemoteException, InterruptedException , AlreadyBoundException {
        API server = new CarFactory();
        API stub = (API) UnicastRemoteObject.exportObject(server,0);
        Registry registry = LocateRegistry.createRegistry(5000);
        registry.bind("Car",stub);
    }
}