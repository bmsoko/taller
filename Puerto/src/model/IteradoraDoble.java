package model;

public interface IteradoraDoble {

	public void insertar(Comparable dato) throws ElementoNoEncontradoException;

	public boolean buscar(Comparable dato);

	public void eliminar(Object dato) throws ElementoNoEncontradoException;

	public boolean estaDentro();

	public Comparable recuperar();

	public void cero();

	public void primero();

	public void ultimo();

	public void avanzar();

}
