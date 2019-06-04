package edu.ufp.inf.sd.rmi.visitor.server;

import java.rmi.Naming;

public class server {

    public  static String Service_name_element_state_books;



    public static  void main(){
        ElementFolderRI elementBooksRI = new ConcreteElementFolderBooksImpl("String a meter");

        Naming.rebind();
    }
}
