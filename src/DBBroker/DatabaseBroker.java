/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBBroker;
import java.sql.*;
import domain.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xMx
 */
public class DatabaseBroker {
    
    private Connection connection;
    
    public void connect(){
      
       
         try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Define the connection URL
            String url = "jdbc:mysql://localhost:3306/diskont?serverTimezone=UTC&useSSL=false";
            String user = "root";  // Ideally, use a safer method to handle credentials
            String password = "";  // Use environment variables or a config file for production credentials

            // Establish the connection
            connection = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException | SQLException ex) {
             System.out.println("Greska drajver nije pronadjen");
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, "Database connection error", ex);
        }
    }
    
    
    public void disconnect(){
     
        try {
            if(connection != null && !connection.isClosed()){
                try {
                    connection.close();
                    
                } catch (SQLException ex) {
                    
                    Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void kreirajKupca(Kupac kupac){
        String query = "INSERT INTO kupac(ime_prezime,jmbg,adresa,broj_telefona) VALUES (?,?,?,?)";
        try {
            
            connect();
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, kupac.getIme_prezime());
            statement.setString(2, kupac.getJmbg());
            statement.setString(3, kupac.getAdresa());
            statement.setString(4, kupac.getBroj_telefona());
            int result = statement.executeUpdate();
            
            
            ResultSet rsID = statement.getGeneratedKeys();
            if(rsID.next()){
                kupac.setId(rsID.getLong(1));
            }
            
            rsID.close();
            statement.close();
            disconnect();
            
        } catch (SQLException ex) {
           
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public boolean jmbgPostoji(String jmbg){
        String query = "SELECT 1 FROM KUPAC WHERE jmbg = ?";
        try {
            connect();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, jmbg);
            ResultSet rs = statement.executeQuery();
            boolean postoji = rs.next();
            rs.close();
            statement.close();
            disconnect();
           
            return postoji;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        System.out.println("Ne postoji");
        return false;
    }
    
    public List<Kupac> vratiKupce(){
        List<Kupac> kupci = new ArrayList<>();
         String query = "SELECT * from kupac";
        try {
            connect();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                Kupac kupac = new Kupac();
                kupac.setId(rs.getLong("id"));
                kupac.setIme_prezime(rs.getString("ime_prezime"));
                kupac.setJmbg(rs.getString("jmbg"));
                kupac.setAdresa(rs.getString("adresa"));
                kupac.setBroj_telefona(rs.getString("broj_telefona"));
                kupci.add(kupac);
            }
            
            rs.close();
            statement.close();
            disconnect();
            
            return kupci;
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Kupac> pretrazi(String ime_prezime, String jmbg){
        List<Kupac> kupci = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT * FROM kupac WHERE 1 = 1");
        
        if(ime_prezime != null && !ime_prezime.isEmpty()){
            query.append(" AND ime_prezime LIKE ?");
        }
        
        
        
        if(jmbg != null && !jmbg.isEmpty()){
            query.append(" AND jmbg LIKE ?");
        }
        
        int index = 1;
        try {
            connect();
            PreparedStatement statement = connection.prepareStatement(query.toString());
             if(ime_prezime != null && !ime_prezime.isEmpty()){
            statement.setString(index++,"%"+ime_prezime+"%");
             }
            
              if(jmbg != null && !jmbg.isEmpty()){
            statement.setString(index++, jmbg+"%");
              }
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
                Kupac kupac = new Kupac();
                kupac.setId(rs.getLong("id"));
                kupac.setIme_prezime(rs.getString("ime_prezime"));
                kupac.setJmbg(rs.getString("jmbg"));
                kupac.setAdresa(rs.getString("adresa"));
                kupac.setBroj_telefona(rs.getString("broj_telefona"));
                kupci.add(kupac);
            }
            
            rs.close();
            statement.close();
            disconnect();
            
            return kupci;
            
            
        } catch (SQLException ex) {
            
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public void kreirajAmbalazu(String naziv, int kapacitet){
        String query = "INSERT INTO ambalaza(naziv,kapacitet) VALUES (?,?)";
        Ambalaza ambalaza= new Ambalaza(naziv, kapacitet);
        try {
            connect();
            PreparedStatement statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, ambalaza.getNaziv());
            statement.setInt(2, ambalaza.getKapacitet());
            int result = statement.executeUpdate();
            ResultSet rsID = statement.getGeneratedKeys();
            if(rsID.next()){
                ambalaza.setId(rsID.getLong(1));
            }
            rsID.close();
            statement.close();
            
            disconnect();
        } catch (SQLException ex) {
            
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List<Ambalaza> vratiAmbalaze(){
        String query = "SELECT * FROM ambalaza";
        List<Ambalaza> ambalaze = new ArrayList<>();
        try {
            connect();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                Ambalaza a = new Ambalaza();
                a.setId(rs.getLong("id"));
                a.setNaziv(rs.getString("naziv"));
                a.setKapacitet(rs.getInt("kapacitet"));
                ambalaze.add(a);
            }
            rs.close();
            statement.close();
           
            disconnect();
            return ambalaze;
        } catch (SQLException ex) {
            
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Ambalaza> pretraziAmbalaze(String naziv){
        List<Ambalaza> ambalaze = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT * FROM ambalaza WHERE 1=1");
        if(naziv != null && !naziv.isEmpty()){
            query.append(" AND naziv LIKE ?");
        }
        int index = 1;
        try {
            connect();
            PreparedStatement statement = connection.prepareStatement(query.toString());
            if(naziv != null && !naziv.isEmpty()){
                statement.setString(index, "%"+naziv+"%");
            }
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Ambalaza a = new Ambalaza();
                a.setNaziv(rs.getString("naziv"));
                a.setKapacitet(rs.getInt("kapacitet"));
                a.setId(rs.getLong("id"));
                ambalaze.add(a);
            }
            rs.close();
            statement.close();
            disconnect();
            return ambalaze;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public List<Zaduzenje> vratiZaduzenja(String id){
        
        List<Zaduzenje> zaduzenja = new ArrayList<>();
        String query = "SELECT z.*,k.*,a.*,a.id AS ambalaza_id"
                + " FROM zaduzenje z "
                + "JOIN kupac k ON z.kupac_id = k.id JOIN ambalaza a ON z.ambalaza_id=a.id "
                + "WHERE z.kupac_id = ?"
                + " ORDER BY a.naziv ASC ";
        try {
            connect();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            
            
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
               
               String naziv = rs.getString("naziv");
               int kapacitet = rs.getInt("kapacitet");
               Long ambalaza_id = rs.getLong("a.id");
               
               Ambalaza ambalaza = new Ambalaza(ambalaza_id,naziv, kapacitet);
               Kupac kupac = new Kupac();
               kupac.setId(Long.valueOf(id));
               kupac.setIme_prezime(rs.getString("ime_prezime"));
               kupac.setAdresa(rs.getString("adresa"));
               kupac.setBroj_telefona(rs.getString("broj_telefona"));
               kupac.setJmbg(rs.getString("jmbg"));
               
               
               Zaduzenje zaduzenje = new Zaduzenje();
               zaduzenje.setAmbalaza(ambalaza);
               zaduzenje.setKupac(kupac);
               zaduzenje.setVreme_zaduzenja(rs.getTimestamp("datum_zaduzenja").toLocalDateTime());
               zaduzenje.setKolicina(rs.getInt("kolicina"));
               zaduzenje.setId(rs.getLong("id"));
               zaduzenje.setNapomena(rs.getString("napomena"));
               zaduzenja.add(zaduzenje);
            }
            rs.close();
            statement.close();
            disconnect();
            return zaduzenja;
        } catch (SQLException ex) {
            
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return null;
    }
    public void ZaduziKupca(Long kupac_id, Long ambalaza_id, LocalDateTime datum_zaduzenja, int kolicina,String napomena){
        String query = "INSERT INTO zaduzenje(kupac_id, ambalaza_id, datum_zaduzenja, kolicina, napomena) "
                + "VALUES (?,?,?,?,?)";
        Zaduzenje zaduzenje = new Zaduzenje();
        try {
            connect();
            PreparedStatement statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, kupac_id);
            statement.setLong(2, ambalaza_id);
            statement.setTimestamp(3, Timestamp.valueOf(datum_zaduzenja));
            statement.setInt(4, kolicina);
            statement.setString(5, napomena);
            int result = statement.executeUpdate();
            ResultSet rsId = statement.getGeneratedKeys();
            if (rsId.next()){
                zaduzenje.setId(rsId.getLong(1));
            }
            rsId.close();
            statement.close();
            disconnect();
            
        } catch (SQLException ex) {
           
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void ObrisiZaduzenje(Long id){
        String query = "DELETE FROM zaduzenje" +
" WHERE id = ? ";
        
        try {
            connect();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
           
            int result = statement.executeUpdate();
            statement.close();
            disconnect();
            
        } catch (SQLException ex) {
            
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public List<ZbirnoStanje> ZbirnoStanje(){
        List<ZbirnoStanje> zbirno_stanje = new ArrayList<>();
        String query = "SELECT \n" +
                        "a.id AS SifraAmbalaze, \n" +
                        "a.naziv AS Naziv, \n" +
                        "SUM(z.kolicina) AS UkupnaKolicina\n" +
                        "FROM \n" +
                        "zaduzenje z\n" +
                        "JOIN \n" +
                        "ambalaza a ON z.ambalaza_id = a.id\n" +
                        "GROUP BY \n" +
                        "a.id, a.naziv\n" +
                        "ORDER BY \n" +
                        "UkupnaKolicina DESC";
        try {
            connect();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                ZbirnoStanje zs = new ZbirnoStanje();
                zs.setId(rs.getLong("SifraAmbalaze"));
                zs.setNaziv_ambalaze(rs.getString("naziv"));
                zs.setKolicina(rs.getInt("UkupnaKolicina"));
                zbirno_stanje.add(zs);
            }
            rs.close();
            statement.close();
            disconnect();
           
            return zbirno_stanje;
        } catch (SQLException ex) {
           
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    public List<ZbirnoStanjePoAmbalazi> ZaduzenjaPoAmbalazai(Long id_ambalaze){
        List<ZbirnoStanjePoAmbalazi> zbirno_stanje = new ArrayList<>();
        String query = "SELECT k.ime_prezime AS ImePrezime, k.jmbg as jmbg, k.broj_telefona as broj_telefona, " +
                        "SUM(z.kolicina) AS Ukupno " +
                        "FROM zaduzenje z " +
                        "JOIN ambalaza a ON z.ambalaza_id = a.id " +
                        "JOIN kupac k ON z.kupac_id = k.id " +
                        "WHERE a.id = ? " +
                        "GROUP BY k.ime_prezime, k.jmbg, k.broj_telefona "+
                        "ORDER BY Ukupno DESC";
        try {
            connect();
            PreparedStatement statement = connection.prepareStatement(query);
           statement.setLong(1, id_ambalaze);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                ZbirnoStanjePoAmbalazi zb = new ZbirnoStanjePoAmbalazi();
                zb.setKolicina(rs.getInt("Ukupno"));
                zb.setIme_prezime(rs.getString("ImePrezime"));
                zb.setJmbg(rs.getString("jmbg"));
                zb.setBroj_telefona(rs.getString("broj_telefona"));
                zbirno_stanje.add(zb);
            }
             rs.close();
            statement.close();
            disconnect();
            System.out.println("Radi");
            return zbirno_stanje;
            
        } catch (SQLException ex) {
            System.out.println("Greska");
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    public void izmeniZaduzenje(Long id_zaduzenja, int kolicina,String napomena){
        String query = "UPDATE zaduzenje \n" +
                        "SET kolicina = kolicina - ?, napomena = ? \n" +
                        
                        "WHERE id = ?";
        try {
            connect();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, kolicina);
            statement.setString(2, napomena);
            statement.setLong(3, id_zaduzenja);
            int result = statement.executeUpdate();
            statement.close();
            disconnect();
            System.out.println("Radi");
            
        } catch (SQLException ex) {
            System.out.println("Ne radi");
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
