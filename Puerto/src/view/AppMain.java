package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Anden;
import model.ColaVector;
import model.Comparable;
import model.DesbordamientoInferior;
import model.DesbordamientoSuperior;
import model.Descarga;
import model.Embarcacion;
import model.IteradoraDoble;
import model.ListaEnlazadaDoble;
import model.ListaIteradoraOrdenada;
import model.MiExcepcion;
import model.Validacion;

public class AppMain {

	/**
	 * @param args
	 */

	private static Scanner sc = new Scanner(System.in);
	//arraylist para los andenes.
	private static ArrayList<Anden> andenes = new ArrayList<Anden>();
	//cola para manejar la espera de los barcos.
	private static ColaVector listaEspera = new ColaVector(500);
	//precio fijo por tonelada.
	private static int precioPorTonelada = 600;
	//Implementacion de las listas.
	static ListaEnlazadaDoble listado = new ListaEnlazadaDoble();
	static ListaIteradoraOrdenada descargas = new ListaIteradoraOrdenada(
			listado);

	public static void main(String[] args) {
		// iniciamos los 3 andenes
		andenes.add(new Anden(1, "Anden1"));
		andenes.add(new Anden(2, "Anden2"));
		andenes.add(new Anden(3, "Anden3"));
		menu();

	}

	private static void menu() {
		String option;
		do {
			imprimirMenu();
			option = sc.next();
			switch (option) {
			case "1":
				registrarEmbarcacion();
				break;
			case "2":
				atenderEmbarcacion();
				break;
			case "3":
				descargarEmbarcacionesEnAndenes();
				break;
			case "4":
				listarEmbarcacionesAtendidasAscendente();
				break;
			case "5":
				listarEmbarcacionesAtendidasDescendentes();
				break;
			case "6":
				System.out
				.println("Trabajo realizado por Bruno Soko y Franco Funes");
				break;

			default:
				System.out.println("Opción Invalida, intente nuevamente");
				break;
			}

		} while (option.compareToIgnoreCase("6") != 0);

	}

	private static void listarEmbarcacionesAtendidasDescendentes() {
		System.out.println();
		System.out
		.println("Listado descendente de embarcaciones por monto facturado");
		System.out
		.println("=======================================================");
	
		descargas.ultimo();
		Descarga descAux = null;


		while (descargas.getActual().getAnterior() != null) {
			descAux = (Descarga) descargas.getActual().getDato();

			System.out
			.println("Nombre Barco: "
					+ descAux.getBarcoAtendido().getNombre()
					+ "Carga Facturada: $"
					+ descAux.getBarcoAtendido().getCarga()
					* precioPorTonelada);

			descargas.retroceder();

		}
		if(descargas.tamanyo()==0){
			System.out.println("No hay embarcaciones por listar.");
		}

	}

	private static void listarEmbarcacionesAtendidasAscendente() {
		System.out.println();
		System.out
		.println("Listado ascendente de embarcaciones por monto facturado");
		System.out
		.println("=======================================================");
		descargas.primero();
		Descarga descAux = null;

		if(descargas.tamanyo()==0){
			System.out.println("No hay embarcaciones por listar.");
		}

		while (descargas.getActual().getSiguiente() != null) {
			descAux = (Descarga) descargas.getActual().getDato();

			System.out
			.println("Nombre Barco: "
					+ descAux.getBarcoAtendido().getNombre()
					+ " Carga Facturada: $"
					+ descAux.getBarcoAtendido().getCarga()
					* precioPorTonelada);

			descargas.avanzar();

		}

	}

	@SuppressWarnings("unused")
	private static void descargarEmbarcacionesEnAndenes() {
		Anden andenSelecc = null;
		String conf = null;
		System.out.println("Descarga de embarcaciones");
		System.out.println("=========================");
		// Mostrar andenes ocupados
		if (mostrarAndenesOcupados()) {
			System.out
			.print("Ingrese el Identificador del andén a seleccionar: ");
			andenSelecc = seleccionarAnden(sc.nextInt());	
		} 

		try {
			System.out.println("La embarcación a descargar es: "
					+ andenSelecc.getEmbEnAtendimiento().getNombre());
			do {
				System.out
				.print("¿Confirma que quiere realizar la operación? (S/N): ");
				conf = sc.next();
			} while (conf.compareToIgnoreCase("S") != 0
					&& conf.compareToIgnoreCase("N") != 0);

			if (conf.compareToIgnoreCase("N") == 0 ){
				System.out.println();
				System.out.println("La descarga se ha cancelado, volviendo al menu principal... ");
				System.out.println();
				menu();
			}else{
				// Creación de una nueva descarga de los barcos atendidos
				descargas.insertar(new Descarga(andenSelecc.getEmbEnAtendimiento(),
						andenSelecc));
				// Liberación del anden
				andenSelecc.setEmbEnAtendimiento(null);
				System.out.println();
				System.out.println("La descarga de la embarcaion se realizo con exito!! ");
				System.out.println();
			}
			if (andenSelecc == null)
				throw new Exception(
						"El anden seleccionado no existe, intente nuevamente");
		} catch (DesbordamientoInferior e) {
			System.out.println("No hay embarcaciones por descargar"
					+ e.getMessage());
			System.out.println();	
		} catch (Exception e) {
			System.out.println("No existen barcos para realizar descarga, intente nuevamente");
			System.out.println();
		}

	}

	private static void atenderEmbarcacion() {
		Anden andenSelecc = null;
		String conf = null;
		System.out.println();
		System.out.println("Atendimiento de embarcaciones");
		System.out.println("=============================");
		System.out.println("Seleccione un andén libre: ");
		if (mostrarAndenesLibres()) {
			System.out
			.print(" Ingrese el Identificador del andén a seleccionar: ");
			andenSelecc = seleccionarAnden(sc.nextInt());

		} else {
			System.out
			.println(" No hay andenes disponibles, intente nuevamente mas tarde ");
		}

		try {
			System.out.println("La embarcación a atender es: "
					+ ((Embarcacion) listaEspera.primero()).getNombre());

			do {
				System.out
				.print(" ¿Confirma que quiere realizar la operación? (S/N): ");
				conf = sc.next();

			} while (conf.compareToIgnoreCase("S") != 0
					&& conf.compareToIgnoreCase("N") != 0);
			// Asociacion a un anden y quitado de lista de espera
			if (conf.compareToIgnoreCase("N") == 0 ){
				System.out.println();
				System.out.println("La atencion se ha cancelado, volviendo al menu principal... ");
				System.out.println();
				menu();
			}else{
				Embarcacion embAux = (Embarcacion) listaEspera.quitarPrimero();
				andenSelecc.setEmbEnAtendimiento(embAux);
				System.out.println();
				System.out.println("La atencion de la embarcaion se realizo con exito!!");
				System.out.println();
			}

			if (andenSelecc == null)
				throw new Exception(
						" El anden seleccionado no existe, intente nuevamente ");

		} catch (DesbordamientoInferior e) {
			System.out.println("No hay embarcaciones por atender: "
					+ e.getMessage());
			System.out.println();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
			atenderEmbarcacion();
		}

	}

	private static Anden seleccionarAnden(int nextInt) {
		for (Anden and : andenes) {
			if (and.getIdentificador() == nextInt)
				return and;

		}
		return null;
	}

	private static boolean mostrarAndenesLibres() {
		int cont = 0;
		for (Anden and : andenes) {
			if (and.getEmbEnAtendimiento() == null) {
				System.out.println("Anden Nº " + and.getIdentificador()
						+ "- Nombre: " + and.getNombre());
				cont++;
			}
		}
		return cont > 0;
	}

	private static boolean mostrarAndenesOcupados() {
		
			int cont = 0;
			for (Anden and : andenes) {
				if (and.getEmbEnAtendimiento() != null) {
					System.out.println("Anden Nº " + and.getIdentificador()
							+ "- Nombre: " + and.getNombre() + "Embarcación: "
							+ and.getEmbEnAtendimiento().getNombre());
					cont++;
				}
			}
		
		return cont> 0;
	}

	private static void registrarEmbarcacion() {

		Embarcacion nuevaEmbarcacion = new Embarcacion();
		boolean cargaBool;
		System.out.println();
		System.out.println("Registro de embarcación");
		System.out.println("=======================");
		System.out.print("Ingrese el nombre de la embarcación: ");
		String nombre = sc.next();
		
		System.out.print("Ingrese la carga en la embarcación: ");
		String cargado = sc.next();

		try {
			cargaBool = Validacion.esNumero(cargado);
			if (cargaBool){
				double carga = Double.parseDouble(cargado);
				Validacion.numero(carga);
				Validacion.validarTextoVacioYCantidad(nombre);
				nuevaEmbarcacion.setCarga(carga);
				nuevaEmbarcacion.setNombre(nombre);
			}

		} catch (MiExcepcion e1) {
			System.out.println(e1.getMessage());
			System.out.println();
			registrarEmbarcacion();
		}

		// Agregamos la nueva embarcación a la cola de espera
		try {
			listaEspera.insertar(nuevaEmbarcacion);
			System.out.println();
			System.out.println("La Embarcacion ha sido cargada con exito!!");
			System.out.println();
		} catch (DesbordamientoSuperior e) {
			System.out
			.println("Se ha superado la capacidad de atención del puerto, espere a que se vacie la lista y vuelva a intentar");
			System.out.println();
		}

	}

	private static void imprimirMenu() {
		System.out.println();
		System.out.println("Sistema de Puerto");
		System.out.println("=================");
		System.out.println("1- Registrar Embarcación");
		System.out.println("2- Atender Embarcación");
		System.out.println("3- Descargar Embarcación");
		System.out.println("4- Listar Ascendentemente Barcos Atendidos");
		System.out.println("5- Listar Descendentemente Barcos Atendidos");
		System.out.print("6- Salir: ");

	}

}
