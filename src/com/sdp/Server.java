package com.sdp;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        System.out.println("[Server started]");
        try {
            LocateRegistry.createRegistry(1099); //dá connection refused se for outro port qualquer não mudem
            Naming.rebind("RMIServer", new MathServerClass());
            System.out.println(InetAddress.getLocalHost().getHostName());
            // rmi://127.0.0.1/MathServer1
        } catch (RemoteException | UnknownHostException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
