package com.sdp;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MathServerClass extends UnicastRemoteObject implements MathServer {

    public MathServerClass() throws RemoteException {
    }

    public double average(Double[] values){
        double m;
        double total = 0;

        for (Double value : values) {
            total += value;
        }

        m = total / values.length;
        return m;
    }

    public double stdDev(Double[] values){
        Double result;
        double sum = 0.0;
        double standardDeviation = 0.0;
        int length = values.length;

        for(double num : values) {
            sum += num;
        }

        double mean = sum/length;

        for (double num: values){
            standardDeviation += Math.pow(num - mean, 2);
        }

        result = Math.sqrt(standardDeviation/length);
        return result;
    }

    public double maxValue(Double[] values){
        Double mValue = values[0];

        for(int i=1; i < values.length; i++){
            if(values[i] > mValue){
                mValue = values[i];
            }
        }
        return mValue;
    }

    public double minValue(Double[] values){
        Double mValue = values[0];
        for(int i=1;i<values.length;i++){
            if(values[i] < mValue){
                mValue = values[i];
            }
        }
        return mValue;
    }
}
