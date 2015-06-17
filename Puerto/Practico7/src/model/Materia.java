package model;

public class Materia implements Promediable{
	private int codigo;
	private String denominacion;
	private int semestre;
	
	
	
	public Materia(int codigo, String denominacion, int semestre) {
		super();
		this.setCodigo(codigo);
		this.setDenominacion(denominacion);
		this.setSemestre(semestre);
		}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	@Override
	public String toString() {
		return "Materia [codigo=" + codigo + ", denominacion=" + denominacion
				+ ", semestre=" + semestre + "]";
	}
	@Override
	public float calcularPromedio() {
		// TODO Auto-generated method stub
		return 10;
	}
	
	
	

}
