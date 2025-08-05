/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Table;
import domain.Kupac;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author xMx
 */
public class KupciTableModel extends AbstractTableModel{
    
    private List<Kupac> kupci = new ArrayList<>();
    String[] columns = {"sifra","Ime i prezime","jmbg","adresa","broj telefona"};

    public KupciTableModel(List<Kupac> kupci) {
        this.kupci = kupci;
    }
    
    @Override
    public int getRowCount() {
        if (kupci == null) return 0;
        return kupci.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kupac kupac = kupci.get(rowIndex);
        switch (columnIndex){
            case 0: return kupac.getId();
            case 1: return kupac.getIme_prezime();
            case 2: return kupac.getJmbg();
            case 3: return kupac.getAdresa();
            case 4: return kupac.getBroj_telefona();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    public List<Kupac> getKupci() {
        return kupci;
    }

    public void setKupci(List<Kupac> kupci) {
        this.kupci = kupci;
         fireTableDataChanged();
    }
    
    
    
}
