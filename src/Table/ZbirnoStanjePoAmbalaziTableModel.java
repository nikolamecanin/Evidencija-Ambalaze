/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Table;

import domain.ZbirnoStanjePoAmbalazi;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author xMx
 */
public class ZbirnoStanjePoAmbalaziTableModel extends AbstractTableModel{
    List<ZbirnoStanjePoAmbalazi> zspm = new ArrayList<>();
    String columns[] = {"Ime i Prezime","JMBG","Broj telefona","Duguje"};

    public ZbirnoStanjePoAmbalaziTableModel(List<ZbirnoStanjePoAmbalazi> zspm) {
        this.zspm =zspm;
    }
    
    
    @Override
    public int getRowCount() {
     if(zspm == null) return 0;
     return zspm.size();
    }

    public void setZspm(List<ZbirnoStanjePoAmbalazi> zspm) {
        this.zspm = zspm;
        fireTableDataChanged();
    }
    
    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ZbirnoStanjePoAmbalazi z = zspm.get(rowIndex);
        switch(columnIndex){
            case 0: return z.getIme_prezime();
            case 1: return z.getJmbg();
            case 2: return z.getBroj_telefona();
            case 3: return z.getKolicina();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
}
