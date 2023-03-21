/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import client.form.airplane.CreateAirplaneForm;
import client.form.airport.CreateAirportForm;
import domen.Pilot;
import client.forme.OpstaEkranskaForma;
import client.form.pilot.CreatePilotForm;
import domen.Aerodrom;
import domen.Avion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import validator.ValidationException;
import validator.Validator;

/**
 *
 * @author draskovesic
 */
public class ControllerCreateAirplane extends PrimeController {

    public ControllerCreateAirplane(OpstaEkranskaForma oef) {
        this.oef = oef;
    }

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        CreateAirplaneForm caf = (CreateAirplaneForm) oef;
        Avion avion = (Avion) odo;

        avion.setSifraAviona(Integer.parseInt(caf.getTxtAirplaneID().getText()));
        avion.setBrojMestaBiznis(Integer.parseInt(caf.getTxtBussinesClass().getText()));
        avion.setBrojMestaEkonomska(Integer.parseInt(caf.getTxtEconomyClass().getText()));
        avion.setGodinaProizvodnje(Integer.parseInt(caf.getTxtYearProduction().getText()));
        avion.setModelAviona(caf.getTxtModelName().getText());

    }

    @Override
    public void KonvertujObjekatUGrafickeKomponente() {
        CreateAirplaneForm caf = (CreateAirplaneForm) oef;
        Avion avion = (Avion) odo;
        caf.getTxtAirplaneID().setText(avion.getSifraAviona() + "");
    }

    @Override
    public void isprazniGrafickiObjekat() {
        CreateAirplaneForm caf = (CreateAirplaneForm) oef;
        caf.getTxtModelName().setText("");
        caf.getTxtBussinesClass().setText("");
        caf.getTxtEconomyClass().setText("");
        caf.getTxtYearProduction().setText("");
        caf.getTxtAirplaneID().setText("");

    }

    @Override
    public void omoguciPamcenje() {
        CreateAirplaneForm caf = (CreateAirplaneForm) oef;
    }

    @Override
    public void onemoguciPamcenje() {
        CreateAirplaneForm caf = (CreateAirplaneForm) oef;
    }

    @Override
    public void validirajPamcenje() throws ValidationException {
        CreateAirplaneForm caf = (CreateAirplaneForm) oef;
        Validator.startValidation().validateNotNullOrEmpty(caf.getTxtBussinesClass().getText(), "City field is empty!")
                .validateNotNullOrEmpty(caf.getTxtEconomyClass().getText(), "Name field is empty!")
                .validateNotNullOrEmpty(caf.getTxtAirplaneID().getText(), "Name field is empty!")
                .validateNotNullOrEmpty(caf.getTxtModelName().getText(), "Name field is empty!")
                .validateNotNullOrEmpty(caf.getTxtYearProduction().getText(), "Name field is empty!").throwIfInvalide();
    }

}
