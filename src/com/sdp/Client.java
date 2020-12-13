package com.sdp;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Client {
    private MathServer mathServer;


    public Client() {
        try {
            //LocateRegistry.getRegistry(1099);
            mathServer = (MathServer) Naming.lookup("rmi://server:1099/RMIServer");
        } catch (NotBoundException e) {
            System.out.println("Não encontrou o servidor.");
            System.exit(-1);
        } catch (MalformedURLException e) {
            System.out.println("URL mal formado.");
            System.exit(-1);
        } catch (RemoteException e) {
            System.out.println("Não encontrou o servidor RMI.");
            System.exit(-1);
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