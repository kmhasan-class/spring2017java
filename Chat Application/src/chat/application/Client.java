/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class Client {

    public Client() {
        try {
            System.out.println("Connecting to the server");
            Socket serverSocket = new Socket("172.17.0.134", 9999);
            
            OutputStream outputStream = serverSocket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            
            String message = "";
            System.out.println("Enter some text that you want to send");
            
            while (true) {
                message = reader.readLine();
                if (message.equals("QUIT"))
                    break;
                message += "\n";
                outputStream.write(message.getBytes());
                outputStream.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String args[]) {
        Client client = new Client();
    }
}
