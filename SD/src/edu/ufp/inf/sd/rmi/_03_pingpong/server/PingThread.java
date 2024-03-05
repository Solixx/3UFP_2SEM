package edu.ufp.inf.sd.rmi._03_pingpong.server;

import edu.ufp.inf.sd.rmi._03_pingpong.client.PongImpl;

import java.rmi.RemoteException;
public class PingThread extends Thread{

    public Ball ball;
    public PongImpl pong;

    public PingThread(Ball ball, PongImpl pong){
        super();
        this.ball = ball;
        this.pong = pong;
    }

    @Override
    public void run() {
        try {
            this.pong.pong(this.ball);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}