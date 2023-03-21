/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.form.tables;

import domen.Aerodrom;
import domen.Pilot;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author UrosVesic
 */
public class ModelTabeleAerodrom extends AbstractTableModel {

    List<Aerodrom> aerodromi;
    String[] kolone = {"Sifra ", "Naziv Aerodroma", "Grad", "Drzava"};

    public List<Aerodrom> getAerodroms() {
        return aerodromi;
    }

    public ModelTabeleAerodrom() {
        aerodromi = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return aerodromi.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aerodrom sc = aerodromi.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sc.getSifraAerodroma();
            case 1:
                return sc.getImeAerodroma();
            case 2:
                return sc.getGrad();
            case 3:
                return sc.getDrzava();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void dodaj(Aerodrom aerodrom) {
        aerodromi.add(aerodrom);
        fireTableDataChanged();
    }

    public void azurirajAerodrom(Aerodrom aerodrom) {
        for (int i = 0; i < aerodromi.size(); i++) {
            if (aerodrom.equals(aerodromi.get(i))) {
                aerodromi.add(i, aerodrom);
                aerodromi.remove(i + 1);
                fireTableDataChanged();
            }
        }
    }

    public void add(Aerodrom s) {
        aerodromi.add(s);
        fireTableDataChanged();
    }

    public void updateAirport(Aerodrom aerodrom) {

        for (int i = 0; i < aerodromi.size(); i++) {
            if (aerodrom.equals(aerodromi.get(i))) {
                aerodromi.add(i, aerodrom);
                aerodromi.remove(i + 1);
                fireTableDataChanged();
            }
        }
    }

    public void setAerodromi(List<Aerodrom> aerodromi) {
        this.aerodromi = aerodromi;
        fireTableDataChanged();
    }
}
