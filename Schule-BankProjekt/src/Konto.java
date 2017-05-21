
public class Konto {
	private Kunde Besitzer;
	private float Kontostand;
	private int IBAN;
	private int PIN;
	
	public Konto (Kunde k, float ks, int iban, int pin){
		Besitzer = k;
		Kontostand = ks;
		IBAN = iban;
		PIN = pin;		
	}
	public int getIban(){
		return IBAN;
	}
	public float getKontostand(){
		return Kontostand;
	}
	public int getPin(){
		return PIN;
	}
	public void überweisen(float betrag){
		Kontostand = Kontostand+betrag;
	}
}
