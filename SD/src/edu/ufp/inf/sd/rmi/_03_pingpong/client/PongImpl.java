package edu.ufp.inf.sd.rmi._03_pingpong.client;

import edu.ufp.inf.sd.rmi._03_pingpong.client.PongRI;
import edu.ufp.inf.sd.rmi._03_pingpong.server.Ball;
import edu.ufp.inf.sd.rmi._03_pingpong.server.PingRI;
import edu.ufp.inf.sd.rmi._03_pingpong.server.PingThread;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PongImpl extends UnicastRemoteObject implements PongRI {

    private PingRI clientPingRI;

    public PongImpl(PingRI clientPingRI, Ball ball) throws RemoteException {
        super();
        this.clientPingRI = clientPingRI;
        clientPingRI.ping(ball, this);
    }

    public void pong(Ball ball) throws RemoteException {
        System.out.println("Pong\n");
        PongThread pt = new PongThread();
        pt.pong(ball, this);
        //this.clientPingRI.ping(ball, this);
    }
}
