package serwer;

import java.io.*;
import java.net.*;
import java.util.logging.*;

public class Serwer {
    public static void main(String[] args) {
        ServerSocket gniazdoSerwer = null;
        Socket polaczenie = null;
        OutputStream komunikatDlaKlienta = null;
        try {
            gniazdoSerwer = new ServerSocket(8866);
            
            System.out.println("Utworzono gniazdo serwera");
        } catch (IOException ex) {
            System.out.println("Nie utworzono gniazdo serwera");
            //Logger.getLogger(Serwer.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            polaczenie = gniazdoSerwer.accept();
            System.out.printf("oczekiwanie polaczenia z klientem");
        } catch (IOException ex) {
            System.out.printf("Nie mozna nawiazac polaczenia z klientem");
            //Logger.getLogger(Serwer.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            komunikatDlaKlienta = polaczenie.getOutputStream();
            PrintWriter zapis = null;
            if (komunikatDlaKlienta != null) {
                zapis = new PrintWriter(komunikatDlaKlienta);
                zapis.print("Czesc kliencie, to ja serwer");
                zapis.close();
                
            }
            System.out.println("Pobranie strumienia wyjscia do klienta");
        } catch (IOException ex) {
            System.out.println("Blad w pobieraniu strumienia wyjscia");
            //Logger.getLogger(Serwer.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            polaczenie.close();
            System.out.println("Zamknięcie połączenia"); 
        } catch (IOException ex) {
            System.out.println("Nie można zamknąć połączenia."); 
            //Logger.getLogger(Serwer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
