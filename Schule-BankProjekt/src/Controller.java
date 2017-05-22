
public class Controller {
	static private Bank bank = new Bank();
	static private int nutzerIban;
	
	static public void anmelden(int Iban, int Pin){
		if(bank.anmeldenGültig(Iban, Pin)){
			nutzerIban=Iban;
			System.out.println("Sie sind angemeldet.");
		}else{
			System.out.println("Ungültige Iban oder Passwort.");
		}
	}
	static public void überweisen(int ibanZu, int betrag){
		bank.überweisen(nutzerIban, ibanZu, betrag);
	}
	static public void abheben(int betrag){
		bank.abheben(nutzerIban, betrag);
	}
	public static void main(String[] args){
	boolean b= true;
	bank.kontoHinzufügen(new Konto(new Kunde("Hans","Sale"),1000,1,1));
	bank.kontoHinzufügen(new Konto(new Kunde("Glubsch","Lo"),2000,2,2));
	bank.kontoHinzufügen(new Konto(new Kunde("Ha","Tschi"),3000,3,3));
	
	anmelden(2,3);
	anmelden(2,2);

	bank.überweisen(nutzerIban, 3, 5000);//Zu wenig Geld
	bank.überweisen(nutzerIban, 3, 5);//Passt
	bank.überweisen(nutzerIban, 100, 100);//falsche Iban
	bank.abheben(nutzerIban, 200);


	}
}
