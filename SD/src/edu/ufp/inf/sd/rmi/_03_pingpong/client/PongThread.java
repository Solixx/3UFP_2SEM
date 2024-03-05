package edu.ufp.inf.sd.rmi._03_pingpong.client;

import edu.ufp.inf.sd.rmi._03_pingpong.server.Ball;
import edu.ufp.inf.sd.rmi._03_pingpong.server.PingImpl;

import java.rmi.RemoteException;

class PongThread extends Thread{

    public Ball ball;
    public PongRI pong;
    public PingImpl ping;

    public PongThread(Ball ball, PingImpl ping, PongRI pong){
        super();
        this.ball = ball;
        this.ping = ping;
        this.pong = pong;
    }

    @Override
    public void run() {
        try {
            this.ping.ping(this.ball, this.pong);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
