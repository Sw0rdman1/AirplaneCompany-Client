/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import client.forme.LogInForm;
import client.forme.OpstaEkranskaForma;
import domen.Korisnik;
import validator.ValidationException;
import validator.Validator;

/**
 *
 * @author Božidar
 */
public class ControllerLogIn extends PrimeController {

    public ControllerLogIn(OpstaEkranskaForma oef) {
        this.oef = oef;
    }

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        Korisnik korisnik = (Korisnik) odo;
        LogInForm pf = (LogInForm) oef;
        korisnik.setEmail(pf.getTxtEmail().getText());
        korisnik.setSifra(String.valueOf(pf.getTxtPassword().getPassword()));
    }

    @Override
    public void validirajPrijavu() throws ValidationException {
        LogInForm f = (LogInForm) oef;
        Validator.startValidation().validateNotNullOrEmpty(f.getTxtEmail().getText(), "Email je obavezan")
                .validateNotNullOrEmpty(String.valueOf(f.getTxtPassword().getPassword()), "Sifra je obavezna")
                .validirajFormatMejla(f.getTxtEmail().getText(), "Emali mora da sadrzi '@'").throwIfInvalide();
    }

    @Override
    public void KonvertujObjekatUGrafickeKomponente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void isprazniGrafickiObjekat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
