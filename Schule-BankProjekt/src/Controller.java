
 public class Controller {
	static private Bank bank = new Bank();
	static private int nutzerIban;
	
	static public int anmelden(int Iban, int Pin){
		if(bank.anmeldenG�ltig(Iban, Pin)){
			nutzerIban=Iban;
			System.out.println("Sie sind angemeldet als "+bank.kontoSuche(nutzerIban).getKunde().getVorname()+" "+bank.kontoSuche(nutzerIban).getKunde().getNachname()+".");
			return 0;
		}else{
			System.out.println("Ung�ltige Iban oder Passwort.");
			return 1;
		}
	}
	static public int �berweisen(int ibanZu, int betrag){
		return bank.�berweisen(nutzerIban, ibanZu, betrag);
	}
	static public int abheben(int betrag){
		return bank.abheben(nutzerIban, betrag);
	}
	static public float getKontostand(){
		return bank.kontoSuche(nutzerIban).getKontostand();
	}
	public static void main(String[] args){
	bank.kontoHinzuf�gen(new Konto(new Kunde("Hans","Sale"),1000,1,1));
	bank.kontoHinzuf�gen(new Konto(new Kunde("Glubsch","Lo"),2000,2,2));
	bank.kontoHinzuf�gen(new Konto(new Kunde("Ha","Tschi"),3000,3,3));
	
	anmelden(2,3);
	anmelden(2,2);

	bank.�berweisen(nutzerIban, 3, 5000);//Zu wenig Geld
	bank.�berweisen(nutzerIban, 3, 5);//Passt
	bank.�berweisen(nutzerIban, 100, 100);//falsche Iban
	bank.abheben(nutzerIban, 100);


	}
}
