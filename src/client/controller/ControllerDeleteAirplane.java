/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import client.form.airplane.FindAirplaneForm;
import client.form.airport.FindAirportForm;
import client.form.tables.ModelTabeleAerodrom;
import client.form.tables.ModelTabeleAvion;
import client.forme.OpstaEkranskaForma;
import domen.Aerodrom;
import domen.Avion;
import domen.OpstiDomenskiObjekat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import validator.ValidationException;
import validator.Validator;

/**
 *
 * @author Božidar
 */
public class ControllerDeleteAirplane extends PrimeController {

    public ControllerDeleteAirplane(OpstaEkranskaForma oef) {
        this.oef = oef;
    }

    public OpstiDomenskiObjekat getOdo() {
        return odo;
    }

    public void setOdo(OpstiDomenskiObjekat odo) {
        this.odo = odo;
    }

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        Avion avion = (Avion) odo;
        FindAirplaneForm faf = (FindAirplaneForm) oef;

        int redAvioni = faf.getTblAvioni().getSelectedRow();
        int idAirplaneDeleting = (int) faf.getTblAvioni().getValueAt(redAvioni, 0);
        avion.setSifraAviona(idAirplaneDeleting);

    }

    @Override
    public void KonvertujObjekatUGrafickeKomponente() {
    }

    @Override
    public void isprazniGrafickiObjekat() {
    }

    public void prepareTable() {
        FindAirplaneForm faf = (FindAirplaneForm) oef;
        faf.getTblAvioni().setModel(new ModelTabeleAvion());
    }

    public void fillTable() {
        FindAirplaneForm faf = (FindAirplaneForm) oef;
        ModelTabeleAvion model = (ModelTabeleAvion) faf.getTblAvioni().getModel();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : list) {
            Avion avion = (Avion) opstiDomenskiObjekat;
            model.add(avion);
        }
    }

    public Avion returnSelectedAirplane() throws Exception {
        FindAirplaneForm faf = (FindAirplaneForm) oef;
        ModelTabeleAvion model = (ModelTabeleAvion) faf.getTblAvioni().getModel();
        if (faf.getTblAvioni().getSelectedRow() != -1) {
            Avion avion = model.getAvioni().get(faf.getTblAvioni().getSelectedRow());
            return avion;
        } else {
            throw new Exception();
        }

    }

    public void updateTable(Avion avion) {
        FindAirplaneForm faf = (FindAirplaneForm) oef;
        ModelTabeleAvion model = (ModelTabeleAvion) faf.getTblAvioni().getModel();
        model.updateAvion(avion);
    }

}
