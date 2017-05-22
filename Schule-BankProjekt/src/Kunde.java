public class Kunde {
	private String nachname;
	private String vorname;
	
	public Kunde(String nName,String vName){
		nachname=nName;
		vorname=vName;
	}
	public String getNachname(){
		return nachname;
	}
	public String getVorname(){
		return vorname;
	}
}
