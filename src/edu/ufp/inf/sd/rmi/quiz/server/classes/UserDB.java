package edu.ufp.inf.sd.rmi.quiz.server.classes;

import java.util.ArrayList;
import java.util.List;

public class UserDB {

    public List<User> users = new ArrayList<>();

    public UserDB(List<User> users) {
        this.users = users;
    }

    public String addUser(User user){
        if(users.add(user)){
            return "Sucesso";
        }
        return "Erro adicionar user";
    }

    public List<User> getUsers() {
        return users;
    }

    /**
     *
     * @param name
     * @return User
     */
    public User getUserByName(String name){
        for (User user:users) {
            if(user.getName().compareTo(name)==0){
                return user;
            }
        }
        return null;
    }


}
