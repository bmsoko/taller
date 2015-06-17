package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Anden;
import model.ColaVector;
import model.DesbordamientoInferior;
import model.DesbordamientoSuperior;
import model.Descarga;
import model.Embarcacion;

public class AppMain {

	/**
	 * @param args
	 */
	
	private static Scanner sc=new Scanner(System.in);
	private static ArrayList<Anden> andenes= new ArrayList<Anden>();
	private static ArrayList<Descarga> descargas=new ArrayList<Descarga>();
	private static ColaVector listaEspera= new ColaVector(500);
	
	public static void main(String[] args) {
		//iniciamos los 3 andenes
		andenes.add(new Anden(001,"Anden1"));
		andenes.add(new Anden(002,"Anden2"));
		andenes.add(new Anden(003,"Anden3"));
		menu();

	}

	private static void menu() {
		int option;
		do
		{
			imprimirMenu();
			option=sc.nextInt();
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
				
				break;
			case 5:
				
				break;
			case 6:
				System.out.println("Trabajo realizado por Bruno Soko y Franco Funes");
				break;

			default:
				System.out.println("Opción Invalida, intente nuevamente");
				break;
			}
			
			
		}
		while (option!=6);
		
	}

	private static void descargarEmbarcacionesEnAndenes() {
		Anden andenSelecc=null;
		String conf=null;
		System.out.println("Descarga de embarcaciones");
		System.out.println("=========================");
		//Mostrar andenes ocupados
		if (mostrarAndenesOcupados())
		{
			System.out.println("Ingrese el Identificador del andén a seleccionar:");
			andenSelecc=seleccionarAnden(sc.nextInt());
		}
		else
		{
			System.out.println("No hay embarcaciones por descargar en los andenes del puerto");
		}
		
		try {
			System.out.println("La embarcación a descargar es :" + andenSelecc.getEmbEnAtendimiento().getNombre();
			do{
				System.out.println("¿Confirma que quiere realizar la operación?(S/N)");
				conf=sc.next();
			}
			while (conf.compareToIgnoreCase("S")!=0 && conf.compareToIgnoreCase("N")!=0); 
			if (andenSelecc==null) throw new Exception("El anden seleccionado no existe, intente nuevamente");
			
			//Creación de una nueva descarga de los barcos atendidos
			descargas.add(new Descarga(andenSelecc.getEmbEnAtendimiento(), andenSelecc));
			
			//Liberación del anden
			andenSelecc.setEmbEnAtendimiento(null);
			
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			descargarEmbarcacionesEnAndenes();
		}	

		
		
	}

	private static void atenderEmbarcacion() {
		//
		Anden andenSelecc=null;
		String conf=null;
		System.out.println("Atendimiento de embarcaciones");
		System.out.println("=======================================");
		System.out.println("Seleccione un andén libre: ");
		if (mostrarAndenesLibres())
			{
				System.out.println("Ingrese el Identificador del andén a seleccionar:");
				andenSelecc=seleccionarAnden(sc.nextInt());
				
			}
		else
		{
			System.out.println("No hay andenes disponibles, intente nuevamente mas tarde");
		}
		
		try {
			System.out.println("La embarcación a atender es: " +((Embarcacion)listaEspera.primero()).getNombre());
			do{
				System.out.println("¿Confirma que quiere realizar la operación?(S/N)");
				conf=sc.next();
			}
			while (conf.compareToIgnoreCase("S")!=0 && conf.compareToIgnoreCase("N")!=0); 
			if (andenSelecc==null) throw new Exception("El anden seleccionado no existe, intente nuevamente");
			
			//Asociacion a un anden y quitado de lista de espera
			andenSelecc.setEmbEnAtendimiento(((Embarcacion)listaEspera.quitarPrimero()));
			
		} catch (DesbordamientoInferior e) {
			// TODO Auto-generated catch block
			System.out.println("No hay embarcaciones por atender: " + e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			atenderEmbarcacion();
		}	
		
	}

	private static Anden seleccionarAnden(int nextInt) {
		for (Anden and : andenes) {
			if (and.getIdentificador()==nextInt)
				return and;
			
		}
		return null;
	}

	private static boolean mostrarAndenesLibres() {
		int cont=0;
		for (Anden and : andenes) {
			if (and.getEmbEnAtendimiento()==null)
			{
				System.out.println("Anden Nº" + and.getIdentificador() + "- Nombre:" + and.getNombre() );
				cont++;
			}
		}
		return cont>0;
	}
	
	private static boolean mostrarAndenesOcupados() {
		int cont=0;
		for (Anden and : andenes) {
			if (and.getEmbEnAtendimiento()!=null)
			{
				System.out.println("Anden Nº" + and.getIdentificador() + "- Nombre:" + and.getNombre() + "Embarcación: " + and.getEmbEnAtendimiento().getNombre());
				cont++;
			}
		}
		return cont>0;
	}

	private static void registrarEmbarcacion() {
		Embarcacion nuevaEmbarcacion=new Embarcacion();
		System.out.println("Registro de embarcación");
		System.out.println("=======================");
		System.out.println("Ingrese el nombre de la embarcación");
		nuevaEmbarcacion.setNombre(sc.next());
		System.out.println("Ingrese la carga en la embarcación");
		nuevaEmbarcacion.setCarga(sc.nextDouble());
		
		//Agregamos la nueva embarcación a la cola de espera
		
		try {
			listaEspera.insertar(nuevaEmbarcacion);
		} catch (DesbordamientoSuperior e) {
			// TODO Auto-generated catch block
			System.out.println("Se ha superado la capacidad de atención del puerto, espere a que se vacie la lista y vuelva a intentar");
		}
	}

	private static void imprimirMenu() {
		System.out.println("Sistema de Puerto");
		System.out.println("=================");
		System.out.println("1- Registrar Embarcación");
		System.out.println("2- Atender Embarcación");
		System.out.println("3- Descargar Embarcación");
		System.out.println("6- Salir");
		
	}

}
