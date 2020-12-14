package com.sdp;
import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ClientLoader {
    public static void main(String[] args) {
        Client client = new Client();
        List<String> sValues = new ArrayList<>();

        String filename = null;
        Scanner scanner = null;

        try {
            filename= "data.csv";
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Precisa de filename path como argumento.");
            System.exit(-1);
        }

        File file = new File(filename);

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado.");
            System.exit(-1);
        }

        scanner.nextLine(); //skips headers

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] split = line.split(";");
            sValues.add(split[1]);
        }

        scanner.close();

        Double[] values = new Double[sValues.size()];

        int i = 0;
        for(String sValue : sValues){
            values[i] = Double.parseDouble(sValue);
            i++;
        }

        try {
            System.out.println("Média:" + client.average(values));
            System.out.println("Desvio Padrão:" + client.stdDev(values));
            System.out.println("Valor Máximo:" + client.maxValue(values));
            System.out.println("Valor Mínimo:" + client.minValue(values));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
