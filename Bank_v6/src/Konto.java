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
	@XmlElement
	private double dispo;
	
	public Konto(){
		
	}
	
	public Konto (Kunde k, double ks, int iban, int pin, double d){
		Besitzer = k;
		Kontostand = ks;
		IBAN = iban;
		PIN = pin;
		dispo = d;
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
	public double getDispo() {
		return dispo;
	}
	
	public void ueberweisen(double betrag){
		Kontostand = Controller.round(Kontostand+betrag);
	}
}
