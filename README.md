# Evidencija ambalaže

**Evidencija ambalaže** je jednostavna desktop aplikacija razvijena u programskom jeziku **Java**, korišćenjem **Swing** biblioteke za grafički interfejs i **MySQL** baze podataka za skladištenje podataka.  
Aplikacija omogućava evidenciju zaduženja i razduženja ambalaže u manjim maloprodajnim objektima (npr. diskontima pića).

Funkcionalnosti

- Evidencija korisnika i tipova ambalaže  
- Unos, izmena i brisanje zapisa (CRUD operacije)  
- Pregled ukupnog broja zaduženja po tipu ambalaže  
- Jednostavan i pregledan korisnički interfejs  
- Povezanost sa MySQL bazom podataka

Tehnologije

- **Java (Swing)**
- **MySQL**
- **JDBC**
- **Object-Oriented Programming (OOP)**

# Pokretanje aplikacije

1. Klonirati repozitorijum:  
   ```bash
   git clone https://github.com/nikolamecanin/Evidencija-Ambalaze.git
   
2. U MySQL-u kreirati bazu pod nazivom diskont.

3. Kreirati potrebne tabele i kolone prema strukturi iz koda (klase i SQL upiti u aplikaciji),
   ili koristiti fajl database.sql koji sadrži strukturu baze bez podataka.

4. U kodu podesiti parametre konekcije (korisničko ime, lozinka, naziv baze).

5. Pokrenuti projekat kroz IntelliJ IDEA, Eclipse ili Apache NetBeans.

Nikola Mečanin
