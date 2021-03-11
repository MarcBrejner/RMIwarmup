import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public static void test() throws InterruptedException {
                ArrayList<Car> carList = new ArrayList<Car>();
                Car c = new Car();
                addNewCar(c);
                System.out.println(finishedCars.take().getWheels());
    }


}