
public class Bank {
	private DE erster;
	private int laenge;
	private float dispo;
	
	public Bank (float d){
		dispo = d;
		erster = new Kompositum();
		laenge = 0;
	}
	
	public void KontoHinzu(Konto k){
		erster.KontoHinzuRek(k);
	}
	
	public Konto suche(int iban){
		Konto fund = erster.sucheRek(iban);
		if(fund == null){
			System.out.println("Dieses Konto existiert nicht.");
			return null;
		}
		else{
			return fund;
		}
	}
	
	public void überweisen(int ibanS, int pin, float s, int ibanZ){
		Konto start = suche(ibanS);
		Konto ziel = suche(ibanZ);
		if(!(start == null) && !(ziel == null)){
				if(start.anmelden(pin)){
					start.überweisen(ziel, s);	
				}
				else{
					System.out.println("PIN und IBAN sind inkompatibel, bitte versuchen sie es erneut.");
				}
		}
	}
	
	public float GeldAbheben(float summe, Konto k, int pin){
		if(k.anmelden(pin)){
			k.abheben(summe);
			return summe;
		}
		else{
			System.out.println("PIN und IBAN sind inkompatibel, bitte versuchen sie es erneut.");
			return 0;
		}
	}
	
}
