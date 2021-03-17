import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MyServer implements API {

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

        public static void main(String args[]){

        /*
        String hostname = "192.168.0.107";
        String port = "5000";
        String bindLocation = "//" + hostname + ":" + port + "/car";
        */

        try{
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

        }catch(Exception e){System.out.println(e);}
    }

}
