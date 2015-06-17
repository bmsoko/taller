package model;

public class NodoListaDoble {

	private Comparable dato;
	private NodoListaDoble siguiente;
	private NodoListaDoble anterior;

	public NodoListaDoble getAnterior() {
		return anterior;
	}

	public void setAnterior(NodoListaDoble anterior) {
		this.anterior = anterior;
	}

	public NodoListaDoble(Comparable dato, NodoListaDoble siguiente,
			NodoListaDoble anterior) {
		super();
		this.dato = dato;
		this.siguiente = siguiente;
		this.anterior = anterior;
	}

	public Comparable getDato() {
		return dato;
	}

	public void setDato(Comparable dato) {
		this.dato = dato;
	}

	public NodoListaDoble getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoListaDoble siguiente) {
		this.siguiente = siguiente;
	}

}
