package edu.ufp.inf.sd.rmi.pong.server;

import edu.ufp.inf.sd.rmi.pong.client.PongRI;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface PingRI extends Remote {
    public void ping(PongRI pongRI, Ball b) throws RemoteException;
}