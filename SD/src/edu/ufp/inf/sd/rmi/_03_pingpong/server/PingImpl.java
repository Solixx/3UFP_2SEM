package edu.ufp.inf.sd.rmi._03_pingpong.server;

import edu.ufp.inf.sd.rmi._03_pingpong.client.PongRI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PingImpl extends UnicastRemoteObject implements PingRI{

    public PingImpl() throws RemoteException {
        super();
    }

    public void ping(Ball ball, PongRI clientPongRI) throws RemoteException {
        System.out.println("Ping\n");
        PingThread pt = new PingThread();

        //clientPongRI.pong(ball);
    }
}
