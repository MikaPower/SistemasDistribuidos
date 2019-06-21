package edu.ufp.inf.sd.rmi.quiz.server.classes;

import java.util.List;

public class GameDB {
  

    public List<Game> games;

    public GameDB(List<Game> games) {
        this.games = games;
    }


    public List<Game> getGames() {
        return games;
    }
    
    public String addGames(Game game){
        if(games.add(game)){
            return "Sucesso";
        }
        return "Erro addding game";
        
    }
    
    public Game getGameByName(String name){
        for (Game game: games) {
            if(game.name.compareTo(name)==0){
                return game;
            }
        }
        return null;
    }
    
}
