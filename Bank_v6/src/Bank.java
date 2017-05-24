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

	public void kontoHinzufuegen(Konto k){
		al.add(k);

	}
	public Konto kontoSuche(int Iban){
		for(int i=0;i<al.size();i++){	//schaut bei jedem Konto in der al ob es as passende ist, wenn ja, dann gibt es das konto zurueck
			if(al.get(i).getIban()==Iban){
				return al.get(i);
			}
		}

		return null;
	}
	public boolean anmeldenGueltig(int Iban,int pin){
		for(int i=0;i<al.size();i++){				//ueberprueft, ob die anmeldedaten die vom controller gegeben werden gueltig sind und gibt dann true oder false zurueck
			if(al.get(i).getIban()==Iban && al.get(i).getPin()==pin){
				return true;
			}
		}
		return false;
	}
	public int ueberweisen(int IbanVon, int IbanZu, double betrag){
		if(kontoSuche(IbanVon)!=null && kontoSuche(IbanZu) != null && betrag>0 ){// schaut ob konten vorhanden sind und das betrag>0
			if(kontoSuche(IbanVon).getKontostand() + kontoSuche(IbanVon).getDispo() >= betrag){//schaut ob genuegend Geld auf Konto ist
				kontoSuche(IbanVon).ueberweisen(-betrag);
				kontoSuche(IbanZu).ueberweisen(betrag);
				System.out.println("Es wurde erfolgreich ueberwiesen.Ihr Kontostand ist nun "+kontoSuche(IbanVon).getKontostand()+"€");
				System.out.println("Der Kontostand des Empfaengers ist nun "+kontoSuche(IbanZu).getKontostand()+"€");
				return 0;
			}else{
				System.out.println("Das Konto hat zu wenig Geld.");
				return 4;
			}
		}else{
			System.out.println("Die eingegebenen Iban stimmen nicht. Oder Betrag ist zu klein.");
			return 7;
		}
		//todo: Fehlermeldung, wenn man seine eigene Iban eingibt

	}
	public int abheben(int Iban, double betrag){
		if(kontoSuche(Iban)!=null && betrag>0 ){// schaut ob konto vorhanden ist und das betrag>0
			if(kontoSuche(Iban).getKontostand() + kontoSuche(Iban).getDispo() >= betrag){//schaut ob genuegend deld auf Konto ist
				kontoSuche(Iban).ueberweisen(-betrag);
				System.out.println("Es wurde erfolgreich abgehoben. Ihr Kontostand ist nun "+kontoSuche(Iban).getKontostand()+"€");
				return 0;
			}else{
				System.out.println("Das Konto hat zu wenig Geld.");
				return 4;
			}	
		}else{
			System.out.println("Die eingegebenen Iban stimmt nicht.");
			return 2;
		}
	}
}
