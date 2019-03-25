package edu.ufp.inf.sd.rmi.pong.client;

import edu.ufp.inf.sd.rmi.pong.server.Ball;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface PongRI extends Remote {
   public void pong(Ball b) throws RemoteException;
}