import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyServer extends UnicastRemoteObject implements API {

        CarFactory factory;
        String hostname = "localhost";
        String port = "5000";
        String bindLocation = "//" + hostname + ":" + port + "/car";

        protected MyServer() throws RemoteException {
            super();
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

        public void start() throws RemoteException, MalformedURLException, InterruptedException {
            API stub = new MyServer();
            Naming.rebind(bindLocation,stub);
            Car c = new Car();
            CarFactory.addNewCar(c);
            System.out.print(CarFactory.finishedCars.take().getWheels());
        }
    }
