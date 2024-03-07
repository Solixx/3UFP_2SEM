package edu.ufp.inf.sd.rmi._05_diglib.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import edu.ufp.inf.sd.rmi._05_diglib.server.Book;
import edu.ufp.inf.sd.rmi._05_diglib.server.DiglibFactoryImp;


public class DiglibSessionImpl extends UnicastRemoteObject implements DiglibSessionRI  {

    DiglibFactoryImp factory;
    String username;

    protected DiglibSessionImpl(DiglibFactoryImp factory,String username) throws RemoteException {
        super();
        this.factory = factory;
        this.username = username;
    }

    @Override
    public Book[] Search(String title, String authur) throws RemoteException {
        DBMockup db = factory.getDb();
        return db.select(title, authur);
    }

    @Override
    public void logout() throws RemoteException {
        HashMap<User, DiglibSessionRI> hsmap = factory.getSessions();
        hsmap.remove(username);
    }
}
