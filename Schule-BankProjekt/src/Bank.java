import java.util.ArrayList;

public class Bank {
	private ArrayList <Konto> al =new ArrayList<Konto>(); //al steht für arraylist, ist eine Liste welche alle Konten enthält
	
	public void kontoHinzufügen(Konto k){
		al.add(k);
	}
	public Konto kontoSuche(int Iban){
		for(int i=0;i<al.size();i++){	//schaut bei jedem Konto in der al ob es as passende ist, wenn ja, dann gibt es das konto zurück
			if(al.get(i).getIban()==Iban){
				return al.get(i);
			}
		}
		return null;
	}
	public boolean anmeldenGültig(int Iban,int pin){
		for(int i=0;i<al.size();i++){				//überprüft, ob die anmeldedaten die vom controller gegeben werden gültig sind und gibt dann true oder false zurück
			if(al.get(i).getIban()==Iban && al.get(i).getPin()==pin){
				return true;
			}
		}
		return false;
	}
	public void überweisen(int IbanVon,int IbanZu,float betrag){
		if(kontoSuche(IbanVon)!=null && kontoSuche(IbanZu) != null && betrag>0 ){// schaut ob konten vorhanden sind und das betrag>0
			if(kontoSuche(IbanVon).getKontostand()>=betrag){//schatu ob genügend deld auf Konto ist
				kontoSuche(IbanVon).überweisen(-betrag);
				kontoSuche(IbanZu).überweisen(betrag);
				System.out.println("Es wurde erfolgreich überwiesen.Ihr Kontostand ist nun "+kontoSuche(IbanVon).getKontostand()+"€");
				System.out.println("Der Kontostand des Empfängers ist nun "+kontoSuche(IbanZu).getKontostand()+"€");

			}else{
			System.out.println("Das Konto hat zu wenig Geld.");
			}
		}else{
			System.out.println("Die eingegebenen Iban stimmen nicht.");
		}
		
	}
	public void abheben(int Iban,float betrag){
		if(kontoSuche(Iban)!=null && betrag>0 ){// schaut ob konto vorhanden ist und das betrag>0
			if(kontoSuche(Iban).getKontostand()>=betrag){//schatu ob genügend deld auf Konto ist
				kontoSuche(Iban).überweisen(-betrag);
				System.out.println("Es wurde erfolgreich abgehoben. Ihr Kontostand ist nun "+kontoSuche(Iban).getKontostand()+"€");
			}else{
				System.out.println("Das Konto hat zu wenig Geld.");
			}	
		}else{
			System.out.println("Die eingegebenen Iban stimmt nicht.");
		}
	}
}
