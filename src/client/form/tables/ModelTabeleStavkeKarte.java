/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.form.tables;

import client.controller.PrimeController;
import domen.Karta;
import domen.Let;
import domen.StavkaKarte;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.table.AbstractTableModel;
import validator.ValidationException;

/**
 *
 * @author UrosVesic
 */
public class ModelTabeleStavkeKarte extends AbstractTableModel {

    private Karta karta;
    String[] kolone = {"SN", "Flight", "Class", "Price"};
    PrimeController pc;

    public ModelTabeleStavkeKarte(Karta karta, PrimeController pc) {
        this.karta = karta;
        this.pc = pc;
    }

    public Karta getKarta() {
        return karta;
    }

    public void setKarta(Karta karta) {
        this.karta = karta;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        if (karta == null || karta.getStavkeKarte() == null) {
            return 0;
        }
        return karta.getStavkeKarte().size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaKarte stavka = karta.getStavkeKarte().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return stavka.getRedniBroj();
            case 1:
                return stavka.getLet();
            case 2:
                return stavka.getKlasaTokomLeta();

            case 3:
                return stavka.getCenaStavke();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void dodaj(StavkaKarte stavka) throws Exception {

        if (karta.getStavkeKarte().size() > 0) {
            stavka.setRedniBroj(karta.getStavkeKarte().get(karta.getStavkeKarte().size() - 1).getRedniBroj() + 1);
        } else {
            stavka.setRedniBroj(1);
        }

        karta.getStavkeKarte().add(stavka);
        fireTableDataChanged();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        StavkaKarte stavkaKarte = karta.getStavkeKarte().get(rowIndex);
        switch (columnIndex) {
            case 1:
                stavkaKarte.setKarta((Karta) aValue);
                stavkaKarte.setCenaStavke(((Karta) aValue).getUkupnaCena());
                fireTableDataChanged();
                break;
        }

        System.out.println("Promeni setValueAt metodu u modelu za tabelu stavka karte");
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 2 || columnIndex == 4;
    }

    public void obrisi(int selectedRow) {
        karta.getStavkeKarte().remove(selectedRow);
        fireTableDataChanged();
    }

}
