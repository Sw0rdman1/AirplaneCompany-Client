/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import client.form.airport.FindAirportForm;
import client.form.pilot.FindPilotForm;
import client.form.tables.ModelTabeleAerodrom;
import client.form.tables.ModelTabelePilot;
import client.forme.OpstaEkranskaForma;
import domen.Aerodrom;
import domen.OpstiDomenskiObjekat;
import domen.Pilot;

/**
 *
 * @author Božidar
 */
public class ControllerFindAllAirports extends PrimeController {

    public ControllerFindAllAirports(OpstaEkranskaForma oef) {
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
        FindAirportForm faf = (FindAirportForm) oef;
        ModelTabeleAerodrom model = (ModelTabeleAerodrom) faf.getTblAirports().getModel();
        if (faf.getTblAirports().getSelectedRow() != -1) {
            Aerodrom aerodrom = model.getAerodroms().get(faf.getTblAirports().getSelectedRow());
            odo = aerodrom;
        }
    }

    @Override
    public void KonvertujObjekatUGrafickeKomponente() {
    }

    @Override
    public void isprazniGrafickiObjekat() {
    }

    public void prepareTable() {
        FindAirportForm faf = (FindAirportForm) oef;
        faf.getTblAirports().setModel(new ModelTabeleAerodrom());
    }

    public void fillTable() {
        FindAirportForm faf = (FindAirportForm) oef;
        ModelTabeleAerodrom model = (ModelTabeleAerodrom) faf.getTblAirports().getModel();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : list) {
            Aerodrom aerodrom = (Aerodrom) opstiDomenskiObjekat;
            model.add(aerodrom);
        }
    }

    public Aerodrom returnSelectedAirport() throws Exception {
        FindAirportForm faf = (FindAirportForm) oef;
        ModelTabeleAerodrom model = (ModelTabeleAerodrom) faf.getTblAirports().getModel();
        if (faf.getTblAirports().getSelectedRow() != -1) {
            Aerodrom aerodrom = model.getAerodroms().get(faf.getTblAirports().getSelectedRow());
            return aerodrom;
        } else {
            throw new Exception();
        }

    }

    public void updateTable(Aerodrom aerodrom) {
        FindAirportForm faf = (FindAirportForm) oef;
        ModelTabeleAerodrom model = (ModelTabeleAerodrom) faf.getTblAirports().getModel();
        model.updateAirport(aerodrom);
    }

}
