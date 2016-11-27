# Mobiilimatkustaminen-Android

Bitit Poikittain – Samuli Kärkkäinen, Jesper Oja, Ronja Oja, Taavi Oja, Joona Somerkivi

## Uusi tapa maksaa julkisissa kulkuvälineissä

Astut junaan, matkaan määränpäähän, nouset pois ja sovellus veloittaa automaattisesti oikean lipun hinnan maksutililtäsi. Siihen me tähtäämme. Ei jonoa leimauslaitteella, ei vääriä lippuja.


### Sovelluksen toiminta

Kun käyttäjä nousee julkisen liikenteen kulkuvälineeseen (juna, bussi, ratikka etc.), sovellus tunnistaa ko. kulkuvälineen ja aloittaa matkan. Kun käyttäjä poistuu kulkuneuvosta, matka päättyy ja tilitä veloitetaan oikea lipun hinta.

Käyttäjä voi matkan aikana nähdä sovelluksesta, missä kohtaa reittiä on menossa, tarkastella mahdollisia muutoksia linjan aikataulussa ja saada halutessaan ilmoituksen, kun jokin tietty pysäkki lähestyy. Sovelluksesta voi myös tarkastella aiempia tehtyä matkoja.

### palvelu laajemmin

Järjestelmän toiminta perustuu bluetooth-beaconeihin. Ajatuksena on, että järjestelmän piirissä olevissa julkisissa kulkuvälineissä on kussakin beaconit. Kun puhelimessa oleva sovellus kuulee beaconin, se kysyy palvelimelta, mikä kulkuväline on kyseessä ja lähettää käyttäjälle notifikaation, jossa ilmoitetaan ko. kulkuväline (esim. E-juna Leppävaara-Helsinki). Käyttäjän pitää vielä sovelluksesta vahvistaa haluavansa ostaa lipun kyseiselle linjalle, jolloin palvelimelle lähetetään tästä tieto aikaleimoineen.

Kun käyttäjä poistuu kulkuvälineestä, katoaa myös kyseisen kulkuvälineen beacon näkyvistä. Tällöin sovellus ilmoittaa asiasta palvelimelle, joka taas kertoo sovellukselle, kuinka paljon matka tuli maksamaan, eli kuinka paljon käyttäjältä on veloitettu. 

Käyttäjän käyttäjätilissä on määriteltynä maksutapa (luottokortti tms) sekä mahdolliset alennusryhmät (opiskelija, eläkeläinen yms). 

Palvelussa hyödynnetään avointa dataa kulkuvälineiden sijainnista, aikatauluista, reiteistä ja aikataulumuutoksista. Näin käyttäjälle voidaan tarjota puhelimen ruudulla reaaliaikaista tietoa matkasta: mikä pysäkki on seuraava, onko kulkuväline aikataulussa.

## Missä nyt ollaan

Idea Mobiilimatkustaminen-palvelusta syntyi Ultrahack-tapahtumaa varten. Viikonlopun 25.11.-27.11.2016 aikana teimme Android-demosovelluksen, joka demostroi sovelluksen toimintaa käyttäjän näkökulmasta. Sovellus lähettää notifikaation, kun havaitsee järjestelmään kuuluvan beaconin. Käyttäjä vahvistaa aloittavansa matkan ja kun beacon katoaa näkyvistä, sovellus ilmoittaa äskeisen matkan tiedot.


