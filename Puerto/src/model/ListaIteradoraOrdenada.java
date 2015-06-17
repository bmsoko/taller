package model;

public class ListaIteradoraOrdenada extends ListaDobleIter {

	public ListaIteradoraOrdenada(ListaDoble lista) throws ClassCastException {
		super(lista);
		// TODO Auto-generated constructor stub
		NodoListaDoble actual;
	}

	@Override
	public void insertar(Comparable dato) throws ElementoNoEncontradoException {
		this.setActual(super.getLista().getCabecera().getSiguiente());
		if (dato instanceof Comparable) {
			while (this.getActual().getSiguiente() != null) {
				if (this.getActual().getDato().compareTo(dato) > 0) {
					NodoListaDoble tmp = new NodoListaDoble(dato, this
							.getActual().getSiguiente(), this.getActual());
					this.getActual().setSiguiente(tmp);
					getActual().getSiguiente().setAnterior(tmp);
					this.setActual(tmp);
					return;
				}
				setActual(getActual().getSiguiente());

			}
		} else {
			throw new ElementoNoEncontradoException(
					"Objeto no es de tipo comparable");
		}

	}

}
