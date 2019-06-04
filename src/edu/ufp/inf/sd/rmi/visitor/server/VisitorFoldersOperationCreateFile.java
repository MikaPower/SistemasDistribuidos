package edu.ufp.inf.sd.rmi.visitor.server;

import edu.ufp.inf.sd.rmi.lib.server.Book;

import java.io.Serializable;
import java.rmi.server.UnicastRemoteObject;

public class VisitorFoldersOperationCreateFile implements  VisitorFoldersOperationsI, Serializable {
    private String fileToCreate;
    private  String FileToCreateWithPrefix;

public Object visitConcreteElementStateBooks( ElementFolderRI element){
    SingletonFolderOperationsBooks s = ((ConcreteElementFolderBooksImpl)element).getStateBooksFolder();
    FileToCreateWithPrefix = "VisitorsBook_"+fileToCreate;
    return s.createFile(FileToCreateWithPrefix);

}


    @Override
    public Object visitConcreteElementStateMagazines(ElementFolderRI element) {
        return null;
    }
}
