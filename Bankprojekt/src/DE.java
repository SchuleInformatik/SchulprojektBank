
public interface DE {
	abstract void �berweisen(Konto Ziel, float summe);
	abstract DE KontoHinzuRek(Konto k);
	abstract Konto sucheRek(int iban);
}
