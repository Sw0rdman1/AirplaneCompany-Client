/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.forme;

import domen.OpstiDomenskiObjekat;
import javax.swing.JLabel;

/**
 *
 * @author draskovesic
 */
public abstract class OpstaEkranskaForma extends javax.swing.JFrame {

    public abstract OpstiDomenskiObjekat kreirajObjekat();

    public void promeniCenu() {
    }

    public abstract JLabel getStatusLabel();

}
