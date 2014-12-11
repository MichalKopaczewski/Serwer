package serwer;

import java.io.*;
import java.net.*;
import java.util.logging.*;

public class Serwer {
    public static void main(String[] args) {
        ServerSocket gniazdoSerwer = null;
        Socket polaczenie = null;
        try {
            gniazdoSerwer = new ServerSocket(8866);
            
            System.out.println("Utworzono gniazdo serwera");
        } catch (IOException ex) {
            System.out.println("Nie utworzono gniazdo serwera");
            //Logger.getLogger(Serwer.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            polaczenie = gniazdoSerwer.accept();
        } catch (IOException ex) {
            System.out.printf("Nie mozna nawiazac polaczenia z klientem");
            Logger.getLogger(Serwer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
