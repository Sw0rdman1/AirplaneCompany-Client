/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.form.tables;

import domen.Aerodrom;
import domen.Avion;
import domen.Pilot;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author UrosVesic
 */
public class ModelTabeleAvion extends AbstractTableModel {

    List<Avion> avioni;
    String[] kolone = {"Sifra ", "Model Aviona", "Broj mesta eko", "Broj mesta biz", "Godina proizvodnje"};

    public List<Avion> getAvioni() {
        return avioni;
    }

    public ModelTabeleAvion() {
        avioni = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return avioni.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Avion sc = avioni.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sc.getSifraAviona();
            case 1:
                return sc.getModelAviona();
            case 2:
                return sc.getBrojMestaEkonomska();
            case 3:
                return sc.getBrojMestaBiznis();
            case 4:
                return sc.getGodinaProizvodnje();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void dodaj(Avion avion) {
        avioni.add(avion);
        fireTableDataChanged();
    }

    public void azurirajAvion(Avion avion) {
        for (int i = 0; i < avioni.size(); i++) {
            if (avion.equals(avioni.get(i))) {
                avioni.add(i, avion);
                avioni.remove(i + 1);
                fireTableDataChanged();
            }
        }
    }

    public void add(Avion a) {
        avioni.add(a);
        fireTableDataChanged();
    }

    public void updateAvion(Avion avion) {

        for (int i = 0; i < avioni.size(); i++) {
            if (avion.equals(avioni.get(i))) {
                avioni.add(i, avion);
                avioni.remove(i + 1);
                fireTableDataChanged();
            }
        }
    }

    public void setAvioni(List<Avion> avioni) {
        this.avioni = avioni;
        fireTableDataChanged();
    }
}
