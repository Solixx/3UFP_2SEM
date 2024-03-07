package edu.ufp.inf.sd.rmi._05_diglib.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import edu.ufp.inf.sd.rmi._05_diglib.server.User;

public class DiglibFactoryImp extends UnicastRemoteObject implements DiglibFactorydRI  {
    DBMockup db;
    HashMap<User, DiglibSessionRI> sessions;

    protected DiglibFactoryImp(DBMockup db, HashMap<User, DiglibSessionRI> sessions) throws RemoteException {
        super();
        this.db = db;
        this.sessions = sessions;
    }

    @Override
    public boolean Register(String username, String pwd) throws RemoteException {
        if (!db.exists(username, pwd)) {
            db.register(username, pwd);
            return true;
        }

        return false;
    }

    @Override
    public DiglibSessionRI Login(String user, String pwd) throws RemoteException {
        DiglibSessionRI dsRI;
        if(db.exists(user, pwd)){
            for(User u: this.sessions.keySet()){
                if(u.getUname().equals(user) && u.getPword().equals(pwd)){
                    this.sessions.get(u).logout();
                    dsRI = new DiglibSessionImpl(this,user);
                    this.sessions.put(u, dsRI);
                    return dsRI;
                }
            }
        }
        return null;
    }

    public DBMockup getDb() {
        return db;
    }

    public HashMap<User, DiglibSessionRI> getSessions() {
        return sessions;
    }
}
