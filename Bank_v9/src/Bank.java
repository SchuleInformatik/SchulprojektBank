import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Bank {
    @XmlElement
    private ArrayList <Konto> al = new ArrayList<Konto>(); //al steht fuer arraylist, ist eine Liste welche alle Konten enthaelt
    
    public Bank(){
        
    }
    /**
     * f�gt der kundenArrayListe das eingegebene Konto hinzu
     * @param k
     */
    public void kontoHinzufuegen(Konto k){
        al.add(k);
        
    }
    /**
     * �berpr�ft ob ein konto mit der eingegebenen Iban existiert
     * returned null oder dass gefundene Konto
     * @param Iban
     * @return
     */
    public Konto kontoSuche(int Iban){
        for(int i=0;i<al.size();i++){	//schaut bei jedem Konto in der al ob es as passende ist, wenn ja, dann gibt es das konto zurueck
            if(al.get(i).getIban()==Iban){
                return al.get(i);
            }
        }
        
        return null;
    }
    /**
     * �berpr�ft ob eingegebene Iban und passwort mit einem derKonten aus der Liste �bereinstimmen
     * @param Iban
     * @param passwort
     * @return
     */
    public boolean anmeldenGueltig(int Iban, String passwort){
        for(int i=0;i<al.size();i++){				//ueberprueft, ob die anmeldedaten die vom controller gegeben werden gueltig sind und gibt dann true oder false zurueck
            if(al.get(i).getIban()==Iban && al.get(i).getPasswort().equals(passwort)){
                return true;
            }
        }
        return false;
    }
    /**
     * die Ibanvon ist die Iban des angemeldeten Nutzers
     * �berpr�ft zuerst, dass die konten existierem, das der Betrag gr��er o ist und dass es nicht die selben Konten sind
     * dann �berpr�ft es dass der betrag von der Gr��e her beim einen Konto abgehoben werden kann
     * wenn diese Bedingungen erf�llt sind, addiert es beim empf�nger den Betrag und subtrahiert ihn beim Sender
     * dann returned es 0, was bedeutet, dass alles funktioniert hat
     * wird etwas anderes zur�ckgegeben ist es die nummer der passenden Fehlermeldung
     * @param IbanVon
     * @param IbanZu
     * @param betrag
     * @return
     */
    public int ueberweisen(int IbanVon, int IbanZu, double betrag){
        if(kontoSuche(IbanVon)!=null && kontoSuche(IbanZu) != null && betrag > 0 && IbanVon != IbanZu ){// schaut ob konten vorhanden sind und das betrag>0 und das ibanZu != ibanVon
            if(kontoSuche(IbanVon).getKontostand() + kontoSuche(IbanVon).getDispo() >= betrag){//schaut ob genuegend Geld auf Konto ist
                kontoSuche(IbanVon).ueberweisen(-betrag);
                kontoSuche(IbanZu).ueberweisen(betrag);
                System.out.println("Es wurde erfolgreich ueberwiesen.Ihr Kontostand ist nun "+kontoSuche(IbanVon).getKontostand()+"�");
                System.out.println("Der Kontostand des Empfaengers ist nun "+kontoSuche(IbanZu).getKontostand()+"�");
                return 0;
            }else{
                System.out.println("Das Konto hat zu wenig Geld.");
                return 7;
            }
        } else if(kontoSuche(IbanZu) == null){
            System.out.println("Die eingegebene Kontonummer existiert nicht.");
            return 6;
        } else if(IbanVon == IbanZu) {
            System.out.println("Überweisung an das eigene Konto nicht möglich.");
            return 8;
        }
        else {
            System.out.println("Bitte gültigen Betrag eingeben."); //Betrag = 0
            return 5;
        }
        //todo: Fehlermeldung, wenn man seine eigene Iban eingibt
        
    }
    /**
     * die IbanVon ist die Iban des angemeldeten Nutzers
     * schaut dass betrag gr��er 0 ist
     * dann �berpr�ft es, dass der betrag von der Gr��e her passt
     * wenn ja, subtrahiert er den Betrag vom angemeldeten Konto und gibt 0 zur�ck, was bedeutet, dass alles funktioniert
     * ansonsten  wird die nummer der passenden Fehlermeldung zur�ckgegeben
     * @param Iban
     * @param betrag
     * @return
     */
    public int abheben(int Iban, double betrag){
        if(betrag>0 ){// schaut das betrag>0
            if(kontoSuche(Iban).getKontostand() + kontoSuche(Iban).getDispo() >= betrag){//schaut ob genuegend deld auf Konto ist
                kontoSuche(Iban).ueberweisen(-betrag);
                System.out.println("Es wurde erfolgreich abgehoben. Ihr Kontostand ist nun "+kontoSuche(Iban).getKontostand()+"�");
                return 0;
            }else{
                System.out.println("Das Konto hat zu wenig Geld.");
                return 7;
            }
        }
        else{
            System.out.println("Bitte gültigen Betrag eingeben.");
            return 5;
        }
    }
}
