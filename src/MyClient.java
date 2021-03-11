import java.rmi.*;
public class MyClient{
    public static void main(String args[]){
        try{
            API stub= (API) Naming.lookup("rmi://localhost:5000/sonoo");
            System.out.println("Ost");

            Car c = stub.getCar();
            c.run();
            c.setWheels(100);
            c.run();
            stub.putCar(c);

        }catch(Exception e){}
    }
}  