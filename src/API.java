import java.rmi.*;
public interface API extends Remote{
    public int add(int x,int y)throws RemoteException;
    public Car getCar()throws RemoteException,InterruptedException;
    public void putCar(Car car) throws RemoteException;
}  