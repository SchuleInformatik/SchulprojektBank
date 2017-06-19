import javax.xml.bind.annotation.XmlElement;


public class Konto {
	@XmlElement
	private Kunde Besitzer;
	@XmlElement
	private double Kontostand;
	@XmlElement
	private int IBAN;
	@XmlElement
	private String passwort;
	@XmlElement
	private double dispo;
	
	public Konto(){
		
	}
	
	public Konto (Kunde k, double ks, int iban, String pw, double d){
		Besitzer = k;
		Kontostand = ks;
		IBAN = iban;
		passwort = pw;
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
	public String getPasswort(){
		return passwort;
	}
	public double getDispo() {
		return dispo;
	}
	/**
	 * addiert den eingegeben Betrag zum Kontostand
	 * @param betrag
	 */
	public void ueberweisen(double betrag){
		Kontostand = Controller.round(Kontostand+betrag);
	}
}
