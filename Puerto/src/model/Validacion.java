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
//		Double cargado = Double.parseDouble(carga);

		if (carga < 0) {
			throw new MiExcepcion("La carga ingresada no puede ser negativa.");
		}

		if (carga > 99000) {
			throw new MiExcepcion("Revise la carga ingresada, la misma seria imposible que supere 99000.");
		}
		return;
	}

	public static boolean esNumero(String carga) throws MiExcepcion {

		if (!carga.matches("[0-9]*")){
			throw new MiExcepcion("Ha ingresado dato equivocado, el mismo no puede ser texto.");	
		}

		return true;

	}

//	public static void tieneCaracteresEsp(Object carga) throws MiExcepcion {
//		if (carga instanceof String){
//			throw new MiExcepcion("Ha ingresado dato equivocado, el mismo no puede ser texto");
//		}
//
//
//	}

}
