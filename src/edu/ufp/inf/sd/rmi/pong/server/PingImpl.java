package edu.ufp.inf.sd.rmi.pong.server;

import edu.ufp.inf.sd.rmi.pong.client.PongRI;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class PingImpl extends UnicastRemoteObject implements PingRI {

    public PingImpl(int playerId, String registryIP, int registryPort) throws RemoteException, MalformedURLException, AlreadyBoundException {
        super();
    }

    public void ping(PongRI pongRI, Ball b) throws RemoteException{
        Random generator = new Random();
        int playErr = Math.abs(generator.nextInt(99) + 1);
        if (playErr > 5) {
            pongRI.pong(b);
        }
    }
}