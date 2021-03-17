import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.LinkedBlockingQueue;


public class CarFactory implements API {
    public static LinkedBlockingQueue<Car> cars = new LinkedBlockingQueue<Car>();
    public static LinkedBlockingQueue<Car> finishedCars = new LinkedBlockingQueue<Car>();

    public int add(int x,int y)throws RemoteException{
        return 2+2;
    }

    public static void addNewCar(Car car){
        cars.add(car);
    }

    public Car getCar() throws InterruptedException, RemoteException{
        return cars.take();
    }

    public void putCar(Car ca) throws RemoteException{
        finishedCars.add(ca);
    }

    public void start() throws RemoteException, InterruptedException , AlreadyBoundException {
        API api = new CarFactory();
        API stub = (API) UnicastRemoteObject.exportObject(api,0);
        Registry registry = LocateRegistry.createRegistry(5000);
        registry.bind("Car",stub);

        Car c = new Car();
        c.run();
        CarFactory.addNewCar(c);

        Car q = CarFactory.finishedCars.take();
        System.out.print(q.getWheels());
        q.run();
    }




}