package edu.ufp.inf.sd.rmi.quiz.server.classes;



import java.util.ArrayList;
import java.util.List;

public class Game {
    public String name;
    public int maxpoints;
    public List<User> users= new ArrayList<>();
    public List<String> questions= new ArrayList<>();

    public Game(String name, int maxPoints) {
        this.name = name;
        this.maxpoints = maxPoints;
    }

    public String addUserToGame(User user) {
        if (users.add(user)) {
            return "Sucesso";
        }
        return "Erro adicionar jogador";
    }


    public String DeletUserFromGame(User user){
        if(users.remove(user)){
            return "Sucesso";
        }
        return "Erro ao Delet User";
        }





}
