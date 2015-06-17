package model;

public class StringComparable implements Comparable {
	String stringDato;

	@Override
	public int compareTo(Comparable dato) {
		if (this.stringDato.compareTo(dato.toString()) == 0)
			return 0;
		else if (dato.toString().compareTo(stringDato) > 0)
			return 1;
		else
			return -1;

	}

	public String toString() {
		return stringDato;
	}

	public void setStringDato(String stringDato) {
		this.stringDato = stringDato;
	}

}
