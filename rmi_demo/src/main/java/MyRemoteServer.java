import lombok.extern.slf4j.Slf4j;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Keyto
 * Created on 2019/10/25
 */
@Slf4j
public class MyRemoteServer extends UnicastRemoteObject implements MyRemote {
    private static final int PORT = 12312;

    private MyRemoteServer() throws RemoteException {
        super();
    }

    public static void main(String[] args) {
        try {
            Remote server = new MyRemoteServer();
            LocateRegistry.createRegistry(PORT);
            Naming.rebind("rmi://127.0.0.1:" + PORT + "/Hello", server);
            log.info("server listen on {}", PORT);
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}


