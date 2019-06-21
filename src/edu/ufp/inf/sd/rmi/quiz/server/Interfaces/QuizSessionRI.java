package edu.ufp.inf.sd.rmi.quiz.server.Interfaces;

import edu.ufp.inf.sd.rmi.quiz.server.classes.Game;
import edu.ufp.inf.sd.rmi.quiz.server.classes.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface QuizSessionRI extends Remote {
    public void startNewGame(String name, int points) throws RemoteException;
public List<Game> getAllGames() throws RemoteException;
public Game getGameByName(String name) throws RemoteException;
public String joinGame(String name,User user) throws RemoteException;

}

