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
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author Božidar
 */
public class ControllerFindSpecificPilot extends PrimeController {

    public ControllerFindSpecificPilot(OpstaEkranskaForma oef) {
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
        Pilot pilot = (Pilot) odo;
        FindPilotForm fpf = (FindPilotForm) oef;
        if (fpf.getRbFirstName().isSelected()) {
            pilot.setIme(fpf.getTxtFirstName().getText());
        }

        if (fpf.getRbLastName().isSelected()) {
            pilot.setPrezime(fpf.getTxtLastName().getText());
        }

        if (fpf.getRbID().isSelected()) {
            pilot.setIdPilota(Integer.parseInt(fpf.getTxtID().getText()));
        }
    }

    @Override
    public void KonvertujObjekatUGrafickeKomponente() {
        FindPilotForm fpf = (FindPilotForm) oef;
        ModelTabelePilot model = (ModelTabelePilot) fpf.getTblPilots().getModel();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : list) {
            Pilot pilot = (Pilot) opstiDomenskiObjekat;
            model.add(pilot);
        }

    }

    @Override
    public void isprazniGrafickiObjekat() {
        FindPilotForm fpf = (FindPilotForm) oef;
        ModelTabelePilot model = (ModelTabelePilot) fpf.getTblPilots().getModel();
        model.setPiloti(new ArrayList<>());
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
