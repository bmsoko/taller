package model;

public class ListaEnlazadaDoble implements ListaDoble {

	private NodoListaDoble cabecera;
	private NodoListaDoble fin;

	public ListaEnlazadaDoble() {
		this.cabecera = new NodoListaDoble(null, fin, null);
		this.fin = new NodoListaDoble(null, null, cabecera);

	}

	public void vaciar() {
		cabecera.setSiguiente(fin);
	}

	public NodoListaDoble getFin() {
		return fin;
	}

	public void setFin(NodoListaDoble fin) {
		this.fin = fin;
	}

	@Override
	public boolean esVacia() {
		// TODO Auto-generated method stub
		if (this.getCabecera().getSiguiente() == fin)
			return true;
		return false;

	}

	public NodoListaDoble getCabecera() {
		return cabecera;
	}

	public void setCabecera(NodoListaDoble cabecera) {
		this.cabecera = cabecera;
	}

}
