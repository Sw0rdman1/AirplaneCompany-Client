/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.form.tables;

import domen.Pilot;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author UrosVesic
 */
public class ModelTabelePilot extends AbstractTableModel {

    List<Pilot> pilots;
    String[] kolone = new String[]{"Pilot ID", "First Name", "Last Name", "Passport Number"};

    public ModelTabelePilot() {
        pilots = new ArrayList<>();
    }

    public List<Pilot> getPilots() {
        return pilots;
    }

    public void setPiloti(List<Pilot> piloti) {
        this.pilots = piloti;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return pilots.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pilot s = pilots.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getIdPilota();
            case 1:
                return s.getIme();
            case 2:
                return s.getPrezime();
            case 3:
                return s.getBrojPasosa();
            default:
                return "Greska";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Pilot s = pilots.get(rowIndex);
        switch (columnIndex) {
            case 1:
                s.setIme((String) aValue);
                break;
            case 2:
                s.setPrezime((String) aValue);
                break;
            case 3:
                s.setBrojPasosa((String) aValue);
                break;
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void add(Pilot s) {
        pilots.add(s);
        fireTableDataChanged();
    }

    public void remove(int i) {
        pilots.remove(i);
        fireTableDataChanged();
    }

    public void removeAll() {
        pilots = new ArrayList<>();
        fireTableDataChanged();
    }

    public void updatePilot(Pilot pilot) {
        /*
        for (int i = 0; i < pilots.size(); i++) {
            if (pilots.get(i).equals(pilot)) {
                if (pilot.getIdPilota() == pilots.get(i).getIdPilota()) {
                    pilots.add(i, pilot);
                    pilots.remove(i + 1);
                } else {
                    pilots.remove(i);
                }
                fireTableDataChanged();
            }
        }
         */

        for (int i = 0; i < pilots.size(); i++) {
            if (pilot.equals(pilots.get(i))) {
                pilots.add(i, pilot);
                pilots.remove(i + 1);
                fireTableDataChanged();
            }
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return (columnIndex > 0 && columnIndex < 3);
    }

    public void obrisi(int index) {
        pilots.remove(index);
        fireTableDataChanged();
    }

    public Pilot vratiPoslednju() throws Exception {
        if (pilots.size() > 0) {
            return pilots.get(pilots.size() - 1);
        }
        throw new Exception();
    }

}
