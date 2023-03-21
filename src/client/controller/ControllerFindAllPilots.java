/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import client.form.pilot.FindPilotForm;
import client.form.tables.ModelTabelePilot;
import client.forme.OpstaEkranskaForma;
import domen.OpstiDomenskiObjekat;
import domen.Pilot;

/**
 *
 * @author Božidar
 */
public class ControllerFindAllPilots extends PrimeController {

    public ControllerFindAllPilots(OpstaEkranskaForma oef) {
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
        FindPilotForm fpf = (FindPilotForm) oef;
        ModelTabelePilot model = (ModelTabelePilot) fpf.getTblPilots().getModel();
        if (fpf.getTblPilots().getSelectedRow() != -1) {
            Pilot pilot = model.getPilots().get(fpf.getTblPilots().getSelectedRow());
            odo = pilot;
        }
    }

    @Override
    public void KonvertujObjekatUGrafickeKomponente() {
    }

    @Override
    public void isprazniGrafickiObjekat() {
    }

    public void prepareTable() {
        FindPilotForm fpf = (FindPilotForm) oef;
        fpf.getTblPilots().setModel(new ModelTabelePilot());
    }

    public void fillTable() {
        FindPilotForm fpf = (FindPilotForm) oef;
        ModelTabelePilot model = (ModelTabelePilot) fpf.getTblPilots().getModel();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : list) {
            Pilot pilot = (Pilot) opstiDomenskiObjekat;
            model.add(pilot);
        }
    }

    public Pilot returnSelectedPilot() throws Exception {
        FindPilotForm fpf = (FindPilotForm) oef;
        ModelTabelePilot model = (ModelTabelePilot) fpf.getTblPilots().getModel();
        if (fpf.getTblPilots().getSelectedRow() != -1) {
            Pilot pilot = model.getPilots().get(fpf.getTblPilots().getSelectedRow());
            return pilot;
        } else {
            throw new Exception();
        }

    }

    public void updateTable(Pilot pilot) {
        FindPilotForm fpf = (FindPilotForm) oef;
        ModelTabelePilot model = (ModelTabelePilot) fpf.getTblPilots().getModel();
        model.updatePilot(pilot);
    }

}
