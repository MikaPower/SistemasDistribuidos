package edu.ufp.inf.sd.rmi.pong.client;

import edu.ufp.inf.sd.rmi.pong.server.PingImpl;
import edu.ufp.inf.sd.rmi.pong.server.PingRI;
import edu.ufp.inf.sd.rmi.util.rmisetup.SetupContextRMI;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class  PongClient {


    private SetupContextRMI contextRMI;
    private PingRI myRI;

    public static void main(String[] args) throws RemoteException {

        if(args.length==3){
            String rmiRegistryIp=args[0];
          int  rmiRegistryPort=Integer.parseInt(args[1]);
           int  playerId= Integer.parseInt(args[2]);
         new PingImpl(playerId,rmiRegistryIp,rmiRegistryPort);

        }



        if (args != null && args.length < 2) {
            System.exit(-1);
        } else {
            PongClient clt = new PongClient(args);
            clt.lookupService();
            clt.playService();
        }
    }

    public PongClient(String[] args) {
        try {
            String registryIP   = args[0];
            String registryPort = args[1];
            String serviceName  = args[2];
            contextRMI = new SetupContextRMI(this.getClass(), registryIP, registryPort, new String[]{serviceName});
        } catch (RemoteException e) {
            Logger.getLogger(PongClient.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private Remote lookupService() {
        try {
            Registry registry = contextRMI.getRegistry();
            if (registry != null) {
                String serviceUrl = contextRMI.getServicesUrl(0);                
                myRI = (PingRI) registry.lookup(serviceUrl);
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, "registry not bound (check IPs). :(");
            }
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return myRI;
    }
    
    private void playService() {
        try {
            this.myRI.methodName();
        } catch (RemoteException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
}
