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

	public static void negativo(Double carga) throws MiExcepcion{
		if (carga < 0) {
			throw new MiExcepcion("Ha ingresado cantidad de carga erronea, la misma no puede ser negativa. Intente nuevamente");
		}

		if (carga > 99000) {
			throw new MiExcepcion("Ha ingresado cantidad de carga erronea, la misma no puede superar 99000 Toneladas. Intente nuevamente.");
		}
		return;
	}

	public static boolean esNumero(String carga) throws MiExcepcion {

		if (!carga.matches("[0-9]*")){
			throw new MiExcepcion("Ha ingresado un dato erroneo, el mismo no puede ser texto. Intente nuevamente.");	
		}

		return true;

	}

}
