public class Konto implements DE{
	private Kunde Besitzer;
	private DE next;
	private float Kontostand;
	private int IBAN;
	private int PIN;
	
	public Konto (Kunde k, DE n, float ks, int iban, int pin){
		Besitzer = k;
		Kontostand = ks;
		next = n;
		IBAN = iban;
		PIN = pin;		
	}
	public void setNext(DE d){
		next = d;
	}
	
	public int getiban(){
		return IBAN;
	}
	
	public void GeldPlus(float s){
		if(s < 0){Kontostand = Kontostand + s;}
		else {}
	}
	
	public void abheben(float betrag){
		if(betrag < Kontostand){
			Kontostand = Kontostand - betrag;
		}
		else{
			//Frage nach Kredit, wenn ja überweisen mit Kreditaufnahme			
		}
	}
	
	public DE KontoHinzuRek(Konto k){
		if(k.getiban() > IBAN){
			next = next.KontoHinzuRek(k);
			return this;
		}
		else{
			k.setNext(next);
			next = k;
			return this;
		}
	}
	
	public void überweisen(Konto ziel, float summe){
		
			if(Kontostand < summe){
				//Frage nach Kredit, wenn ja überweisen mit Kreditaufnahme			
				}
			else{
				ziel.GeldPlus(summe);
				Kontostand = Kontostand - summe;
				System.out.println("Sie haben erfolgreich "+summe+"€ zum Konto "+ziel+" überwiesen.");
				}
	}
		
	public boolean anmelden(int pin){
		if(pin == PIN){
			return true;
		}
		else return false;
	}
	
	 public Konto sucheRek(int iban){
		 if(IBAN == iban){
			 return this;
		 }
		 else{
			 return next.sucheRek(iban);
		 }
	 }







}