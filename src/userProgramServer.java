import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class userProgramServer {
    public static void main(String []args) throws RemoteException, MalformedURLException, InterruptedException {
        MyServer server = new MyServer();
        server.start();
    }
}
