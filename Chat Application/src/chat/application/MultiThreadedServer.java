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
import java.net.Socket;

/**
 *
 * @author kmhasan
 */
public class MultiThreadedServer extends Thread {

    private Socket clientSocket;

    public MultiThreadedServer(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader input = new BufferedReader(new InputStreamReader(inputStream));
            int lineNumber = 1;
            while (true) {
                String inputMessage = input.readLine();
                if (inputMessage == null || inputMessage.length() == 0) {
                    break;
                }
                System.out.printf("Line #%d: %s\n", lineNumber++, inputMessage);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
