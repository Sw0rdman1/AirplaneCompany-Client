/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import client.form.airplane.FindAirplaneForm;
import client.form.airport.FindAirportForm;
import client.form.flight.FindFlightForm;
import client.form.pilot.FindPilotForm;
import client.form.tables.ModelTabeleAerodrom;
import client.form.tables.ModelTabeleLet;
import client.form.tables.ModelTabelePilot;
import client.forme.OpstaEkranskaForma;
import domen.Aerodrom;
import domen.Let;
import domen.OpstiDomenskiObjekat;
import domen.Pilot;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author Božidar
 */
public class ControllerFindSpecificFlight extends PrimeController {

    public ControllerFindSpecificFlight(OpstaEkranskaForma oef) {
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
        Let let = (Let) odo;
        FindFlightForm fff = (FindFlightForm) oef;
        if (fff.getRbAirportTakeOff().isSelected()) {
            Aerodrom a = new Aerodrom();
            a.setGrad(fff.getTxtTakeOff().getText());
            let.setAerodromPolazak(a);
        }

        if (fff.getRbAirportLanding().isSelected()) {
            Aerodrom a = new Aerodrom();
            a.setGrad(fff.getTxtLanding().getText());
            let.setAerodromDolazak(a);
        }

        if (fff.getRbFlightID().isSelected()) {
            let.setSifraLeta(Integer.parseInt(fff.getTxtFlightID().getText()));
        }

    }

    @Override
    public void KonvertujObjekatUGrafickeKomponente() {
        FindFlightForm fff = (FindFlightForm) oef;
        ModelTabeleLet model = (ModelTabeleLet) fff.getTblFlights().getModel();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : list) {
            Let let = (Let) opstiDomenskiObjekat;
            model.add(let);
        }

    }

    @Override
    public void isprazniGrafickiObjekat() {
        FindFlightForm fff = (FindFlightForm) oef;
        ModelTabeleLet model = (ModelTabeleLet) fff.getTblFlights().getModel();
        model.setLetovi(new ArrayList<>());
    }

    public void prepareTable() {
        FindFlightForm fff = (FindFlightForm) oef;
        fff.getTblFlights().setModel(new ModelTabeleLet());
        fff.getTblFlights().getColumnModel().getColumn(0).setMaxWidth(40);
        fff.getTblFlights().getColumnModel().getColumn(1).setMinWidth(240);
        fff.getTblFlights().getColumnModel().getColumn(1).setMaxWidth(240);
        fff.getTblFlights().getColumnModel().getColumn(2).setMaxWidth(70);
    }

    public void fillTable() {
        FindFlightForm fff = (FindFlightForm) oef;
        ModelTabeleLet model = (ModelTabeleLet) fff.getTblFlights().getModel();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : list) {
            Let let = (Let) opstiDomenskiObjekat;
            model.add(let);
        }
    }

    public Let returnSelectedFlight() throws Exception {
        FindFlightForm fff = (FindFlightForm) oef;
        ModelTabeleLet model = (ModelTabeleLet) fff.getTblFlights().getModel();
        if (fff.getTblFlights().getSelectedRow() != -1) {
            Let let = model.getLetovi().get(fff.getTblFlights().getSelectedRow());
            return let;
        } else {
            throw new Exception();
        }

    }

    public void updateTable(Let let) {
        FindFlightForm fff = (FindFlightForm) oef;
        ModelTabeleLet model = (ModelTabeleLet) fff.getTblFlights().getModel();
        model.azurirajLet(let);
    }

}
