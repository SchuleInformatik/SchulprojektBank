
import javax.swing.JOptionPane;

public class View {
    
    Controller controller;
    LoginFenster loginFenster = new LoginFenster(controller, this);
    Hauptfenster hauptFenster = new Hauptfenster(controller, this);
    private String fehlermeldungen[] = {"Fehler1 ", "Fehler2", "Fehler3", "Fehler4", "Fehler5", "Fehler6", "Fehler7", "Fehler8"};
    
    public View(Controller c) {
        controller = c;
    }
    
    public void loginFensterStarten() {
        loginFenster.guiStarten();   
    }
    
    public void hauptFensterStarten() {
        hauptFenster.guiStarten();
    }
    //Login
    public void loginButton() {
        int nummer = -1;
        int passwort = -1;
        boolean fehler = false;
        if(!loginFenster.getNummerText().getText().matches("[0-9]+")) {
        	dialogFehlermeldung(1);
        	fehler = true;
        }
    	else
    		nummer = Integer.parseInt(loginFenster.getNummerText().getText());
        
        if(!loginFenster.getPasswortText().getText().matches(".+")) {
        	dialogFehlermeldung(2);
        	fehler = true;
        }
    	else
            passwort = Integer.parseInt(loginFenster.getPasswortText().getText());
        if(!fehler) {
            int status = controller.anmelden(nummer, passwort);
            if(status == 0) {
                    loginFenster.dispose();
                    controller.hauptFensterStarten(controller);
            } else {
                    dialogFehlermeldung(status);
            }
        }
    }   
    //Login End
    //Hauptfenster
    public void auszahlenButton() {
        double betrag = -1;
    	int status = -1;
    	if(!hauptFenster.getAuszahlungText().getText().matches("[0-9]+\\.?[0-9]{0,2}"))
    		dialogFehlermeldung(1);
    	else {
    		betrag = Double.parseDouble(hauptFenster.getAuszahlungText().getText());
    		status = controller.abheben(betrag);
    		if(status == 0) 
                    dialogNachricht(betrag + " Euro wurden ausgezahlt.");
    		else
                    dialogFehlermeldung(status);
    	}
    }
    
    public void ueberweisenButton() {
        int zielIban = -1;
    	double betrag = -1;
    	int status = -1;
    	//Anleitung: http://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
    	//oder: http://www.vogella.com/tutorials/JavaRegularExpressions/article.html
    	if(!hauptFenster.getZielNummerText().getText().matches("[0-9]+"))
    		dialogFehlermeldung(1);
    	else
    		zielIban = Integer.parseInt(hauptFenster.getZielNummerText().getText());
    	if(!hauptFenster.getUeberweisungBetragText().getText().matches("[0-9]+\\.?[0-9]{0,2}"))
    		dialogFehlermeldung(1);
    	else
    		betrag = Double.parseDouble(hauptFenster.getUeberweisungBetragText().getText());
    	
    	if(zielIban != -1 && betrag != -1) {
    		status = controller.ueberweisen(zielIban, betrag);
    		if(status == 0)
    			dialogNachricht(betrag + " Euro wurden an das Konto " + zielIban + " überwiesen.");
    		else
    			dialogFehlermeldung(status);
    	}
    }
    
    public void kontostandButton() {
        dialogNachricht("Dein Kontostand beträgt " + controller.getKontostand() + " Euro.");
    }
    
    public void abmeldenButton() {
        int auswahl = JOptionPane.showOptionDialog(null, "Wollen Sie sich wirklich abmelden","Abmelden?",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.WARNING_MESSAGE, null, 
        new String[]{"Ja", "Nein"}, "Nein");
        if(auswahl == 0)
            exit();
    }
    
    public void benutzerPanel() {
        hauptFenster.getBNameText().setText("Name: " + controller.getKonto().getKunde().getNachname());
        hauptFenster.getBVornameText().setText("Vorname: " + controller.getKonto().getKunde().getVorname());
        hauptFenster.getBKontonummerText().setText("Kontonummer: " + controller.getKonto().getIban());
        hauptFenster.getBDispoText().setText("Dispositionskredit: " + controller.getKonto().getDispo());

    }
    //Hauptfenster End
    
    private void exit() {
        hauptFenster.dispose();
        System.exit(0);
    }
    
    private void dialogNachricht(String text) {
        JOptionPane.showMessageDialog(null, text);
    }
    
    public void dialogFehlermeldung(int index) {
        JOptionPane.showMessageDialog(null, fehlermeldungen[index - 1], "Fehler!", JOptionPane.ERROR_MESSAGE);
    }
    
    public void setLoginFenster(LoginFenster lF) {
        loginFenster = lF;
    }

    void setHauptFenster(Hauptfenster hF) {
        hauptFenster = hF;
    }
    
}
