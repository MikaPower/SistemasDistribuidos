package edu.ufp.inf.sd.rmi.lib.client;

import edu.ufp.inf.sd.rmi.lib.server.DigLibSessionRI;

import java.rmi.RemoteException;

public interface LibClientRi {
    public DigLibSessionRI login() throws RemoteException;

}
