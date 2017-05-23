import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


 public class Controller {
	private Bank bank = null;
	private int nutzerIban;
	private File datenFile = new File("daten/datenfile.xml");
	
	public int anmelden(int Iban, int Pin){
		if(bank.anmeldenGueltig(Iban, Pin)){
			nutzerIban=Iban;
			System.out.println("Sie sind angemeldet als "+bank.kontoSuche(nutzerIban).getKunde().getVorname()+" "+bank.kontoSuche(nutzerIban).getKunde().getNachname()+". Iban: " + nutzerIban);
			return 0;
		}else{
			System.out.println("Ungueltige Iban oder Passwort.");
			return 3;
		}
	}
	public int ueberweisen(int ibanZu, double betrag){
		int status = bank.ueberweisen(nutzerIban, ibanZu, betrag);
		if(status == 0) {
			datenSchreiben();
		}
		return status;
	}
	public int abheben(double betrag){
		int status = bank.abheben(nutzerIban, betrag);
		if(status == 0) 
			datenSchreiben();
		return status;
	}
	public double getKontostand(){
		return bank.kontoSuche(nutzerIban).getKontostand();
	}
	
	public static void main(String[] args){
		Controller controller = new Controller();
		controller.bank = new Bank();
		
		/*controller.bank.kontoHinzufuegen(new Konto(new Kunde("Hans","Sale"),1000,1,1));
		controller.bank.kontoHinzufuegen(new Konto(new Kunde("Glubsch","Lo"),2000,2,2));
		controller.bank.kontoHinzufuegen(new Konto(new Kunde("Ha","Tschi"),3000,3,3));		
		controller.datenSchreiben();*/
		
		controller.bank = controller.datenLesen();
		//LoginFenster logInFenster = new LoginFenster(controller);
		//logInFenster.guiStarten();
                View view = new View(controller);
                view.loginFensterStarten();
				
		//bank.ueberweisen(nutzerIban, 3, 5000);//Zu wenig Geld
		//bank.ueberweisen(nutzerIban, 3, 5);//Passt
		//bank.ueberweisen(nutzerIban, 100, 100);//falsche Iban
		//bank.abheben(nutzerIban, 100);


	}
	
	public void hauptFensterStarten(Controller c) {
		View view = new View(c);               
                view.hauptFensterStarten(); 
	}
	
	//Anleitung: http://www.mkyong.com/java/jaxb-hello-world-example/
	public void datenSchreiben() {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Bank.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(this.bank, datenFile);
			//jaxbMarshaller.marshal(this.bank, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public Bank datenLesen() {
		Bank bank = null;
		try {			
			JAXBContext jaxbContext = JAXBContext.newInstance(Bank.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			bank = (Bank) jaxbUnmarshaller.unmarshal(datenFile);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return bank;
	}
	
	public static double round(double value) {

	    long factor = (long) Math.pow(10, 2);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
}
