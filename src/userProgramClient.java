import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class userProgramClient {
    public static void main(String []args) throws RemoteException, MalformedURLException, InterruptedException, NotBoundException {
        MyClient client = new MyClient();
        client.start();
    }
}