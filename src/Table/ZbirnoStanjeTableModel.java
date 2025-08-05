/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Table;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.ArrayList;
import domain.ZbirnoStanje;
/**
 *
 * @author xMx
 */
public class ZbirnoStanjeTableModel extends AbstractTableModel{
    List<ZbirnoStanje> zb = new ArrayList<>();
    String[] columns = {"Sifra Ambalaze","Naziv Ambalaze", "Ukupna Kolicina"};

    public ZbirnoStanjeTableModel(List<ZbirnoStanje> zb) {
        this.zb= zb;
    }
    
    public void setZb(List<ZbirnoStanje> zb) {
        this.zb = zb;
        fireTableDataChanged();
    }
    
    
    
    @Override
    public int getRowCount() {
        if (zb == null) return 0;
        return zb.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ZbirnoStanje zbirno_stanje = zb.get(rowIndex);
        switch (columnIndex){
            case 0: return zbirno_stanje.getId();
            case 1: return zbirno_stanje.getNaziv_ambalaze();
            case 2: return zbirno_stanje.getKolicina();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column]; 
    }
    
    
}
