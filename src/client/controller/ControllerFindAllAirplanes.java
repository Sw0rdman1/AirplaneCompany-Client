/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import client.form.airplane.FindAirplaneForm;
import client.form.airport.FindAirportForm;
import client.form.pilot.FindPilotForm;
import client.form.tables.ModelTabeleAerodrom;
import client.form.tables.ModelTabeleAvion;
import client.form.tables.ModelTabelePilot;
import client.forme.OpstaEkranskaForma;
import domen.Aerodrom;
import domen.Avion;
import domen.OpstiDomenskiObjekat;
import domen.Pilot;

/**
 *
 * @author Božidar
 */
public class ControllerFindAllAirplanes extends PrimeController {

    public ControllerFindAllAirplanes(OpstaEkranskaForma oef) {
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
        FindAirplaneForm faf = (FindAirplaneForm) oef;
        ModelTabeleAvion model = (ModelTabeleAvion) faf.getTblAvioni().getModel();
        if (faf.getTblAvioni().getSelectedRow() != -1) {
            Avion avion = model.getAvioni().get(faf.getTblAvioni().getSelectedRow());
            odo = avion;
        }
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
