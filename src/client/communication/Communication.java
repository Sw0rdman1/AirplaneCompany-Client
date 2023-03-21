/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.communication;

import communication.Odgovor;
import communication.Posiljalac;
import communication.Primalac;
import communication.Zahtev;
import domen.Korisnik;
import java.net.Socket;

/**
 *
 * @author Božidar
 */
public class Communication {

    static Communication instanca;
    Socket socket;
    Korisnik trenutniKorisnik;

    private Communication() {

    }

    public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        this.trenutniKorisnik = trenutniKorisnik;
    }

    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public static Communication getInstanca() {
        if (instanca == null) {
            instanca = new Communication();
        }
        return instanca;
    }

    public Odgovor pozivSo(Zahtev zahtev) throws Exception {
        new Posiljalac(socket).posalji(zahtev);
        return (Odgovor) new Primalac(socket).primi();
    }
}
