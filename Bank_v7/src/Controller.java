import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class Controller {
    private Bank bank = null;
    private int nutzerIban;
    private File datenFile = new File("daten/datenfile.xml");
    
    public int anmelden(int Iban, String passwort){
        if(bank.anmeldenGueltig(Iban, passwort)){
            nutzerIban=Iban;
            System.out.println("Sie sind angemeldet als "+bank.kontoSuche(nutzerIban).getKunde().getVorname()+" "+bank.kontoSuche(nutzerIban).getKunde().getNachname()+". Iban: " + nutzerIban);
            return 0;
        }else{
            System.out.println("Ungueltige Iban oder Passwort.");
            return 3;
        }
    }
    public Konto getKonto(){
        return bank.kontoSuche(nutzerIban);
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
        
        /*controller.bank.kontoHinzufuegen(new Konto(new Kunde("Arndt","Samuel"),10000,1,"arsa1",500));
        controller.bank.kontoHinzufuegen(new Konto(new Kunde("Will","Moritz"),10000,2,"wimo2",600));
        controller.bank.kontoHinzufuegen(new Konto(new Kunde("Zintel","Patrick"),10000,3,"zipa3",400));
        controller.datenSchreiben();*/
        
        controller.bank = controller.datenLesen();
        View view = new View(controller);
        view.loginFensterStarten();
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
