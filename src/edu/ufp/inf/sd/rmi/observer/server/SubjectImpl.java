package edu.ufp.inf.sd.rmi.observer.server;

import edu.ufp.inf.sd.rmi.observer.client.ObserverRI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class SubjectImpl extends UnicastRemoteObject implements SubjectRI {

   private State observerState;
   private ArrayList<edu.ufp.inf.sd.rmi.observer.client.ObserverRI> observer;

   public SubjectImpl() throws RemoteException {
       super();
       observerState = new State("","");
       observer= new ArrayList<>();


   }

   public void attach (ObserverRI observerRI) throws RemoteException{
       observer.add(observerRI);

   }

   public void dettach (edu.ufp.inf.sd.rmi.observer.client.ObserverRI observerRI) throws RemoteException{
       observer.remove(observerRI);

   }
    @Override
    public State getState() throws RemoteException {

        return this.observerState;
    }

    @Override
    public void setState(State state) throws RemoteException {

        this.observerState = state;

        for (ObserverRI obs: this.observer) {
            obs.update();
        }
    }







}