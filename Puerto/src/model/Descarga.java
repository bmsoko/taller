package model;

public class Descarga implements Comparable{

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

	@Override
	public int compareTo(Comparable dato) {
		if (((Descarga)dato).getBarcoAtendido().getCarga() > this.getBarcoAtendido().getCarga())
		{
			return 1;	
		}else if (((Descarga)dato).getBarcoAtendido().getCarga() < this.getBarcoAtendido().getCarga()) {
			return -1;
		}
		return 0;
	}

}
