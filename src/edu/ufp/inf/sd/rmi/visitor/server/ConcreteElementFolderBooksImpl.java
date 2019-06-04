package edu.ufp.inf.sd.rmi.visitor.server;

import javax.xml.bind.Element;
import java.rmi.RemoteException;

public class ConcreteElementFolderBooksImpl implements ElementFolderRI {
    private final SingletonFolderOperationsBooks stateBooksFolder;

    public ConcreteElementFolderBooksImpl(String booksFolder) throws RemoteException {
        super();
        this.stateBooksFolder = SingletonFolderOperationsBooks.createSingletonFolderOperationsBooks();
    }

    public Object acceptVisitor(VisitorFoldersOperationsI visitor) throws RemoteException {

        return visitor.visitConcreteElementStateBooks(this);
    }


    public SingletonFolderOperationsBooks getStateBooksFolder() {
        return stateBooksFolder;
    }
}
