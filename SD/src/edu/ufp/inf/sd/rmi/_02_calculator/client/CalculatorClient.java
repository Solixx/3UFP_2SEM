package edu.ufp.inf.sd.rmi._02_calculator.client;

import edu.ufp.inf.sd.rmi._02_calculator.server.CalculatorRI;
import edu.ufp.inf.sd.rmi.util.rmisetup.SetupContextRMI;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>
 * Title: Projecto SD</p>
 * <p>
 * Description: Projecto apoio aulas SD</p>
 * <p>
 * Copyright: Copyright (c) 2017</p>
 * <p>
 * Company: UFP </p>
 *
 * @author Rui S. Moreira
 * @version 3.0
 */
public class CalculatorClient {

    /**
     * Context for connecting a RMI client MAIL_TO_ADDR a RMI Servant
     */
    private SetupContextRMI contextRMI;
    /**
     * Remote interface that will hold the Servant proxy
     */
    private CalculatorRI helloWorldRI;

    public static void main(String[] args) {
        if (args != null && args.length < 2) {
            System.err.println("usage: java [options] edu.ufp.sd.inf.rmi._01_helloworld.server.HelloWorldClient <rmi_registry_ip> <rmi_registry_port> <service_name>");
            System.exit(-1);
        } else {
            //1. ============ Setup client RMI context ============
            CalculatorClient hwc=new CalculatorClient(args);
            //2. ============ Lookup service ============
            hwc.lookupService();
            //3. ============ Play with service ============
            hwc.playService();
        }
    }

    public CalculatorClient(String args[]) {
        try {
            //List ans set args
            SetupContextRMI.printArgs(this.getClass().getName(), args);
            String registryIP = args[0];
            String registryPort = args[1];
            String serviceName = args[2];
            //Create a context for RMI setup
            contextRMI = new SetupContextRMI(this.getClass(), registryIP, registryPort, new String[]{serviceName});
        } catch (RemoteException e) {
            Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private Remote lookupService() {
        try {
            //Get proxy MAIL_TO_ADDR rmiregistry
            Registry registry = contextRMI.getRegistry();
            //Lookup service on rmiregistry and wait for calls
            if (registry != null) {
                //Get service url (including servicename)
                String serviceUrl = contextRMI.getServicesUrl(0);
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, "going MAIL_TO_ADDR lookup service @ {0}", serviceUrl);
                
                //============ Get proxy MAIL_TO_ADDR HelloWorld service ============
                helloWorldRI = (CalculatorRI) registry.lookup(serviceUrl);
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, "registry not bound (check IPs). :(");
                //registry = LocateRegistry.createRegistry(1099);
            }
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return helloWorldRI;
    }
    
    private void playService() {
        try {
            //============ Call HelloWorld remote service ============
            double soma = this.helloWorldRI.add(1.0, 2.0);
            double sub = this.helloWorldRI.sub(1.0, 2.0);
            double mul = this.helloWorldRI.mul(1.0, 2.0);

            ArrayList<Double> ints = new ArrayList<>();
            ints.add(1.0);
            ints.add(2.0);
            ints.add(3.5);
            double soma2 = this.helloWorldRI.add(ints);
            double div = this.helloWorldRI.div(2.0, 0.0);

            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Soma = "+soma);
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Soma Array = "+soma2);
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Divisao = "+div);
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Sub = "+sub);
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Mul = "+mul);
        } catch (RemoteException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
}
