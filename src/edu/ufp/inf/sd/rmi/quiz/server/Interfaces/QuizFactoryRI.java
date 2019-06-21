package edu.ufp.inf.sd.rmi.quiz.server.Interfaces;


import edu.ufp.inf.sd.rmi.quiz.server.classes.Game;
import edu.ufp.inf.sd.rmi.quiz.server.classes.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface QuizFactoryRI extends Remote {
    public QuizSessionRI login(String name, String Password) throws RemoteException;

    public String registerUser(String name, String password) throws RemoteException;

    public List<Game> getGamesList() throws RemoteException;

    public String JoinGame(User user, String name) throws RemoteException;

    public Game getGameByName(String name) throws RemoteException;

}
