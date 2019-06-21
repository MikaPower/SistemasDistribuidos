package edu.ufp.inf.sd.rmi.quiz.server.implementations;

import edu.ufp.inf.sd.rmi.quiz.server.Interfaces.QuizFactoryRI;
import edu.ufp.inf.sd.rmi.quiz.server.classes.Game;
import edu.ufp.inf.sd.rmi.quiz.server.classes.GameDB;
import edu.ufp.inf.sd.rmi.quiz.server.Interfaces.QuizSessionRI;
import edu.ufp.inf.sd.rmi.quiz.server.classes.User;
import edu.ufp.inf.sd.rmi.quiz.server.classes.UserDB;

import java.rmi.RemoteException;
import java.util.List;

public class QuizSessionImpl implements QuizSessionRI {
private QuizFactoryRI factoryRI;

    @Override
    public void startNewGame(String name, int points) throws RemoteException {
        Game game = new Game(name, points);
    }

    @Override
    public List<Game> getAllGames() throws RemoteException {
        return factoryRI.getGamesList();
    }

    @Override
    public Game getGameByName(String name) throws RemoteException {
        return factoryRI.getGameByName(name);
    }

    @Override
    public String joinGame(String name,User user) throws RemoteException {
        return factoryRI.JoinGame(user,name);
    }


}
