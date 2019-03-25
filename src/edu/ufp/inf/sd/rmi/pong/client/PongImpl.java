package edu.ufp.inf.sd.rmi.pong.client;

import edu.ufp.inf.sd.rmi.pong.server.Ball;
import edu.ufp.inf.sd.rmi.pong.server.PingImpl;
import edu.ufp.inf.sd.rmi.pong.server.PingRI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class PongImpl implements PongRI {

    private PingRI pingRI;
    private Ball ball;

    public PongImpl(int playerId, String registryIP, int registryPort) throws RemoteException, MalformedURLException, NotBoundException {
        String serviceAddress = "rmi://" + registryIP + ":" + registryPort + "/PingPongService";
        this.pingRI = (PingRI) Naming.lookup(serviceAddress);
        this.ball = new Ball(playerId);
        this.startPlaying();
    }

    private void startPlaying() throws RemoteException {
        Remote exportObject = UnicastRemoteObject.exportObject(this, 0);
        pingRI.ping((PongRI) this, ball);
    }

    public void pong(Ball b) throws RemoteException {
        Random generator = new Random();
        int playErr = Math.abs(generator.nextInt(99) + 1);
        if (playErr >= 5) {
            pingRI.ping((PongRI) this, b);
        }
    }
}