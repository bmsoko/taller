package model;

public class ListaDobleIter implements IteradoraDoble {

	private ListaEnlazadaDoble lista;
	private NodoListaDoble actual;

	public ListaDobleIter(ListaEnlazadaDoble lista) {
		this.lista = lista;
		actual = this.lista.esVacia() ? lista.getCabecera() : lista
				.getCabecera().getSiguiente();
	}

	public ListaDobleIter(ListaDoble lista) throws ClassCastException {
		ListaEnlazadaDoble aux = ((ListaEnlazadaDoble) lista);
	}

	/*
	 * Inserta tras la posición actual. actual apunta al nodo insertado con
	 * éxito
	 * 
	 * @param dato el elemento a insertar
	 * 
	 * @exception ElementoNoEncontrado si la posición actual es null
	 */
	public void insertar(Comparable dato) throws ElementoNoEncontradoException {
		if (this.tamanyo() == 0) {
			actual = new NodoListaDoble(dato, null, null);
			lista.getCabecera().setSiguiente(actual);
			lista.getFin().setAnterior(actual);
			actual.setAnterior(lista.getCabecera());
			actual.setSiguiente(lista.getFin());
			return;
		}

		if (actual == null)
			throw new ElementoNoEncontradoException("Error de inserción");
		NodoListaDoble tmp = new NodoListaDoble(dato, actual.getSiguiente(),
				actual);
		actual.setSiguiente(tmp);
		actual.getSiguiente().setAnterior(tmp);
		actual = tmp;

	}

	/*
	 * Coloca el nodo actual con el primer elemento que coincide con el valor
	 * buscado x. Si no encontramos x el objeto cabecera no se verá modificado
	 * 
	 * @param dato elemento a buscar
	 * 
	 * @param return true si encontramos el valor, en caso contrario devolvemos
	 * false
	 */
	public boolean buscar(Comparable dato) {
		NodoListaDoble itr = lista.getCabecera().getSiguiente();
		while (itr != null
				&& dato.toString().compareTo(itr.getDato().toString()) != 0)
			itr = itr.getSiguiente();

		if (itr == null)
			return false;

		actual = itr;
		return true;
		// TODO Auto-generated method stub

	}

	public NodoListaDoble getActual() {
		return actual;
	}

	public void setActual(NodoListaDoble actual) {
		this.actual = actual;
	}

	/*
	 * Elimina la primera aparición del elemento buscado. Si aparece el
	 * elemento, actual queda apuntando a cabecera. Si no se encuentra el
	 * elemento no se modifica la lista
	 * 
	 * @param dato elemento a buscar en la lista
	 * 
	 * @exception si no se encuentra el elemento
	 */
	public void eliminar(Object dato) throws ElementoNoEncontradoException {
		NodoListaDoble itr = this.lista.getCabecera().getSiguiente();
		while (itr != null
				&& dato.toString().compareTo(itr.getDato().toString()) != 0)
			itr = itr.getSiguiente();

		if (itr.getSiguiente() == null)
			throw new ElementoNoEncontradoException("El elemento no existe");

		itr.getAnterior().setSiguiente(itr.getSiguiente());
		itr.getSiguiente().setAnterior(itr.getAnterior());
		itr = null;
		actual = lista.getCabecera(); // Posicionamiento de actual en el
										// principio de lista

	}

	/*
	 * Comprueba si el elemento esta en una posición válida
	 * 
	 * @return true si el elemento no es null y si no apunta a elemento
	 * cabecera.
	 */
	public boolean estaDentro() {
		return actual != null && actual != lista.getCabecera().getSiguiente();
	}

	/*
	 * Devuelve el elemento en la posición actual.
	 * 
	 * @return el elemento si existe y null si el objeto no esta dentro de la
	 * lista
	 */
	public Comparable recuperar() {
		// TODO Auto-generated method stub
		return (Comparable) (estaDentro() ? actual.getDato() : null);
	}

	/*
	 * Coloca la posición actual en el nodo cabecera
	 */
	public void cero() {
		actual = lista.getCabecera();

	}

	/*
	 * Coloca el actual en el primer elemento de la lista. Esta operacion es
	 * válida para listas vacias.
	 */
	public void primero() {
		actual = lista.getCabecera().getSiguiente();

	}

	/*
	 * Avanzar al próximo elemento de la lista. Si el elemento actual es null,
	 * no hace nada. No se lanzan excepciones ya que de esta manera se deberias
	 * incluir Try/Catch en los bucles que recorren la lista
	 */
	public void avanzar() {
		if (actual != null) {
			actual = actual.getSiguiente();
		}

	}
	
	public void retroceder() {
		if (actual != null) {
			actual = actual.getAnterior();
		}

	}

	/*
	 * Coloca el actual en el ultimo elemento de la lista. Esta operacion es
	 * válida para listas vacias.
	 */
	public void ultimo() {
		actual = lista.getFin();
	}

	public int tamanyo() {
		int contador = 0;
		NodoListaDoble aux = actual;
		while (aux != null && aux.getSiguiente() != null) {
			contador++;
			aux = aux.getSiguiente();
		}

		return contador;
	}

	public ListaEnlazadaDoble getLista() {
		return lista;
	}

	public void setLista(ListaEnlazadaDoble lista) {
		this.lista = lista;
	}

}
