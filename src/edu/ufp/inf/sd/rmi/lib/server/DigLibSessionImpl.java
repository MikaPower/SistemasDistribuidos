package edu.ufp.inf.sd.rmi.lib.server;

import edu.ufp.inf.sd.rmi.lib.client.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DigLibSessionImpl implements DigLibSessionRI {

    protected DigLibFactoryImpl factory;
    private User user;

    public DigLibSessionImpl(DigLibFactoryImpl f,User u) throws RemoteException {
        this.factory=f;
        this.user=u;
       exp();
    }


    public void exp() throws RemoteException {
        UnicastRemoteObject.exportObject( this,0);
    }

    public  Book[] search(String title,String author) throws RemoteException{
        return this.factory.getDb().select(title,author);
    }

    public void logout() throws RemoteException{
        System.out.println("logout "+ this.user.getUname());
        this.factory.removeDibLibSession(this.user.getUname());
    }





}
