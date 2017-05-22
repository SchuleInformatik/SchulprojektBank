
public class Controller {
	static private Bank bank = new Bank();
	static private int nutzerIban;
	
	static public void anmelden(int Iban, int Pin){
		if(bank.anmeldenG�ltig(Iban, Pin)){
			nutzerIban=Iban;
			System.out.println("Sie sind angemeldet.");
		}else{
			System.out.println("Ung�ltige Iban oder Passwort.");
		}
	}
	static public void �berweisen(int ibanZu, int betrag){
		bank.�berweisen(nutzerIban, ibanZu, betrag);
	}
	static public void abheben(int betrag){
		bank.abheben(nutzerIban, betrag);
	}
	public static void main(String[] args){
	boolean b= true;
	bank.kontoHinzuf�gen(new Konto(new Kunde("Hans","Sale"),1000,1,1));
	bank.kontoHinzuf�gen(new Konto(new Kunde("Glubsch","Lo"),2000,2,2));
	bank.kontoHinzuf�gen(new Konto(new Kunde("Ha","Tschi"),3000,3,3));
	
	anmelden(2,3);
	anmelden(2,2);

	bank.�berweisen(nutzerIban, 3, 5000);//Zu wenig Geld
	bank.�berweisen(nutzerIban, 3, 5);//Passt
	bank.�berweisen(nutzerIban, 100, 100);//falsche Iban
	bank.abheben(nutzerIban, 200);


	}
}
