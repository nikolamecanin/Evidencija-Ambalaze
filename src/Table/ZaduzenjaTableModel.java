/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Table;
import java.util.List;
import java.util.ArrayList;
import domain.Zaduzenje;
import DBBroker.DatabaseBroker;
import java.time.format.DateTimeFormatter;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author xMx
 */
public class ZaduzenjaTableModel extends AbstractTableModel{
    List<Zaduzenje> zaduzenja = new ArrayList<>();
    String[] kolone = {"Sifra zaduzenja","Ime i prezime", "Naziv Ambalaze", "KOLICINA", "Datum","Napomena"};
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy/HH:mm:ss");
    public List<Zaduzenje> getZaduzenja() {
        return zaduzenja;
    }

    public void setZaduzenja(List<Zaduzenje> zaduzenja) {
        this.zaduzenja = zaduzenja;
        fireTableDataChanged();
    }
    
    
    
    
    public ZaduzenjaTableModel(List<Zaduzenje> zaduzenja) {
        this.zaduzenja = zaduzenja;
    }

    @Override
    public int getRowCount() {
        if(zaduzenja == null) return 0;
        return zaduzenja.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Zaduzenje zaduzenje = zaduzenja.get(rowIndex);
       switch(columnIndex){
           case 0:return zaduzenje.getId();
           case 1: return zaduzenje.getKupac().getIme_prezime();
          
           
           
           case 2: return zaduzenje.getAmbalaza().getNaziv();
          
           case 3: return zaduzenje.getKolicina();
           case 4: return zaduzenje.getVreme_zaduzenja().format(formatter);
           case 5: return zaduzenje.getNapomena();
           default:
               throw new AssertionError();
       }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
    
}
