package edu.ufp.inf.sd.rmi.observer.client;


import edu.ufp.inf.sd.rmi.observer.server.State;
import edu.ufp.inf.sd.rmi.observer.server.SubjectRI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObserverImpl extends UnicastRemoteObject implements ObserverRI {
    private String id;
    private State lastObserverState;
    protected SubjectRI subjectRI;
    private ObserverGuiClient chatframe;



 public    ObserverImpl(String id, ObserverGuiClient f,String[] args) throws RemoteException, MalformedURLException, NotBoundException {
     String serviceAddress = "rmi://" + args[0] + ":" + args[1] + "/ObserverService";
        this.id=id;
        this.setLastObserverState(new State(id,""));
        this.chatframe= f;
        this.subjectRI =(SubjectRI) Naming.lookup(serviceAddress);//naming lookup;
     UnicastRemoteObject.exportObject( this,0);
        this.subjectRI.attach(this);

    }

    public void update() throws RemoteException{
     this.setLastObserverState(this.subjectRI.getState());
     //this.chatframe.updateTextArea();

    }

    public State getLastObserverState() {
     return lastObserverState;
    }

    public void setLastObserverState(State lastObserverState) {
        this.lastObserverState = lastObserverState;
    }
}
