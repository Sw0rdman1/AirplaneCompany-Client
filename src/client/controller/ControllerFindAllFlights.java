/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

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
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Božidar
 */
public class ControllerFindAllFlights extends PrimeController {

    public ControllerFindAllFlights(OpstaEkranskaForma oef) {
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
        FindFlightForm fff = (FindFlightForm) oef;
        ModelTabeleLet model = (ModelTabeleLet) fff.getTblFlights().getModel();
        if (fff.getTblFlights().getSelectedRow() != -1) {
            Let let = model.getLetovi().get(fff.getTblFlights().getSelectedRow());
            odo = let;
        }
    }

    @Override
    public void KonvertujObjekatUGrafickeKomponente() {
    }

    @Override
    public void isprazniGrafickiObjekat() {
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
