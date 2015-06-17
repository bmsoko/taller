package model;

public class Descarga {

	private Embarcacion barcoAtendido;
	private Anden andenAtencion;

	public Descarga(Embarcacion barcoAtendido, Anden andenAtencion) {
		super();
		this.barcoAtendido = barcoAtendido;
		this.andenAtencion = andenAtencion;
	}

	public Embarcacion getBarcoAtendido() {
		return barcoAtendido;
	}

	public void setBarcoAtendido(Embarcacion barcoAtendido) {
		this.barcoAtendido = barcoAtendido;
	}

	public Anden getAndenAtencion() {
		return andenAtencion;
	}

	public void setAndenAtencion(Anden andenAtencion) {
		this.andenAtencion = andenAtencion;
	}

}
