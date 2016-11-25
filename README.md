# Mobiilimatkustaminen-Android



Sovellus lähettää servirlle 
- beaconin id:N ja hetken, kun on havainnut sen 
- käyttäjän hyväksymiset, matkan aloitus/lopetus
- tiedon kun ei enää näe beaconia 
- kysyy matkan hinnan

serveri kertoo sovellukselle:
- matkan hinta
- käyttäjän kaikki matkainfot 



Sovellus
- käyttöliittymä
- bluetooth kommunikaatio


## Käyttöliittymä:
- notifikaatio, kun havaitaan beacon
- matkan aloituskysymys ja -nappi (avautuu, kun käyttäjä tökkää notifikaatiota)
- matkan aikana näytetään tietoa matkasta, kulkuväline, matkan alkuaika tms. Ehkä matkan lopetusnappi.
- Matkan lopetusnapin painamisen jälkeen näytetään äskeisen matkan tiedot: mistä mihin, hinta yms.
- nappi, josta näkee aiempien matkojen tiedot.



