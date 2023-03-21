/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.form.tables;

import domen.Let;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author UrosVesic
 */
public class ModelTabeleLet extends AbstractTableModel {

    List<Let> letovi;
    String[] kolone = {"ID", "Date and Time", "Duration", "From", "To"};

    public List<Let> getLetovi() {
        return letovi;
    }

    public ModelTabeleLet() {
        letovi = new ArrayList<>();
    }

    public void setLetovi(List<Let> skiKarte) {
        this.letovi = skiKarte;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return letovi.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Let let = letovi.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return let.getSifraLeta();
            case 1:
                return let.getDatumIVremePolaska();
            case 2:
                return let.getTrajanje();
            case 3:
                return let.getAerodromPolazak();
            case 4:
                return let.getAerodromDolazak();

            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];//super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
    }

    public void add(Let let) {
        letovi.add(let);
        fireTableDataChanged();
    }

    public void azurirajLet(Let let) {
        for (int i = 0; i < letovi.size(); i++) {
            if (let.equals(letovi.get(i))) {
                letovi.add(i, let);
                letovi.remove(i + 1);
                fireTableDataChanged();
            }
        }
    }

}
