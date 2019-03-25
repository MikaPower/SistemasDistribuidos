package edu.ufp.inf.sd.rmi.lib.server;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface DigLibFactoryRI extends Remote {
    public DigLibSessionRI login (String name, String pw) throws RemoteException;




}
