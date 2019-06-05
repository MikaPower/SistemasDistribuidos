package edu.ufp.inf.sd.rmi.pong.server;

import edu.ufp.inf.sd.rmi.pong.client.PongRI;
import edu.ufp.inf.sd.rmi.util.rmisetup.SetupContextRMI;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PingServer {

    private SetupContextRMI contextRMI;

    private PingRI myRI;

    public static void main(String[] args) {
        if (args != null && args.length < 3) {
            System.exit(-1);
        } else {
            PingServer srv = new PingServer(args);
        }
    }


    public PingServer(String args[]) {
        int playerID = 1;
        String registryIP = "127.0.0.1";
        int registryPort = 1099;
        String serviceAddress = "rmi://" + registryIP + ":" + registryPort + "/PingPongService";
        PingImpl test = null;
        try {

            test = new PingImpl(playerID, registryIP, registryPort);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
        try {

            //Binding a name for a remote object is associating or
            // registering a name for a remote object that can be used at a later time to look up that remote object.
            // A remote object can be associated with a name using the Naming class's bind or rebind methods
            Naming.bind(serviceAddress, test);
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
