package edu.ufp.inf.sd.rmi.quiz.server.implementations;

import edu.ufp.inf.sd.rmi.quiz.server.Interfaces.QuizFactoryRI;
import edu.ufp.inf.sd.rmi.quiz.server.Interfaces.QuizSessionRI;
import edu.ufp.inf.sd.rmi.quiz.server.classes.Game;
import edu.ufp.inf.sd.rmi.quiz.server.classes.GameDB;
import edu.ufp.inf.sd.rmi.quiz.server.classes.User;
import edu.ufp.inf.sd.rmi.quiz.server.classes.UserDB;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;

public class QuizFactoryImpl implements QuizFactoryRI {
    private UserDB userDB;
    private GameDB gameDB;
    private HashMap<String, QuizSessionRI> sessions;

    @Override
    public QuizSessionRI login(String name, String password) throws RemoteException {

        if (userDB.getUserByName(name) != null && userDB.getUserByName(name).getPassword().compareTo(password) == 0) {
            QuizSessionRI session = new QuizSessionImpl();
        }
        return null;
    }

    @Override
    public String registerUser(String name, String password) throws RemoteException {
        if (userDB.getUserByName(name) == null) {
            User user = new User(name, password);
            return userDB.addUser(user);

        }
        return "Erro registerUser";
    }

        public List<Game> getGamesList() throws RemoteException {
            return gameDB.getGames();
        }

        public String JoinGame(User user, String name) throws RemoteException {
           return  gameDB.getGameByName(name).addUserToGame(user);
        }

    @Override
    public Game getGameByName(String name) throws RemoteException {
        Game game;
        if((game=this.gameDB.getGameByName(name))!=null){
            return  game;
        }
        return null;
    }
}

