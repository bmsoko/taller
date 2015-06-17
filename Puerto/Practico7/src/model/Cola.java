package model;

public interface Cola {
	
	public boolean esVacia();
	public void vaciar();
	public void insertar(Object o) throws DesbordamientoSuperior;
	public Object primero() throws DesbordamientoInferior;
	public Object quitarPrimero() throws DesbordamientoInferior;
	

}
