package model;

public class Validacion {

	public static boolean validarTextoVacioYCantidad(String nombre) throws MiExcepcion
	{

		if (nombre==null || nombre.trim().equals("")) {
			throw new MiExcepcion("El texto ingresado no puede ser vacio");
		} 
		if (nombre.length()<2) {
			throw new MiExcepcion("El texto no puede tener menos de 2 caracteres");
		}

		return true;
	}

	public static void numero(Double carga) throws MiExcepcion{
		if (carga < 0) {
			throw new MiExcepcion("Ha ingresado cantidad de carga erronea. Intente nuevamente");
		}
		
		if (carga == 0) {
			throw new MiExcepcion("Ha ingresado cantidad de carga erronea. Intente nuevamente.");
		}
		
		if (carga > 99000) {
			throw new MiExcepcion("Ha ingresado cantidad de carga erronea. Intente nuevamente.");
		}
		return;
	}

	public static boolean esNumero(String carga) throws MiExcepcion {

		if (!carga.matches("[0-9]*")){
			throw new MiExcepcion("Ha ingresado un numero erroneo. Intente nuevamente.");	
		}

		return true;

	}

}
