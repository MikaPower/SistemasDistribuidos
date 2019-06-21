package edu.ufp.inf.sd.rmi.quiz.server.classes;

public class User {
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    private String name;
    private String password;

    public User(String name,String password) {
        this.name = name;
        this.password=password;
    }
}
