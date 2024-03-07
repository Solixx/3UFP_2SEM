package edu.ufp.inf.sd.rmi._05_diglib.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import edu.ufp.inf.sd.rmi._05_diglib.server.User;
import edu.ufp.inf.sd.rmi._05_diglib.server.DiglibSessionRI;


public interface DiglibFactorydRI extends Remote {

    boolean Register(String username, String pwd) throws RemoteException;
    DiglibSessionRI Login(String user, String pwd) throws RemoteException;
}
