package edu.ufp.inf.sd.rmi.observer.client;

import java.rmi.RemoteException;

public interface ObserverRI {

    public void update() throws RemoteException;
}
