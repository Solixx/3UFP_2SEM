package edu.ufp.inf.sd.rmi._03_pingpong.server;

import edu.ufp.inf.sd.rmi._03_pingpong.server.PingPongRI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PingPongImpl extends UnicastRemoteObject implements PingPongRI {

    protected PingPongImpl() throws RemoteException {
        super();
    }

}
