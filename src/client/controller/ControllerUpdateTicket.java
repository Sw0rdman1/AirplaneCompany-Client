/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import client.form.tables.ModelTabeleStavkeKarte;
import client.form.tickets.UpdateTicketForm1;
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
public class ControllerUpdateTicket extends PrimeController {

    private List<StavkaKarte> dodateStavke;

    public ControllerUpdateTicket(OpstaEkranskaForma oef, Karta karta) {
        this.oef = oef;
        this.odo = karta;
        dodateStavke = new ArrayList<>();
    }

    public OpstiDomenskiObjekat getOdo() {
        return odo;
    }

    public void setOdo(OpstiDomenskiObjekat odo) {
        this.odo = odo;
    }

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        UpdateTicketForm1 utf = (UpdateTicketForm1) oef;
        Karta karta = (Karta) odo;
        if (!"".equals(utf.getTxtFindID().getText())) {
            karta.setSifraKarte(Integer.parseInt(utf.getTxtFindID().getText()));
        }

        karta.setImePutnika(utf.getTxtIme().getText());
        karta.setPrezimePutnika(utf.getTxtPrezime().getText());
        karta.setBrojPasosa(utf.getTxtBrojPasosa().getText());

        if (!"".equals(utf.getTxtTotalPrice().getText())) {
            karta.setUkupnaCena(Double.parseDouble(utf.getTxtTotalPrice().getText()));
        }
        konvertujRedoveTabeleUNizStavki();
    }

    @Override
    public void KonvertujObjekatUGrafickeKomponente() {
        UpdateTicketForm1 utf = (UpdateTicketForm1) oef;
        System.out.println("Boki");

        Karta karta = (Karta) odo;

        System.out.println(karta);

        utf.getTxtIDKarte().setText(karta.getSifraKarte() + "");
        utf.getTxtIme().setText(karta.getImePutnika());
        utf.getTxtPrezime().setText(karta.getPrezimePutnika());
        utf.getTxtBrojPasosa().setText(karta.getBrojPasosa());

        utf.getTxtTotalPrice().setText(karta.getUkupnaCena() + "");
        ((ModelTabeleStavkeKarte) utf.getTblTicket().getModel()).setKarta(karta);
    }

    @Override
    public void isprazniGrafickiObjekat() {
        UpdateTicketForm1 utf = (UpdateTicketForm1) oef;
        utf.getTxtIDKarte().setText("");
        utf.getTxtIme().setText("");
        utf.getTxtPrezime().setText("");
        utf.getTxtBrojPasosa().setText("");
        utf.getTxtTotalPrice().setText("");
        ((ModelTabeleStavkeKarte) utf.getTblTicket().getModel()).setKarta(new Karta());
    }

    private void konvertujRedoveTabeleUNizStavki() {
        UpdateTicketForm1 utf = (UpdateTicketForm1) oef;
        Karta karta = (Karta) odo;
        ModelTabeleStavkeKarte model = (ModelTabeleStavkeKarte) utf.getTblTicket().getModel();
        karta.setStavkeKarte(model.getKarta().getStavkeKarte());

    }

    public void dodajStavkuUTabelu() {
        UpdateTicketForm1 utf = (UpdateTicketForm1) oef;
        Karta karta = (Karta) odo;
        ModelTabeleStavkeKarte model = (ModelTabeleStavkeKarte) utf.getTblTicket().getModel();
        try {
            StavkaKarte stavka = new StavkaKarte();
            stavka.setKarta(karta);
            stavka.setLet((Let) utf.getCmbFlights().getSelectedItem());
            if (utf.getCmbClass().getSelectedIndex() == 0) {
                stavka.setKlasaTokomLeta(KlasaTokomLeta.Eko);
            } else {
                stavka.setKlasaTokomLeta(KlasaTokomLeta.Biz);
            }

            if (utf.getTxtPrice().getText() != "") {
                stavka.setCenaStavke(Integer.parseInt(utf.getTxtPrice().getText()));
            } else {

                stavka.setCenaStavke(0);
            }

            if (utf.getTxtTerminal().getText() != "") {
                stavka.setTerminal(Integer.parseInt(utf.getTxtTerminal().getText()));
            } else {
                stavka.setTerminal(0);
            }

            if (utf.getTxtSeatNumber().getText() != "") {
                stavka.setBrojSedista(Integer.parseInt(utf.getTxtSeatNumber().getText()));
            } else {
                stavka.setBrojSedista(0);
            }

            model.dodaj(stavka);
            utf.getTxtTotalPrice().setText(postaviCenu(model.getKarta().getStavkeKarte()));
        } catch (ParseException ex) {

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(oef, "All fields must be filled", "Error", JOptionPane.ERROR_MESSAGE);

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
        UpdateTicketForm1 utf = (UpdateTicketForm1) oef;
        ModelTabeleStavkeKarte model = (ModelTabeleStavkeKarte) utf.getTblTicket().getModel();
        utf.getTxtTotalPrice().setText(postaviCenu(model.getKarta().getStavkeKarte()));
    }

    public void pripremiTabelu() {
        UpdateTicketForm1 utf = (UpdateTicketForm1) oef;
        ModelTabeleStavkeKarte model = new ModelTabeleStavkeKarte(new Karta(), this);
        utf.getTblTicket().setModel(model);

        utf.getTblTicket().getColumnModel().getColumn(0).setMaxWidth(50);
        utf.getTblTicket().getColumnModel().getColumn(1).setMinWidth(400);
        utf.getTblTicket().getColumnModel().getColumn(2).setMaxWidth(100);

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
        UpdateTicketForm1 utf = (UpdateTicketForm1) oef;
        Karta karta = (Karta) odo;
        try {
            SOLoadListFlights();
            List<OpstiDomenskiObjekat> letovi = list;
            for (OpstiDomenskiObjekat odoSK : letovi) {
                Let let = (Let) odoSK;
                System.out.println(let);
                utf.getCmbFlights().addItem(odoSK);
            }
        } catch (Exception ex) {
        }
    }

    public void ObrisiStavku() {
        UpdateTicketForm1 utf = (UpdateTicketForm1) oef;
        ModelTabeleStavkeKarte model = (ModelTabeleStavkeKarte) utf.getTblTicket().getModel();
        if (utf.getTblTicket().getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(utf, "Izaberite red u tabeli");
        } else {
            model.obrisi(utf.getTblTicket().getSelectedRow());
            utf.getTxtTotalPrice().setText(postaviCenu(model.getKarta().getStavkeKarte()));

        }
    }

    @Override
    public void omoguciPamcenje() {
    }

    @Override
    public void onemoguciPamcenje() {
    }

    @Override
    public void validirajPamcenje() throws ValidationException {
        UpdateTicketForm1 utf = (UpdateTicketForm1) oef;
        Validator.startValidation().validateNotNullOrEmpty(utf.getTxtIme().getText(), "First Name field is empty!")
                .validateNotNullOrEmpty(utf.getTxtPrezime().getText(), "Last Name field is empty!")
                .validateNotNullOrEmpty(utf.getTxtBrojPasosa().getText(), "Passport field is empty!")
                .throwIfInvalide();
    }

}
