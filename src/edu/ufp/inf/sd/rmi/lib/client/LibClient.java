package edu.ufp.inf.sd.rmi.lib.client;

import edu.ufp.inf.sd.rmi.lib.server.Book;
import edu.ufp.inf.sd.rmi.lib.server.DigLibFactoryRI;
import edu.ufp.inf.sd.rmi.lib.server.DigLibSessionRI;
import edu.ufp.inf.sd.rmi.util.rmisetup.SetupContextRMI;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class  LibClient {


    private SetupContextRMI contextRMI;
    private DigLibFactoryRI myRI;

    public static void main(String[] args) {
        if (args != null && args.length < 2) {
            System.exit(-1);
        } else {
            LibClient clt = new LibClient(args);
            clt.lookupService();
            clt.playService();
        }
    }

    public LibClient(String[] args) {
        try {
            String registryIP   = args[0];
            String registryPort = args[1];
            String serviceName  = args[2];
            contextRMI = new SetupContextRMI(this.getClass(), registryIP, registryPort, new String[]{serviceName});
        } catch (RemoteException e) {
            Logger.getLogger(LibClient.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private Remote lookupService() {
        try {
            Registry registry = contextRMI.getRegistry();
            if (registry != null) {
                String serviceUrl = contextRMI.getServicesUrl(0);                
                myRI = (DigLibFactoryRI) registry.lookup(serviceUrl);
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
            DigLibSessionRI session= this.myRI.login("guest","ufp");
            if(session!=null){
                Book[]  a=session.search("World","Alves");
               //  a=session.search("Distributed","Tanenbaum");
                if(a.length>0){
                    for(Book temp: a){
                        System.out.println("book ->"+temp.getAuthor());
                    }
                }
                else{
                    System.out.println("vazio!");
                }
                a=session.search("Distributed","Tanenbaum");
                System.out.println( a[0].getAuthor());
                session.logout();
            }
        } catch (RemoteException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
}
