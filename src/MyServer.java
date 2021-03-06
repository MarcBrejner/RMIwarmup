
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.LinkedBlockingQueue;
/*
public class MyServer implements API {
        public static LinkedBlockingQueue<Car> cars = new LinkedBlockingQueue<Car>();
        public static LinkedBlockingQueue<Car> finishedCars = new LinkedBlockingQueue<Car>();

        CarFactory factory;

        protected MyServer() throws RemoteException {
            factory = new CarFactory();
        }


        public int add(int x,int y)throws RemoteException{
            return 2+2;
        }

        public Car getCar()throws RemoteException,InterruptedException{
            return CarFactory.getCar();
        }

        public void putCar(Car car) throws RemoteException{
            CarFactory.putCar(car);
        }

        public void start() throws RemoteException, InterruptedException , AlreadyBoundException {
            factory = new CarFactory();
            API server = new MyServer();
            API stub = (API) UnicastRemoteObject.exportObject(server,0);
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
*/