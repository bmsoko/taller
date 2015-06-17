package model;

public class ColaVector implements Cola {
	
	private static final int N=1000;
	private int capacidad;
	private Object S[];
	private int cabeza=0;
	private int fin=-1;
	private int tamanyoActual=0;
	
	ColaVector()
	{ this(N);	}

	public ColaVector(int n2) {
		// TODO Auto-generated constructor stub
		this.capacidad=n2;
		S= new Object[capacidad];
	}

	@Override
	public boolean esVacia() {
		if (getTamanyoActual()==0) return true;
		else return false;
	}

	@Override
	public void vaciar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertar(Object o) throws DesbordamientoSuperior  {
		// TODO Auto-generated method stub
		if (this.getTamanyoActual()==this.getCapacidad())
			throw new DesbordamientoSuperior("Cola llena");
		tamanyoActual++;
		fin= incrementar(fin);
		S[fin]=o;
															
	}

	private int incrementar(int fin2) {
		// TODO Auto-generated method stub
		/* Si es circular comprobar */
		if (++fin2 > S.length)
			fin2=0;
		return fin2;
	}

	@Override
	public Object primero() throws DesbordamientoInferior {
		// TODO Auto-generated method stub
		if (esVacia())
			throw new DesbordamientoInferior("Cola Vacia");
		
		return S[cabeza];
	}

	@Override
	public Object quitarPrimero() throws DesbordamientoInferior {
		// TODO Auto-generated method stub
		if (esVacia())
			throw new DesbordamientoInferior("Cola Vacia");
		tamanyoActual--;
		cabeza=incrementar(cabeza);
		Object aux=S[cabeza];
		return aux;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getCabeza() {
		return cabeza;
	}

	public void setCabeza(int cabeza) {
		this.cabeza = cabeza;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

	public int getTamanyoActual() {
		return tamanyoActual;
	}

	public void setTamanyoActual(int tamanyoActual) {
		this.tamanyoActual = tamanyoActual;
	}

}
