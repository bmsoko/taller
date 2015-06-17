package puerto.model;

public class Anden {
	private int identificador;
	private String nombre;
	private Embarcacion embEnAtendimiento;

	public String getNombre() {
		return nombre;
	}

	public Anden(int id, String nombre) {
		super();
		this.identificador = id;
		this.nombre = nombre;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Embarcacion getEmbEnAtendimiento() {
		return embEnAtendimiento;
	}

	public void setEmbEnAtendimiento(Embarcacion embEnAtendimiento) {
		this.embEnAtendimiento = embEnAtendimiento;
	}

}
