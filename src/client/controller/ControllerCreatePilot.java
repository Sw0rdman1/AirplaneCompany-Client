/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import domen.Pilot;
import client.forme.OpstaEkranskaForma;
import client.form.pilot.CreatePilotForm;
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
public class ControllerCreatePilot extends PrimeController {

    public ControllerCreatePilot(OpstaEkranskaForma oef) {
        this.oef = oef;
    }

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        CreatePilotForm cpf = (CreatePilotForm) oef;
        Pilot pilot = (Pilot) odo;

        pilot.setIdPilota(Integer.parseInt(cpf.getTxtPilotId().getText()));

        pilot.setIme(cpf.getTxtFirstName().getText());
        pilot.setPrezime(cpf.getTxtLastName().getText());

        pilot.setBrojPasosa(cpf.getTxtPassportNumber().getText());

        pilot.setMestoBroavka(cpf.getTxtAdress().getText());

        pilot.setMestoBroavka(cpf.getTxtAdress().getText());

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (!"".equals(cpf.getTxtDateOfBirth().getText())) {
                pilot.setDatumRodjenja(sdf.parse(cpf.getTxtDateOfBirth().getText()));
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Date must be in this format: DD/MM/YYYY");
        }

    }

    @Override
    public void KonvertujObjekatUGrafickeKomponente() {

        CreatePilotForm cpf = (CreatePilotForm) oef;
        Pilot pilot = (Pilot) odo;
        cpf.getTxtPilotId().setText(pilot.getIdPilota() + "");
    }

    @Override
    public void isprazniGrafickiObjekat() {
        CreatePilotForm cpf = (CreatePilotForm) oef;
        cpf.getTxtAdress().setText("");
        cpf.getTxtDateOfBirth().setText("");
        cpf.getTxtFirstName().setText("");
        cpf.getTxtLastName().setText("");
        cpf.getTxtPassportNumber().setText("");
        cpf.getTxtPilotId().setText("");

    }

//    private void proveriFormatRadnogVremena(String radnoVreme) {
//        
//
//    }
    @Override
    public void omoguciPamcenje() {
        CreatePilotForm cpf = (CreatePilotForm) oef;
        cpf.getBtnCreatePilot().setEnabled(true);
    }

    @Override
    public void onemoguciPamcenje() {
        CreatePilotForm cpf = (CreatePilotForm) oef;
        cpf.getBtnCreatePilot().setEnabled(true);
    }

    @Override
    public void validirajPamcenje() throws ValidationException {
        CreatePilotForm cpf = (CreatePilotForm) oef;
        Validator.startValidation().validateNotNullOrEmpty(cpf.getTxtAdress().getText(), "Adress field is empty!")
                .validateNotNullOrEmpty(cpf.getTxtFirstName().getText(), "First Name field is empty!")
                .validateNotNullOrEmpty(cpf.getTxtLastName().getText(), "Last Name field is empty!")
                .validateNotNullOrEmpty(cpf.getTxtPassportNumber().getText(), "Passport number field is empty!")
                .validirajFormatRadnogVremena(cpf.getTxtDateOfBirth().getText(), "Date of birth must be in from: DD/MM/YYYY ").throwIfInvalide();
    }

}
