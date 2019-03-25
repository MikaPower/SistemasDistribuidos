package edu.ufp.inf.sd.rmi.lib.server;

import edu.ufp.inf.sd.rmi.lib.client.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;


public class DigLibFactoryImpl extends UnicastRemoteObject implements DigLibFactoryRI {


    private DBMockup db;
    private HashMap<String, DigLibSessionRI> session;



    public DigLibFactoryImpl() throws RemoteException{
        super();
       setDb(new DBMockup());
       session = new HashMap();
    }

    public DigLibSessionRI login(String username, String pw) throws RemoteException{
        if(this.getDb().exists(username,pw)){
            DigLibSessionRI session =this.session.get(username);
            if(session==null){
                session= (DigLibSessionRI) new DigLibSessionImpl(this,new User(username,pw));
                this.session.put(username,session);
            }
            return session;
        }
        return null;
    }


    public DBMockup getDb() {
        return db;
    }

    public void setDb(DBMockup db) {
        this.db = db;
    }

    public void removeDibLibSession(String uname) {
        this.session.remove(uname);
    }
}