import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Keyto
 * Created on 2019/10/25
 */
public interface MyRemote extends Remote {

      String sayHello(String name) throws RemoteException;
}
