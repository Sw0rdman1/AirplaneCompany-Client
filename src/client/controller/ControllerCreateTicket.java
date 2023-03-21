/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import client.form.tables.ModelTabeleStavkeKarte;
import client.form.tickets.CreateTicketForm;
import client.forme.OpstaEkranskaForma;
import domen.Karta;
import domen.KlasaTokomLeta;
import domen.Let;
import domen.OpstiDomenskiObjekat;
import domen.StavkaKarte;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import validator.ValidationException;
import validator.Validator;

/**
 *
 * @author draskovesic
 */
public class ControllerCreateTicket extends PrimeController {

    public ControllerCreateTicket(OpstaEkranskaForma oef) {
        this.oef = oef;
    }

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        CreateTicketForm ctf = (CreateTicketForm) oef;
        Karta karta = (Karta) odo;
        if (!"".equals(ctf.getTxtIDKarte().getText())) {
            karta.setSifraKarte(Integer.parseInt(ctf.getTxtIDKarte().getText()));
        }

        karta.setImePutnika(ctf.getTxtIme().getText());

        karta.setPrezimePutnika(ctf.getTxtPrezime().getText());

        karta.setBrojPasosa(ctf.getTxtBrojPasosa().getText());

        if (!"".equals(ctf.getTxtTotalPrice().getText())) {
            karta.setUkupnaCena(Double.parseDouble(ctf.getTxtTotalPrice().getText()));
        }
        konvertujRedoveTabeleUNizStavki();
    }

    @Override
    public void KonvertujObjekatUGrafickeKomponente() {
        CreateTicketForm ctf = (CreateTicketForm) oef;
        Karta karta = (Karta) odo;
        ctf.getTxtIDKarte().setText(karta.getSifraKarte() + "");
        ctf.getTxtIme().setText(karta.getImePutnika());
        ctf.getTxtPrezime().setText(karta.getPrezimePutnika());
        ctf.getTxtBrojPasosa().setText(karta.getBrojPasosa());
        ctf.getTxtTotalPrice().setText(karta.getUkupnaCena() + "");
        ((ModelTabeleStavkeKarte) ctf.getTblTicket().getModel()).setKarta(karta);
    }

    @Override
    public void isprazniGrafickiObjekat() {
        CreateTicketForm ctf = (CreateTicketForm) oef;
        ctf.getTxtIDKarte().setText("");
        ctf.getTxtIme().setText("");
        ctf.getTxtPrezime().setText("");
        ctf.getTxtBrojPasosa().setText("");
        ctf.getTxtTotalPrice().setText("");
        ((ModelTabeleStavkeKarte) ctf.getTblTicket().getModel()).setKarta(new Karta());
    }

    private void konvertujRedoveTabeleUNizStavki() {
        CreateTicketForm ctf = (CreateTicketForm) oef;
        Karta karta = (Karta) odo;
        ModelTabeleStavkeKarte model = (ModelTabeleStavkeKarte) ctf.getTblTicket().getModel();
        karta.setStavkeKarte(model.getKarta().getStavkeKarte());

    }

    public void dodajStavkuUTabelu() {
        CreateTicketForm ctf = (CreateTicketForm) oef;
        Karta karta = (Karta) odo;
        ModelTabeleStavkeKarte model = (ModelTabeleStavkeKarte) ctf.getTblTicket().getModel();
        try {
            StavkaKarte stavka = new StavkaKarte();
            stavka.setLet((Let) ctf.getCmbFlights().getSelectedItem());
            if (ctf.getCmbClass().getSelectedIndex() == 0) {
                stavka.setKlasaTokomLeta(KlasaTokomLeta.Eko);
            } else {
                stavka.setKlasaTokomLeta(KlasaTokomLeta.Biz);

            }

            if (ctf.getTxtPrice().getText() != "") {
                stavka.setCenaStavke(Integer.parseInt(ctf.getTxtPrice().getText()));
            } else {
                stavka.setCenaStavke(0);
            }

            if (ctf.getTxtTerminal().getText() != "") {
                stavka.setTerminal(Integer.parseInt(ctf.getTxtTerminal().getText()));
            } else {
                stavka.setTerminal(0);
            }

            if (ctf.getTxtSeatNumber().getText() != "") {
                stavka.setBrojSedista(Integer.parseInt(ctf.getTxtSeatNumber().getText()));
            } else {
                stavka.setBrojSedista(0);
            }

            model.dodaj(stavka);
            ctf.getTxtTotalPrice().setText(postaviCenu(model.getKarta().getStavkeKarte()));
        } catch (ParseException ex) {

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(oef, "All fields must be filled", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private String postaviCenu(List<StavkaKarte> stavkeKarte) {
        double cena = 0;
        for (StavkaKarte stavkaKarte : stavkeKarte) {
            cena = cena + stavkaKarte.getCenaStavke();
        }
        return cena + "";
    }

    public void promeniCenu() {
        CreateTicketForm ctf = (CreateTicketForm) oef;
        ModelTabeleStavkeKarte model = (ModelTabeleStavkeKarte) ctf.getTblTicket().getModel();
        ctf.getTxtTotalPrice().setText(postaviCenu(model.getKarta().getStavkeKarte()));
    }

    public void pripremiTabelu() {
        CreateTicketForm ctf = (CreateTicketForm) oef;
        ModelTabeleStavkeKarte model = new ModelTabeleStavkeKarte(new Karta(), this);
        ctf.getTblTicket().setModel(model);

        ctf.getTblTicket().getColumnModel().getColumn(0).setMaxWidth(50);
        ctf.getTblTicket().getColumnModel().getColumn(1).setMinWidth(400);
        ctf.getTblTicket().getColumnModel().getColumn(2).setMaxWidth(100);

        List<OpstiDomenskiObjekat> opstiDomenskiObjekti;
        try {
            SOLoadListFlights();
            opstiDomenskiObjekti = list;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(oef, "Neuspesno ucitavanje liste letova", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

    }

    public void pripremiKomboBoks() {
        CreateTicketForm ctf = (CreateTicketForm) oef;
        Karta karta = (Karta) odo;
        try {
            SOLoadListFlights();
            List<OpstiDomenskiObjekat> letovi = list;
            for (OpstiDomenskiObjekat odoSK : letovi) {
                Let let = (Let) odoSK;
                System.out.println(let);
                ctf.getCmbFlights().addItem(odoSK);
            }
        } catch (Exception ex) {
            Logger.getLogger(CreateTicketForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ObrisiStavku() {
        CreateTicketForm ctf = (CreateTicketForm) oef;
        ModelTabeleStavkeKarte model = (ModelTabeleStavkeKarte) ctf.getTblTicket().getModel();
        if (ctf.getTblTicket().getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(ctf, "Izaberite red u tabeli");
        } else {
            model.obrisi(ctf.getTblTicket().getSelectedRow());
        }

    }

    public void KonvertujGrafickiObjekatUDomenskiObjekatID() {
        Karta karta = (Karta) odo;
        CreateTicketForm ctf = (CreateTicketForm) oef;
        if (!"".equals(ctf.getTxtIDKarte().getText())) {
            karta.setSifraKarte(Integer.parseInt(ctf.getTxtIDKarte().getText()));
        }
        karta.setImePutnika(null);
        karta.setPrezimePutnika(null);
        karta.setBrojPasosa(null);
        karta.setUkupnaCena(0);
        List<StavkaKarte> list = new ArrayList<StavkaKarte>();
        karta.setStavkeKarte(list);

    }

    @Override
    public void omoguciPamcenje() {

    }

    @Override
    public void onemoguciPamcenje() {

    }

    @Override
    public void validirajPamcenje() throws ValidationException {
        CreateTicketForm ctf = (CreateTicketForm) oef;
        Validator.startValidation().validateNotNullOrEmpty(ctf.getTxtIme().getText(), "First Name field is empty!")
                .validateNotNullOrEmpty(ctf.getTxtPrezime().getText(), "Last Name field is empty!")
                .validateNotNullOrEmpty(ctf.getTxtBrojPasosa().getText(), "Passport field is empty!")
                .throwIfInvalide();
    }

}
