/*
package edu.ufp.inf.sd.rmi.visitor.client;

import edu.ufp.inf.sd.rmi.visitor.server.ElementFolderRI;
import edu.ufp.inf.sd.rmi.visitor.server.VisitorFoldersOperationCreateFile;
import edu.ufp.inf.sd.rmi.visitor.server.VisitorFoldersOperationsI;

import javax.xml.bind.Element;
import java.lang.reflect.Field;
import java.rmi.Naming;

public class VisitorElementsFoldersClient {


  try

    {

        ElementFolderRI eRi = (ElementFolderRI) Naming.lookup(ElementFoldersServer.SERVICE_NAME_ELEMENT_STATE_MAGAZINES);
        String newfile = "NewFile.txt";
        VisitorFoldersOperationCreateFile vsficf = new VisitorFoldersOperationCreateFile(newfile);
        Boolean b = (boolean) eRi.acceptVisitor(vsficf);

    } catch (Exception ex) {
        Logger.getLogger(ObjectStructureElementsFolders.class.getName()
    }
        return myRI;

}
*/
