import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyServer extends UnicastRemoteObject implements API {


        CarFactory factory;

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

        public static void main(String args[]){
        try{
            API stub = new MyServer();
            Naming.rebind("rmi://localhost:5000/sonoo",stub);
            Car c = new Car();
            CarFactory.addNewCar(c);
            System.out.print(CarFactory.finishedCars.take().getWheels());
        }catch(Exception e){System.out.println(e);}
    }

}
