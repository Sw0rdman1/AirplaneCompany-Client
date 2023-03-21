/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import domen.Korisnik;
import domen.OpstiDomenskiObjekat;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import client.forme.OpstaEkranskaForma;
import client.communication.Communication;
import client.form.pilot.FindPilotForm;
import communication.Odgovor;
import communication.Operacije;
import communication.Zahtev;
import domen.Aerodrom;
import domen.Avion;
import domen.Karta;
import domen.Let;
import domen.Pilot;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import validator.ValidationException;

/**
 *
 * @author draskovesic
 */
public abstract class PrimeController {

    protected OpstiDomenskiObjekat odo;
    protected OpstaEkranskaForma oef;
    protected List<OpstiDomenskiObjekat> list = new ArrayList<>();

    //***************************************************************************************************
    public boolean SOLogIn() {
        odo = oef.kreirajObjekat();

        KonvertujGrafickiObjekatUDomenskiObjekat();
        Zahtev zahtev = new Zahtev(Operacije.PRIJAVI_SE, odo);
        Odgovor odgovor;
        try {
            odgovor = Communication.getInstanca().pozivSo(zahtev);
            if (odgovor.isUspesno()) {
                odo = (Korisnik) odgovor.getRezultat();
                Communication.getInstanca().setTrenutniKorisnik((Korisnik) odo);
                oef.dispose();
                return true;
            } else {
                JOptionPane.showMessageDialog(oef, "Neuspesno prijavljivanje", "Greska", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Neuspesno prijavljivanje", "Greska", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void SOCreatePilot() {
        odo = oef.kreirajObjekat();
        KonvertujGrafickiObjekatUDomenskiObjekat();
        Zahtev zahtev = new Zahtev(Operacije.KREIRAJ_PILOTA, odo);
        Odgovor odgovor;
        try {
            odgovor = Communication.getInstanca().pozivSo(zahtev);
            System.out.println(odgovor.isUspesno());
            if (odgovor.isUspesno()) {
                odo = (Pilot) odgovor.getRezultat();
                KonvertujObjekatUGrafickeKomponente();
                JOptionPane.showMessageDialog(oef, "System created new pilot", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(oef, "System cannot create new pilot", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
        }
    }

    public void SOFindNextIDPilot() {
        odo = oef.kreirajObjekat();
        KonvertujGrafickiObjekatUDomenskiObjekat();
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_ID_PILOTA, odo);
        Odgovor odgovor;
        try {

            odgovor = Communication.getInstanca().pozivSo(zahtev);
            if (odgovor.isUspesno()) {
                odo = (Pilot) odgovor.getRezultat();
                KonvertujObjekatUGrafickeKomponente();
                omoguciPamcenje();
            } else {
                JOptionPane.showMessageDialog(oef, "System cannot load ID for new Pilot", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(oef, "\"System cannot load ID for new Pilot", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void SOLoadListPilots() {
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_SVE_PILOTE, list);
        Odgovor odgovor;
        try {
            odgovor = Communication.getInstanca().pozivSo(zahtev);
            if (odgovor.isUspesno()) {
                list = (List<OpstiDomenskiObjekat>) odgovor.getRezultat();
                if (list.isEmpty()) {
                    throw new Exception();
                }
            } else {
                JOptionPane.showMessageDialog(oef, "Sistem ne moze da ucita listu pilots", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(oef, "Sistem ne moze da ucita listu pilota", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void SOFindSpecificPilots() {
        isprazniGrafickiObjekat();

        odo = oef.kreirajObjekat();
        KonvertujGrafickiObjekatUDomenskiObjekat();
        Zahtev zahtev = new Zahtev(Operacije.PRONADJI_PILOTE, odo);
        Odgovor odgovor;
        try {
            odgovor = Communication.getInstanca().pozivSo(zahtev);
            if (odgovor.isUspesno()) {
                list = (List<OpstiDomenskiObjekat>) odgovor.getRezultat();
                if (list.isEmpty()) {
                    throw new Exception();
                }
                KonvertujObjekatUGrafickeKomponente();
                succesMessage("System has found pilots that matches your search");

            } else {
                errorMessage("System cannot find pilots that match your search");
            }
        } catch (Exception ex) {
            errorMessage("System cannot find pilots that match your search");
        }
    }

    public void SODeletePilot() {
        isprazniGrafickiObjekat();
        odo = oef.kreirajObjekat();
        KonvertujGrafickiObjekatUDomenskiObjekat();
        Zahtev zahtev = new Zahtev(Operacije.IZBRISI_PILOTA, odo);
        Odgovor odgovor;
        try {
            odgovor = Communication.getInstanca().pozivSo(zahtev);
            if (odgovor.isUspesno()) {

                KonvertujObjekatUGrafickeKomponente();
                succesMessage("System has succesfuly deleted selected pilot!");

            } else {
                errorMessage("System cannot delete selected pilot");
            }
        } catch (Exception ex) {
            errorMessage("System cannot delete selected pilot");
        }
    }

    public void SOCreateAirport() throws Exception {
        odo = oef.kreirajObjekat();
        try {
            validirajPamcenje();
            KonvertujGrafickiObjekatUDomenskiObjekat();
            Zahtev zahtev = new Zahtev(Operacije.KREIRAJ_AERODROM, odo);
            Odgovor odgovor;
            odgovor = Communication.getInstanca().pozivSo(zahtev);
            System.out.println(odgovor.isUspesno());
            if (odgovor.isUspesno()) {
                odo = (Aerodrom) odgovor.getRezultat();
                KonvertujObjekatUGrafickeKomponente();
                JOptionPane.showMessageDialog(oef, "System created new airport", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(oef, "System cannot create new airport", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(oef, "System cannot create new airport", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void SOZapamtiAirport() {
        try {
            validirajPamcenje();
        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(oef, "Error while creating new Airport:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        odo = oef.kreirajObjekat();
        KonvertujGrafickiObjekatUDomenskiObjekat();
        Zahtev zahtev = new Zahtev(Operacije.ZAPAMTI_AERODROM, odo);
        Odgovor odgovor;
        try {
            odgovor = Communication.getInstanca().pozivSo(zahtev);
            if (odgovor.isUspesno()) {
                JOptionPane.showMessageDialog(oef, "System created new airport");
                isprazniGrafickiObjekat();
                onemoguciPamcenje();

            } else {
            }
        } catch (Exception ex) {
        }
    }

    public void SOFindNextIDAirport() {
        odo = oef.kreirajObjekat();
        KonvertujGrafickiObjekatUDomenskiObjekat();
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_ID_AERODROMA, odo);
        Odgovor odgovor;
        try {

            odgovor = Communication.getInstanca().pozivSo(zahtev);
            if (odgovor.isUspesno()) {
                odo = (Aerodrom) odgovor.getRezultat();
                System.out.println((Aerodrom) odo);
                KonvertujObjekatUGrafickeKomponente();
                omoguciPamcenje();
            } else {
                JOptionPane.showMessageDialog(oef, "System cannot load ID for new Airport", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(oef, "\"System cannot load ID for new Airport", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void SOLoadListAirports() {
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_SVE_AERODROME, list);
        Odgovor odgovor;
        try {
            odgovor = Communication.getInstanca().pozivSo(zahtev);
            if (odgovor.isUspesno()) {
                list = (List<OpstiDomenskiObjekat>) odgovor.getRezultat();
                if (list.isEmpty()) {
                    throw new Exception();
                }
            } else {
                JOptionPane.showMessageDialog(oef, "Sistem ne moze da ucita listu aerodroma", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(oef, "Sistem ne moze da ucita listu aerodroma", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void SOFindSpecificAirports() {
        isprazniGrafickiObjekat();

        odo = oef.kreirajObjekat();
        KonvertujGrafickiObjekatUDomenskiObjekat();
        Zahtev zahtev = new Zahtev(Operacije.PRONADJI_AERODROME, odo);
        Odgovor odgovor;
        try {
            odgovor = Communication.getInstanca().pozivSo(zahtev);
            if (odgovor.isUspesno()) {
                list = (List<OpstiDomenskiObjekat>) odgovor.getRezultat();
                if (list.isEmpty()) {
                    throw new Exception();
                }
                KonvertujObjekatUGrafickeKomponente();
                succesMessage("System has found airports that matches your search");

            } else {
                errorMessage("System cannot find airports that match your search");
            }
        } catch (Exception ex) {
            errorMessage("System cannot find airports that match your search");
        }
    }

    public void SODeleteAirport() {
        isprazniGrafickiObjekat();
        odo = oef.kreirajObjekat();
        KonvertujGrafickiObjekatUDomenskiObjekat();
        Zahtev zahtev = new Zahtev(Operacije.IZBRISI_AERODROM, odo);
        Odgovor odgovor;
        try {
            odgovor = Communication.getInstanca().pozivSo(zahtev);
            if (odgovor.isUspesno()) {

                KonvertujObjekatUGrafickeKomponente();
                succesMessage("System has succesfuly deleted selected airport!");

            } else {
                errorMessage("System cannot delete selected airport");
            }
        } catch (Exception ex) {
            errorMessage("System cannot delete selected airport");
        }
    }

    public void SOCreateAirplane() {
        odo = oef.kreirajObjekat();
        KonvertujGrafickiObjekatUDomenskiObjekat();
        Zahtev zahtev = new Zahtev(Operacije.KREIRAJ_AVION, odo);
        Odgovor odgovor;
        try {
            odgovor = Communication.getInstanca().pozivSo(zahtev);
            System.out.println(odgovor.isUspesno());
            if (odgovor.isUspesno()) {
                odo = (Avion) odgovor.getRezultat();
                KonvertujObjekatUGrafickeKomponente();
                JOptionPane.showMessageDialog(oef, "System created new airplane", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(oef, "System cannot create new airplane", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
        }
    }

    public void SOZapamtiAirplane() {
        try {
            validirajPamcenje();
        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(oef, "Error while creating new Airplane:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        odo = oef.kreirajObjekat();
        KonvertujGrafickiObjekatUDomenskiObjekat();
        Zahtev zahtev = new Zahtev(Operacije.ZAPAMTI_AVION, odo);
        Odgovor odgovor;
        try {
            odgovor = Communication.getInstanca().pozivSo(zahtev);
            if (odgovor.isUspesno()) {
                JOptionPane.showMessageDialog(oef, "System created new airplane");
                isprazniGrafickiObjekat();
                onemoguciPamcenje();

            } else {
            }
        } catch (Exception ex) {
        }
    }

    public void SOFindNextIDAirplane() {
        odo = oef.kreirajObjekat();
        KonvertujGrafickiObjekatUDomenskiObjekat();
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_ID_AVION, odo);
        Odgovor odgovor;
        try {

            odgovor = Communication.getInstanca().pozivSo(zahtev);
            if (odgovor.isUspesno()) {
                odo = (Avion) odgovor.getRezultat();
                System.out.println((Avion) odo);
                KonvertujObjekatUGrafickeKomponente();
                omoguciPamcenje();
            } else {
                JOptionPane.showMessageDialog(oef, "System cannot load ID for new airplane", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(oef, "\"System cannot load ID for new airplane", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void SOLoadListAirplanes() {
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_SVE_AVIONE, list);
        Odgovor odgovor;
        try {
            odgovor = Communication.getInstanca().pozivSo(zahtev);
            if (odgovor.isUspesno()) {
                list = (List<OpstiDomenskiObjekat>) odgovor.getRezultat();
                if (list.isEmpty()) {
                    throw new Exception();
                }
            } else {
                JOptionPane.showMessageDialog(oef, "Sistem ne moze da ucita listu aviona", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(oef, "Sistem ne moze da ucita listu aviona", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void SOFindSpecificAirplane() {
        isprazniGrafickiObjekat();

        odo = oef.kreirajObjekat();
        KonvertujGrafickiObjekatUDomenskiObjekat();
        Zahtev zahtev = new Zahtev(Operacije.PRONADJI_AVIONE, odo);
        Odgovor odgovor;
        try {
            odgovor = Communication.getInstanca().pozivSo(zahtev);
            if (odgovor.isUspesno()) {
                list = (List<OpstiDomenskiObjekat>) odgovor.getRezultat();
                if (list.isEmpty()) {
                    throw new Exception();
                }
                KonvertujObjekatUGrafickeKomponente();
                succesMessage("System has found airplanes that matches your search");

            } else {
                errorMessage("System cannot find airplanes that match your search");
            }
        } catch (Exception ex) {
            errorMessage("System cannot find airplanes that match your search");
        }
    }

    public void SODeleteAirplane() {
        isprazniGrafickiObjekat();
        odo = oef.kreirajObjekat();
        KonvertujGrafickiObjekatUDomenskiObjekat();
        Zahtev zahtev = new Zahtev(Operacije.IZBRISI_AVION, odo);
        Odgovor odgovor;
        try {
            odgovor = Communication.getInstanca().pozivSo(zahtev);
            if (odgovor.isUspesno()) {

                KonvertujObjekatUGrafickeKomponente();
                succesMessage("System has succesfuly deleted selected airplane!");

            } else {
                errorMessage("System cannot delete selected airplane");
            }
        } catch (Exception ex) {
            errorMessage("System cannot delete selected airport");
        }
    }

    public void SOCreateFlight() {

        try {
            validirajPamcenje();
            odo = oef.kreirajObjekat();
            KonvertujGrafickiObjekatUDomenskiObjekat();
            Zahtev zahtev = new Zahtev(Operacije.KREIRAJ_LET, odo);
            Odgovor odgovor;
            odgovor = Communication.getInstanca().pozivSo(zahtev);
            System.out.println(odgovor.isUspesno());
            if (odgovor.isUspesno()) {
                odo = (Let) odgovor.getRezultat();
                KonvertujObjekatUGrafickeKomponente();
                JOptionPane.showMessageDialog(oef, "System created new flight", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(oef, "System cannot create new flight", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(oef, "System cannot create new flight", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void SOFindNextIDFlight() {
        odo = oef.kreirajObjekat();
        KonvertujGrafickiObjekatUDomenskiObjekatID();
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_ID_LET, odo);
        Odgovor odgovor;
        try {

            odgovor = Communication.getInstanca().pozivSo(zahtev);
            if (odgovor.isUspesno()) {
                odo = (Let) odgovor.getRezultat();
                KonvertujObjekatUGrafickeKomponente();
            } else {
                JOptionPane.showMessageDialog(oef, "System cannot load ID for new flight", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(oef, "\"System cannot load ID for new flight", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void SOLoadListFlights() {
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_SVE_LETOVE, list);
        Odgovor odgovor;
        try {
            odgovor = Communication.getInstanca().pozivSo(zahtev);
            if (odgovor.isUspesno()) {
                list = (List<OpstiDomenskiObjekat>) odgovor.getRezultat();
                if (list.isEmpty()) {
                    throw new Exception();
                }
            } else {
                JOptionPane.showMessageDialog(oef, "Sistem ne moze da ucita listu letova", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(oef, "Sistem ne moze da ucita listu letova", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void SOFindSpecificFlight() {
        isprazniGrafickiObjekat();

        odo = oef.kreirajObjekat();
        KonvertujGrafickiObjekatUDomenskiObjekat();
        Zahtev zahtev = new Zahtev(Operacije.PRONADJI_LETOVE, odo);
        Odgovor odgovor;
        try {
            odgovor = Communication.getInstanca().pozivSo(zahtev);
            if (odgovor.isUspesno()) {
                list = (List<OpstiDomenskiObjekat>) odgovor.getRezultat();
                if (list.isEmpty()) {
                    throw new Exception();
                }
                KonvertujObjekatUGrafickeKomponente();
                succesMessage("System has found flights that matches your search");

            } else {
                errorMessage("System cannot find flights that match your search");
            }
        } catch (Exception ex) {
            errorMessage("System cannot find flights that match your search");
        }
    }

    public void SOCreateTicket() {

        try {
            validirajPamcenje();
            odo = oef.kreirajObjekat();
            KonvertujGrafickiObjekatUDomenskiObjekat();
            Zahtev zahtev = new Zahtev(Operacije.KREIRAJ_KARTU, odo);
            Odgovor odgovor;
            odgovor = Communication.getInstanca().pozivSo(zahtev);
            if (odgovor.isUspesno()) {
                odo = (Karta) odgovor.getRezultat();
                KonvertujObjekatUGrafickeKomponente();
                JOptionPane.showMessageDialog(oef, "System created new ticket");
                omoguciPamcenje();
            } else {
                JOptionPane.showMessageDialog(oef, "System cannot create new ticket!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(oef, "System cannot create new ticket!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void SOFindNextIDTicket() {
        odo = oef.kreirajObjekat();
        KonvertujGrafickiObjekatUDomenskiObjekatID();
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_ID_KARTA, odo);
        Odgovor odgovor;
        try {

            odgovor = Communication.getInstanca().pozivSo(zahtev);
            if (odgovor.isUspesno()) {
                odo = (Karta) odgovor.getRezultat();
                System.out.println((Karta) odo);
                KonvertujObjekatUGrafickeKomponente();
            } else {
                JOptionPane.showMessageDialog(oef, "System cannot load ID for new ticket", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(oef, "\"System cannot load ID for new ticket", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void SOLoadTicket() {
        Zahtev zahtev = new Zahtev(Operacije.PRONADJI_KARTU, odo);
        Odgovor odgovor;
        try {
            odgovor = Communication.getInstanca().pozivSo(zahtev);
            if (odgovor.isUspesno()) {
                odo = (Karta) odgovor.getRezultat();
                System.out.println("Bozaaa");
                KonvertujObjekatUGrafickeKomponente();
                JOptionPane.showMessageDialog(oef, "System load information about ticket");
            } else {
                JOptionPane.showMessageDialog(oef, "System cannot load information about ticket", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(oef, "System cannot load information about ticket", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void SOUpdateTicket() {
        try {
            odo = oef.kreirajObjekat();
            KonvertujGrafickiObjekatUDomenskiObjekat();
            Zahtev zahtev = new Zahtev(Operacije.AZURIRAJ_KARTU, odo);
            Odgovor odgovor;
            odgovor = Communication.getInstanca().pozivSo(zahtev);
            if (odgovor.isUspesno()) {
                odo = (Karta) odgovor.getRezultat();
                JOptionPane.showMessageDialog(oef, "System updated selected ticket");
            } else {
                JOptionPane.showMessageDialog(oef, "System cannot update selected ticket!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(oef, "System cannot update new ticket!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * *************************************************************************************************************
     */
    public abstract void KonvertujGrafickiObjekatUDomenskiObjekat();

    public abstract void KonvertujObjekatUGrafickeKomponente();

    public abstract void isprazniGrafickiObjekat();

    public void omoguciPamcenje() {
    }

    public void onemoguciPamcenje() {
    }

    public void prikaziPorukuOGresci(String message) {
        JOptionPane.showMessageDialog(oef, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void validirajPrijavu() throws ValidationException {
    }

    public void validirajPamcenje() throws ValidationException {
        throw new UnsupportedOperationException();
    }

    public void succesMessage(String message) {
        oef.getStatusLabel().setForeground(Color.WHITE);
        oef.getStatusLabel().setBackground(new Color(75, 181, 67));
        oef.getStatusLabel().setOpaque(true);
        oef.getStatusLabel().setText(message);
        oef.getStatusLabel().setHorizontalAlignment(SwingConstants.CENTER);
        oef.getStatusLabel().setVerticalAlignment(SwingConstants.CENTER);
    }

    public void errorMessage(String message) {
        oef.getStatusLabel().setForeground(Color.WHITE);
        oef.getStatusLabel().setBackground(new Color(219, 31, 31));
        oef.getStatusLabel().setOpaque(true);
        oef.getStatusLabel().setText(message);
        oef.getStatusLabel().setHorizontalAlignment(SwingConstants.CENTER);
        oef.getStatusLabel().setVerticalAlignment(SwingConstants.CENTER);
    }

    public void KonvertujGrafickiObjekatUDomenskiObjekatID() {

    }

}
