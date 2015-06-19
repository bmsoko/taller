package model;


public class ListaIteradoraOrdenada extends ListaDobleIter {
	
	
	public ListaIteradoraOrdenada(ListaEnlazadaDoble lista) throws ClassCastException {
		super(lista);
		super.actual = super.lista.esVacia() ? super.lista.getCabecera() : super.lista
				.getCabecera().getSiguiente();
		
	}

	@Override
	public void insertar(Comparable dato) throws ElementoNoEncontradoException {
		super.actual=super.lista.getCabecera().getSiguiente();
		
		if (!super.lista.esVacia()) {
			while (super.actual.getSiguiente() != null) {
				if (super.actual.getDato().compareTo(dato) >= 0) {
					NodoListaDoble tmp = new NodoListaDoble(dato, super
							.getActual().getSiguiente(), super.actual);
					super.actual.getSiguiente().setAnterior(tmp);
					super.actual.setSiguiente(tmp);
					super.actual=tmp;
					super.setActual(super.getActual().getSiguiente());
					return;
				}
				else
				{
					NodoListaDoble tmp = new NodoListaDoble(dato, super
							.getActual(), super.actual.getAnterior());

					super.actual.getAnterior().setSiguiente(tmp);
					super.actual.setAnterior(tmp);
					super.actual=tmp;
					super.setActual(super.getActual().getSiguiente());
					return;
				}
				
			}
		}
			else {
				//Lista vacia
				NodoListaDoble tmp= new NodoListaDoble(dato, this.lista.getFin(), this.lista.getCabecera());
				lista.getCabecera().setSiguiente(tmp);
				lista.getFin().setAnterior(tmp);
				}

		

	}
}
