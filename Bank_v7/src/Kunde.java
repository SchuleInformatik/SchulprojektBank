import javax.xml.bind.annotation.XmlElement;

public class Kunde {
	@XmlElement
	private String nachname;
	@XmlElement
	private String vorname;
	
	public Kunde(){
		
	}
	
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
