import java.util.ArrayList;

public class Bank {
	private ArrayList <Konto> al =new ArrayList<Konto>(); //al steht f�r arraylist, ist eine Liste welche alle Konten enth�lt
	private int dispo = 500;
	
	public void kontoHinzuf�gen(Konto k){
		al.add(k);
		
	}
	public Konto kontoSuche(int Iban){
		for(int i=0;i<al.size();i++){	//schaut bei jedem Konto in der al ob es as passende ist, wenn ja, dann gibt es das konto zur�ck
			if(al.get(i).getIban()==Iban){
				return al.get(i);
			}
		}
		
		return null;
	}
	public boolean anmeldenG�ltig(int Iban,int pin){
		for(int i=0;i<al.size();i++){				//�berpr�ft, ob die anmeldedaten die vom controller gegeben werden g�ltig sind und gibt dann true oder false zur�ck
			if(al.get(i).getIban()==Iban && al.get(i).getPin()==pin){
				return true;
			}
		}
		return false;
	}
	public int �berweisen(int IbanVon,int IbanZu,float betrag){
		if(kontoSuche(IbanVon)!=null && kontoSuche(IbanZu) != null && betrag>0 ){// schaut ob konten vorhanden sind und das betrag>0
			if(kontoSuche(IbanVon).getKontostand()+dispo >=betrag){//schaut ob gen�gend deld auf Konto ist
				kontoSuche(IbanVon).�berweisen(-betrag);
				kontoSuche(IbanZu).�berweisen(betrag);
				System.out.println("Es wurde erfolgreich �berwiesen.Ihr Kontostand ist nun "+kontoSuche(IbanVon).getKontostand()+"�");
				System.out.println("Der Kontostand des Empf�ngers ist nun "+kontoSuche(IbanZu).getKontostand()+"�");
				return 0;
			}else{
			System.out.println("Das Konto hat zu wenig Geld.");
			return 1;
			}
		}else{
			System.out.println("Die eingegebenen Iban stimmen nicht.Oder Betrag ist zu klein.");
			return 2;
		}
		
	}
	public int abheben(int Iban,float betrag){
		if(kontoSuche(Iban)!=null && betrag>0 ){// schaut ob konto vorhanden ist und das betrag>0
			if(kontoSuche(Iban).getKontostand() + dispo >=betrag){//schaut ob gen�gend deld auf Konto ist
				kontoSuche(Iban).�berweisen(-betrag);
				System.out.println("Es wurde erfolgreich abgehoben. Ihr Kontostand ist nun "+kontoSuche(Iban).getKontostand()+"�");
				return 0;
			}else{
				System.out.println("Das Konto hat zu wenig Geld.");
				return 1;
			}	
		}else{
			System.out.println("Die eingegebenen Iban stimmt nicht.");
			return 2;
		}
	}
}
