/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import client.form.flight.CreateFlightForm;
import client.forme.OpstaEkranskaForma;
import domen.Aerodrom;
import domen.Avion;
import domen.Let;
import domen.OpstiDomenskiObjekat;
import domen.Pilot;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import validator.ValidationException;
import validator.Validator;

/**
 *
 * @author draskovesic
 */
public class ControllerCreateFlight extends PrimeController {

    public ControllerCreateFlight(OpstaEkranskaForma oef) {
        this.oef = oef;
    }

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        Let let = (Let) odo;
        CreateFlightForm cff = (CreateFlightForm) oef;
        if (!"".equals(cff.getTxtIDFlight().getText())) {
            let.setSifraLeta(Integer.parseInt(cff.getTxtIDFlight().getText()));
        }
        let.setTrajanje(Integer.parseInt(cff.getTxtDuration().getText()));
        let.setAerodromPolazak((Aerodrom) cff.getCmbStartDestination().getSelectedItem());
        let.setAerodromDolazak((Aerodrom) cff.getCmbFinalDestination().getSelectedItem());
        let.setAvion((Avion) cff.getCmbAirplane().getSelectedItem());
        let.setPilot((Pilot) cff.getCmbPilot().getSelectedItem());

        String date = cff.getTxtDate().getText();
        /*
        int day = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);
         */
        String time = cff.getTxtTime().getText();

        /*
        int hour = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
         */
        Date datumIVremeLeta = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

            datumIVremeLeta = dateFormat.parse(date + " " + time + ":00");
        } catch (ParseException ex) {
        }

        let.setDatumIVremePolaska(datumIVremeLeta);

    }

    public void KonvertujGrafickiObjekatUDomenskiObjekatID() {
        Let let = (Let) odo;
        CreateFlightForm cff = (CreateFlightForm) oef;
        if (!"".equals(cff.getTxtIDFlight().getText())) {
            let.setSifraLeta(Integer.parseInt(cff.getTxtIDFlight().getText()));
        }
        let.setTrajanje(0);
        let.setAerodromPolazak(null);
        let.setAerodromDolazak(null);
        let.setAvion(null);
        let.setPilot(null);
    }

    @Override
    public void KonvertujObjekatUGrafickeKomponente() {
        Let let = (Let) odo;
        CreateFlightForm cff = (CreateFlightForm) oef;
        cff.getTxtIDFlight().setText(let.getSifraLeta() + "");
        if (let.getAerodromDolazak() != null) {
            cff.getCmbFinalDestination().setSelectedItem(let.getAerodromDolazak());
        }
        if (let.getAerodromPolazak() != null) {
            cff.getCmbStartDestination().setSelectedItem(let.getAerodromPolazak());
        }
    }

    @Override
    public void isprazniGrafickiObjekat() {
        CreateFlightForm cff = (CreateFlightForm) oef;
        cff.getTxtDate().setText("");
        cff.getTxtDuration().setText("");
        cff.getTxtTime().setText("");
        cff.getTxtIDFlight().setText("");
        cff.getCmbAirplane().setSelectedIndex(0);
        cff.getCmbPilot().setSelectedIndex(0);
        cff.getCmbFinalDestination().setSelectedIndex(0);
        cff.getCmbStartDestination().setSelectedIndex(0);

    }

    public void pripremiKomboBox() {
        List<OpstiDomenskiObjekat> piloti;
        List<OpstiDomenskiObjekat> avioni;
        List<OpstiDomenskiObjekat> aerodromi;

        CreateFlightForm cff = (CreateFlightForm) oef;
        cff.getCmbPilot().removeAllItems();
        try {
            SOLoadListPilots();
            piloti = list;
            for (OpstiDomenskiObjekat pilot : piloti) {
                cff.getCmbPilot().addItem((Pilot) pilot);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(cff, "System cannot find list of pilots!");
        }

        cff.getCmbAirplane().removeAllItems();
        try {
            SOLoadListAirplanes();
            avioni = list;
            for (OpstiDomenskiObjekat avion : avioni) {
                cff.getCmbAirplane().addItem((Avion) avion);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(cff, "System cannot find list of airplanes!");
        }

        cff.getCmbStartDestination().removeAllItems();
        cff.getCmbFinalDestination().removeAllItems();

        try {
            SOLoadListAirports();
            aerodromi = list;
            for (OpstiDomenskiObjekat aerodrom : aerodromi) {
                cff.getCmbStartDestination().addItem((Aerodrom) aerodrom);
                cff.getCmbFinalDestination().addItem((Aerodrom) aerodrom);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(cff, "System cannot find list of airports!");
        }
    }

    @Override
    public void omoguciPamcenje() {
        CreateFlightForm cff = (CreateFlightForm) oef;

    }

    @Override
    public void onemoguciPamcenje() {
    }

    @Override
    public void validirajPamcenje() throws ValidationException {
        CreateFlightForm cff = (CreateFlightForm) oef;
        Validator.startValidation().validateNotNullOrEmpty(cff.getTxtDuration().getText(), "Duration field is empty!")
                .validateNotNullOrEmpty(cff.getTxtTime().getText(), "Time field is empty!")
                .validateNotNullOrEmpty(cff.getTxtDate().getText(), "Date field is empty!")
                .throwIfInvalide();
    }

}
