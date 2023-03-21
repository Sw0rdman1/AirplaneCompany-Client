/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import client.form.airport.CreateAirportForm;
import domen.Pilot;
import client.forme.OpstaEkranskaForma;
import client.form.pilot.CreatePilotForm;
import domen.Aerodrom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import validator.ValidationException;
import validator.Validator;

/**
 *
 * @author draskovesic
 */
public class ControllerCreateAirport extends PrimeController {

    public ControllerCreateAirport(OpstaEkranskaForma oef) {
        this.oef = oef;
    }

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        CreateAirportForm caf = (CreateAirportForm) oef;
        Aerodrom aerodrom = (Aerodrom) odo;

        aerodrom.setSifraAerodroma(Integer.parseInt(caf.getTxtIDAerodrom().getText()));
        aerodrom.setImeAerodroma(caf.getTxtImeAerodrom().getText());
        aerodrom.setDrzava(caf.getCmbDrzavaAerodrom().getSelectedItem().toString());
        aerodrom.setGrad(caf.getTxtGradAerodrom().getText());

    }

    @Override
    public void KonvertujObjekatUGrafickeKomponente() {
        CreateAirportForm caf = (CreateAirportForm) oef;
        Aerodrom aerodrom = (Aerodrom) odo;
        caf.getTxtIDAerodrom().setText(aerodrom.getSifraAerodroma() + "");
    }

    @Override
    public void isprazniGrafickiObjekat() {
        CreateAirportForm caf = (CreateAirportForm) oef;
        caf.getTxtIDAerodrom().setText("");
        caf.getTxtGradAerodrom().setText("");
        caf.getTxtImeAerodrom().setText("");

    }

    @Override
    public void omoguciPamcenje() {
        CreateAirportForm caf = (CreateAirportForm) oef;
    }

    @Override
    public void onemoguciPamcenje() {
        CreateAirportForm caf = (CreateAirportForm) oef;
    }

    @Override
    public void validirajPamcenje() throws ValidationException {
        CreateAirportForm caf = (CreateAirportForm) oef;
        Validator.startValidation().validateNotNullOrEmpty(caf.getTxtGradAerodrom().getText(), "City field is empty!")
                .validateNotNullOrEmpty(caf.getTxtImeAerodrom().getText(), "Name field is empty!").throwIfInvalide();
    }

}
