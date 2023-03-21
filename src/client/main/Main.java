/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.main;

import client.communication.Communication;
import client.forme.LogInForm;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Božidar
 */
public class Main {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 9000);
            Communication.getInstanca().setSocket(socket);
            LogInForm f = new LogInForm();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            //new GlavnaForma().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
