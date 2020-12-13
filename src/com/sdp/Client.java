package com.sdp;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class Client {
    private MathServer mathServer;


    public Client() {
        try {
            //LocateRegistry.createRegistry(4949);
            mathServer = (MathServer) Naming.lookup("rmi://127.0.0.1/RMIServer");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    public double average(Double[] values) throws RemoteException {
        return mathServer.average(values);
    }

    public double stdDev(Double[] values) throws RemoteException {
        return mathServer.stdDev(values);
    }

    public double maxValue(Double[] values) throws RemoteException {
        return mathServer.maxValue(values);
    }

    public double minValue(Double[] values) throws RemoteException {
        return mathServer.minValue(values);
    }
}