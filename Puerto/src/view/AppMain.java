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

public class AppMain {

	/**
	 * @param args
	 */

	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Anden> andenes = new ArrayList<Anden>();
	//private static ArrayList<Descarga> descargas = new ArrayList<Descarga>();
	private static ColaVector listaEspera = new ColaVector(500);
	private static int precioPorTonelada = 600;
	// br1
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
		int option;
		do {
			imprimirMenu();
			option = sc.nextInt();
			switch (option) {
			case 1:
				registrarEmbarcacion();
				break;
			case 2:
				atenderEmbarcacion();
				break;
			case 3:
				descargarEmbarcacionesEnAndenes();
				break;
			case 4:
				listarEmbarcacionesAtendidasAscendente();
				break;
			case 5:
				listarEmbarcacionesAtendidasDescendentes();
				break;
			case 6:
				System.out
				.println("Trabajo realizado por Bruno Soko y Franco Funes");
				break;

			default:
				System.out.println("Opción Invalida, intente nuevamente");
				break;
			}

		} while (option != 6);

	}

	private static void listarEmbarcacionesAtendidasDescendentes() {
		// Aqui se van a listar Ascendentemente e imprimir los barcos que
		// pasaron por cada anden.
		System.out.println("Listado descendente de embarcaciones por monto facturado");
		System.out.println("=======================================================");
		//Agregar aca la validacion de si esta vacia la lista.
		descargas.ultimo();
		Descarga descAux = null;

		while(descargas.getActual().getAnterior() == null){
			descAux = (Descarga) descargas.getActual().getDato();

			System.out.println("Nombre Barco: " + descAux.getBarcoAtendido().getNombre() + "Carga Facturada: $" + 
					descAux.getBarcoAtendido().getCarga() * precioPorTonelada );
			
			descargas.retroceder();

		}

	}

	

	private static void listarEmbarcacionesAtendidasAscendente() {
		// Aqui se van a listar descendentemente e imprimir los barcos que
		// pasaron por cada anden.
		System.out.println("Listado ascendente de embarcaciones por monto facturado");
		System.out.println("=======================================================");
		//Agregar aca la validacion de si esta vacia la lista.
		descargas.primero();
		Descarga descAux = null;

		while(descargas.getActual().getSiguiente() == null){
			descAux = (Descarga) descargas.getActual().getDato();

			System.out.println("Nombre Barco: " + descAux.getBarcoAtendido().getNombre() + "Carga Facturada: $" + 
					descAux.getBarcoAtendido().getCarga() * precioPorTonelada );
			
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
			.println("Ingrese el Identificador del andén a seleccionar:");
			andenSelecc = seleccionarAnden(sc.nextInt());
		} else {
			System.out
			.println("No hay embarcaciones por descargar en los andenes del puerto");
		}

		try {
			System.out.println("La embarcación a descargar es :"
					+ andenSelecc.getEmbEnAtendimiento().getNombre());
			do {
				System.out
				.println("¿Confirma que quiere realizar la operación?(S/N)");
				conf = sc.next();
			} while (conf.compareToIgnoreCase("S") != 0
					&& conf.compareToIgnoreCase("N") != 0);
			if (andenSelecc == null)
				throw new Exception(
						"El anden seleccionado no existe, intente nuevamente");

			// Creación de una nueva descarga de los barcos atendidos
			descargas.insertar(new Descarga(andenSelecc.getEmbEnAtendimiento(),
					andenSelecc));

			// Liberación del anden
			andenSelecc.setEmbEnAtendimiento(null);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			descargarEmbarcacionesEnAndenes();
		}

	}

	private static void atenderEmbarcacion() {
		Anden andenSelecc = null;
		String conf = null;
		System.out.println("Atendimiento de embarcaciones");
		System.out.println("=======================================");
		System.out.println("Seleccione un andén libre: ");
		if (mostrarAndenesLibres()) {
			System.out
			.println("Ingrese el Identificador del andén a seleccionar:");
			andenSelecc = seleccionarAnden(sc.nextInt());

		} else {
			System.out
			.println("No hay andenes disponibles, intente nuevamente mas tarde");
		}

		try {
			System.out.println("La embarcación a atender es: "
					+ ((Embarcacion) listaEspera.primero()).getNombre());
			
			do {
				System.out
				.println("¿Confirma que quiere realizar la operación?(S/N)");
				conf = sc.next();
			} while (conf.compareToIgnoreCase("S") != 0
					&& conf.compareToIgnoreCase("N") != 0);
			// Asociacion a un anden y quitado de lista de espera
			andenSelecc.setEmbEnAtendimiento(((Embarcacion) listaEspera
					.quitarPrimero()));

			if (andenSelecc == null)
				throw new Exception(
						"El anden seleccionado no existe, intente nuevamente");



		} catch (DesbordamientoInferior e) {
			System.out.println("No hay embarcaciones por atender: "
					+ e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
				System.out.println("Anden Nº" + and.getIdentificador()
						+ "- Nombre:" + and.getNombre());
				cont++;
			}
		}
		return cont > 0;
	}

	private static boolean mostrarAndenesOcupados() {
		int cont = 0;
		for (Anden and : andenes) {
			if (and.getEmbEnAtendimiento() != null) {
				System.out.println("Anden Nº" + and.getIdentificador()
						+ "- Nombre:" + and.getNombre() + "Embarcación: "
						+ and.getEmbEnAtendimiento().getNombre());
				cont++;
			}
		}
		return cont > 0;
	}

	private static void registrarEmbarcacion() {
		Embarcacion nuevaEmbarcacion = new Embarcacion();
		System.out.println("Registro de embarcación");
		System.out.println("=======================");
		System.out.println("Ingrese el nombre de la embarcación");
		nuevaEmbarcacion.setNombre(sc.next());
		System.out.println("Ingrese la carga en la embarcación");
		nuevaEmbarcacion.setCarga(sc.nextDouble());

		// Agregamos la nueva embarcación a la cola de espera

		try {
			listaEspera.insertar(nuevaEmbarcacion);
		} catch (DesbordamientoSuperior e) {
			// TODO Auto-generated catch block
			System.out
			.println("Se ha superado la capacidad de atención del puerto, espere a que se vacie la lista y vuelva a intentar");
		}
	}

	private static void imprimirMenu() {
		System.out.println("Sistema de Puerto");
		System.out.println("=================");
		System.out.println("1- Registrar Embarcación");
		System.out.println("2- Atender Embarcación");
		System.out.println("3- Descargar Embarcación");
		System.out.println("4- Listar Ascendentemente Barcos Atendidos");
		System.out.println("5- Listar Descendentemente Barcos Atendidos");
		System.out.println("6- Salir");

	}

}
