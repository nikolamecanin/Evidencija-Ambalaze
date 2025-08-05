/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Table;
import java.util.List;
import java.util.ArrayList;
import domain.Ambalaza;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author xMx
 */
public class AmbalazaTableModel extends AbstractTableModel{
    
    private List<Ambalaza> ambalaze = new ArrayList<>();
    String[] kolone = {"Sifra","Naziv ambalaze", "kapacitet"};

    public AmbalazaTableModel(List<Ambalaza> ambalaze) {
        this.ambalaze = ambalaze;
    }

    @Override
    public int getRowCount() {
        if (ambalaze == null) return 0;
        return ambalaze.size();
    }

    @Override
    public int getColumnCount() {
       return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ambalaza a = ambalaze.get(rowIndex);
        switch(columnIndex){
            case 0: return a.getId();
            case 1: return a.getNaziv();
            case 2: return a.getKapacitet();
            default:
                throw new AssertionError();
        }
    }

    public List<Ambalaza> getAmbalaze() {
        return ambalaze;
    }

    public void setAmbalaze(List<Ambalaza> ambalaze) {
        this.ambalaze = ambalaze;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column]; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    

    
    
    
    
    
    
}
