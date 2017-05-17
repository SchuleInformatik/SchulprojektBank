
public interface DE {
	abstract void überweisen(Konto Ziel, float summe);
	abstract DE KontoHinzuRek(Konto k);
	abstract Konto sucheRek(int iban);
}
