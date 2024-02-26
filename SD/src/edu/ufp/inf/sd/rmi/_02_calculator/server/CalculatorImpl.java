package edu.ufp.inf.sd.rmi._02_calculator.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CalculatorImpl extends UnicastRemoteObject implements CalculatorRI {

    protected CalculatorImpl() throws RemoteException {
        super();
    }

    @Override
    public double add(double a, double b) throws RemoteException {
        double soma = a + b;
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, ""+soma);
        return soma;
    }

    @Override
    public double add(ArrayList<Double> list) throws RemoteException {
        int l = 0, r = list.toArray().length-1;
        double out = 0;
        while(l <= r){
            if(l == r){
                out += list.get(l);
            } else{
                out += list.get(l) + list.get(r);
            }
            l++;
            r--;
        }

        Logger.getLogger(this.getClass().getName()).log(Level.INFO, ""+out);
        return out;
    }

    @Override
    public double div(double a, double b) throws RemoteException {
        double out = 0;
        try{
            if(b == 0.0)  throw new Exception("Não é possivel dividir por 0");
            out = a/b;
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, ""+out);
        } catch (Exception e){
            e.printStackTrace();
        }

        return out;
    }

    public double mul(double a, double b) throws RemoteException {
        double out = 0;
        try{
            out = a*b;
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, ""+out);
        } catch (Exception e){
            e.printStackTrace();
        }

        return out;
    }

    public double sub(double a, double b) throws RemoteException {
        double out = 0;
        try{
            out = a-b;
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, ""+out);
        } catch (Exception e){
            e.printStackTrace();
        }

        return out;
    }
}
