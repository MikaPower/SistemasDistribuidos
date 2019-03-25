package edu.ufp.inf.sd.rmi.observer.server;

public class State {
    private String info;
    private String id;


  public   State(String info, String id){
        this.id=id;
        this.info = info;

    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
