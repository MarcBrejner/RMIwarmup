import java.rmi.*;
import java.util.concurrent.LinkedBlockingQueue;

public class CarFactory {
    public static LinkedBlockingQueue<Car> cars = new LinkedBlockingQueue<Car>();
    public static LinkedBlockingQueue<Car> finishedCars = new LinkedBlockingQueue<Car>();

    public static int add(int x,int y){return x+y;}

    public static void addNewCar(Car car){
        cars.add(car);
    }

    public static Car getCar() throws InterruptedException{
        return cars.take();
    }

    public static void putCar(Car ca) throws RemoteException{
        finishedCars.add(ca);
    }

    public void initialize() throws RemoteException, InterruptedException, AlreadyBoundException{
        MyServer server = new MyServer();
        server.start();
    }


}