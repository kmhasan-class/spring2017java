/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class Server {

    public Server() {
        try {
            int port = 9999;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Started server socket at port " + port);
            System.out.println("Waiting on clients ...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected with " + clientSocket);
                InputStream inputStream = clientSocket.getInputStream();
                
                BufferedReader input = new BufferedReader(new InputStreamReader(inputStream));
                int lineNumber = 1;
                while (true) {
                    String inputMessage = input.readLine();
                    if (inputMessage == null || inputMessage.length() == 0)
                        break;
                    System.out.printf("Line #%d: %s\n", lineNumber++, inputMessage);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
