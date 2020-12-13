package com.sdp;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MathServer extends Remote {
    public double average(Double[] values) throws RemoteException;
    public double stdDev(Double[] values) throws RemoteException;
    public double maxValue(Double[] values) throws RemoteException;
    public double minValue(Double[] values) throws RemoteException;
}
