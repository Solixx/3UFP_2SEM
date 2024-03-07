package edu.ufp.inf.sd.rmi._05_diglib.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.ufp.inf.sd.rmi._05_diglib.server.Book;

public interface DiglibSessionRI extends Remote {

    Book[] Search(String title, String authur) throws RemoteException;

    void logout() throws RemoteException;
}
