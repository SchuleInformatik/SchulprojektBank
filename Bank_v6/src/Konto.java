import javax.xml.bind.annotation.XmlElement;


public class Konto {
	@XmlElement
	private Kunde Besitzer;
	@XmlElement
	private double Kontostand;
	@XmlElement
	private int IBAN;
	@XmlElement
	private int PIN;
	
	public Konto(){
		
	}
	
	public Konto (Kunde k, double ks, int iban, int pin){
		Besitzer = k;
		Kontostand = ks;
		IBAN = iban;
		PIN = pin;		
	}
	public int getIban(){
		return IBAN;
	}
	public Kunde getKunde(){
		return Besitzer;
	}
	public double getKontostand(){
		return Kontostand;
	}
	public int getPin(){
		return PIN;
	}
	public void ueberweisen(double betrag){
		Kontostand = Controller.round(Kontostand+betrag);
	}
}
