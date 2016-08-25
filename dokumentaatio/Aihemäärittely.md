**Aihe:** Drinkkikone, joka tutkii baarikaapissa olevien juomien sisällön ja ehdottaa niiden perusteella mahdollisia drinkkivaihtoehtoja. Käyttöliittymä koostuu näytöstä, johon syötetään baarikaapin juomat, jotka tulevat näkyviin listana ja sen jälkeen voidaan kysyä drinkkiehdotuksia.

**tunnetuimmat toiminnot:** juoman lisäys kaappiin, juoman poisto kaapista, kaapissa olevien juomien perusteella saatavat drinkkiehdotukset, satunnaisen drinkin valinta

**ylimääräisiä toimintoja:** drinkkiohjeen lisääminen, drinkkiohjeen poisto

**rakennekuvaus: **
Drinkkikoneella on kirjanpito olio, joka pitää kirjaa kaikesta tarpeellisesta.
Kirjanpidolla on lista käytettävissä olevista ainesosista. Drinkit koostuvat ainesosista. 
Kirjanpidolla on lista drinkki olioita, ja se osaa selvittää mitä drinkkejä käytössä olevista aineista voi tehdä.
	Koodin suorituksessa Kayttoliittyma luokka luo kirjanpito olion.
Sen jälkeen Kayttoliittyma kutsuu tiedoston lukijaa, joka lukee tiedostossa olevat drinkit ja lisää ne kirjanpitoon.
Tämän jälkeen ohjelma kuuntelee käyttäjän komentoja ja toimii sen mukaan.
Kun ohjelma suljetaan Kayttoliittyma kutsuu tiedostoonkirjoittajaa, joka ottaa kaikki Kirjanpidossa olevat drinkkioliot ja kirjoittaa ne tiedostoon.

![Luokkakaavio](/dokumentaatio/luokkakaavio/WP_20160816_001.jpg "Luokkakaavio")

**Sekvenssikaaviot: **

![Lisaa Ainesosa](/dokumentaatio/sekvenssikaaviot/WP_20160822_001.jpg "Luokkakaavio")

![Lisaa Drinkki](/dokumentaatio/sekvenssikaaviot/WP_20160822_003.jpg "Luokkakaavio")