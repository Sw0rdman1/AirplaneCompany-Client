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
import client.form.tables.ModelTabelePilot;
import client.forme.OpstaEkranskaForma;
import domen.Aerodrom;
import domen.OpstiDomenskiObjekat;
import domen.Pilot;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author Božidar
 */
public class ControllerFindSpecificAirport extends PrimeController {

    public ControllerFindSpecificAirport(OpstaEkranskaForma oef) {
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
        Aerodrom aerodrom = (Aerodrom) odo;
        FindAirportForm faf = (FindAirportForm) oef;
        if (faf.getRbCity().isSelected()) {
            aerodrom.setGrad(faf.getTxtCity().getText());
        }

        if (faf.getRbCountry().isSelected()) {
            aerodrom.setDrzava(faf.getTxtCountry().getText());
        }

        if (faf.getRbAirportID().isSelected()) {
            aerodrom.setSifraAerodroma(Integer.parseInt(faf.getTxtAirportID().getText()));
        }
    }

    @Override
    public void KonvertujObjekatUGrafickeKomponente() {
        FindAirportForm faf = (FindAirportForm) oef;
        ModelTabeleAerodrom model = (ModelTabeleAerodrom) faf.getTblAirports().getModel();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : list) {
            Aerodrom aerodrom = (Aerodrom) opstiDomenskiObjekat;
            model.add(aerodrom);
        }

    }

    @Override
    public void isprazniGrafickiObjekat() {
        FindAirportForm faf = (FindAirportForm) oef;
        ModelTabeleAerodrom model = (ModelTabeleAerodrom) faf.getTblAirports().getModel();
        model.setAerodromi(new ArrayList<>());
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
