import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class userProgramServer {
    public static void main(String []args) throws RemoteException, AlreadyBoundException, InterruptedException {
        MyServer server = new MyServer();
        server.start();
    }
}
