package model;

import java.util.ArrayList;

public class Alumno extends Persona implements Promediable{
	private String legajo;
	private ColaVector materias;
	
	

	public Alumno(String nombre, String apellido, int dni, String legajo, ColaVector materias) {
		super(nombre,apellido, dni);
		this.setLegajo(legajo);
		this.setMaterias(materias);
		
	}
	
	public Alumno(String nombre, String apellido, int dni, String legajo) {
		super(nombre,apellido, dni);
		this.legajo = legajo;
		materias= new ColaVector();
		
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	
	
	
	public ColaVector getMaterias() {
		return materias;
	}

	public void setMaterias(ColaVector materias) {
		this.materias = materias;
	}

	public String listarMaterias ()
	{
		return "[ + getMaterias()=" + getMaterias()
				+ "]";
	}

	@Override
	public String toString() {
		return "Alumno [legajo=" + legajo + ", getLegajo()=" + getLegajo()
				+ ", getMaterias()=" + getMaterias() + ", listarMaterias()="
				+ listarMaterias() + ", getNombre()=" + getNombre()
				+ ", getApellido()=" + getApellido() + ", getDni()=" + getDni()
				+ "]";
	}

	@Override
	public float calcularPromedio() {
		// TODO Auto-generated method stub
		return 10;
	}


	
	
	
	

}
