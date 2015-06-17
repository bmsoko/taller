package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Alumno;
import model.DesbordamientoSuperior;
import model.Materia;

public class Application {

	/**
	 * @param args
	 */
	public static ArrayList<Materia> materias=new ArrayList<Materia>();
	public static ArrayList<Alumno> alumnos=new ArrayList<Alumno>();
	public static Scanner sc= new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	    menu();
	
	}
	
	public static void menu()
	{   
		boolean flags=true;
		int option;
		do
		{
			imprimirMenu();
			option=sc.nextInt();
			
			switch (option)
			{
				case 1:
					crearAlumno();
					break;
				case 2:
					crearMateria();
					break;
				case 3:
					asociarMateriaAlumno();
					break;
				case 4:
					listarAlumnosConMaterias();
					break;
				case 5:
					flags=false;
					break;
			}
			
		}
		while(flags);
		
		
	}

	private static void listarAlumnosConMaterias() {
		// TODO Auto-generated method stub
		
	}

	private static void asociarMateriaAlumno() {
		// TODO Auto-generated method stub
		Alumno alu;
		Materia mat;
		//Mostrar Alumnos
		alu=buscarEnAlumnoCargados();
		
		//Mostrar Materias
		mat=buscarEnMateriasCargadas();
		
		try {
			alu.getMaterias().insertar(mat);
		} catch (DesbordamientoSuperior e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}

	private static Materia buscarEnMateriasCargadas() {
		// TODO Auto-generated method stub
		
		Materia mat;
		int cod;
		for (Materia aux : materias) {
			System.out.println(aux);
			
		}
		System.out.println("Ingrese el codigo de la materia a seleccionar:");
		cod=sc.nextInt();
		
		mat=buscarMateriaPorCod(cod);
		
		return mat;
	}

	private static Materia buscarMateriaPorCod(int cod) {
		// TODO Auto-generated method stub
		Materia mat1=null;
		for (Materia ele : materias) {
			if (ele.getCodigo()==cod)
						mat1=ele;
		}
		
		return mat1;
	}

	private static Alumno buscarEnAlumnoCargados() {
		// TODO Auto-generated method stub
		Alumno alu;
		int dni;
		for (Alumno aux : alumnos) {
			System.out.println(aux);
			
		}
		System.out.println("Ingrese el dni del alumno a seleccionar:");
		dni=sc.nextInt();
		
		alu=buscarAlumnoPorDNI(dni);
		
		return alu;
	}

	private static Alumno buscarAlumnoPorDNI(int dni) {
		// TODO Auto-generated method stub
		Alumno alu1=null;
		for (Alumno ele : alumnos) {
			if (ele.getDni()==dni)
						alu1=ele;
		}
		
		return alu1;
	}

	private static void crearMateria() {
		// TODO Auto-generated method stub
		int codigo,semestre;
		String denominacion;
		Materia mat;
		
		System.out.println("Ingrese el codigo de la materia:");
		codigo=sc.nextInt();
		System.out.println("Ingrese la denominación: ");
		denominacion=sc.next();
		System.out.println("Ingrese el semestre de la materia");
		semestre=sc.nextInt();
		
		mat= new Materia(codigo, denominacion, semestre);
		
		materias.add(mat);
		
		
		
	}

	private static void crearAlumno() {
		// TODO Auto-generated method stub
		String apellido = null,nombre = null,legajo = null;
		int dni = 0;
		Alumno alu;
		try{
		System.out.println("Ingrese el nombre del alumno: ");
		nombre=sc.next();
		System.out.println("Ingrese el apellido del alumno: ");
		apellido=sc.next();
		System.out.println("Ingrese el dni: ");
		dni=sc.nextInt();
		System.out.println("Ingrese el legajo: ");
		legajo=sc.next();
		}
		catch (InputMismatchException Ex)
		{
			System.out.println("verifique los datos ingresados");
			crearAlumno();
		}
		alu= new Alumno(nombre, apellido, dni, legajo);
		
		alumnos.add(alu);
		
		System.out.println(alu);
	}

	private static void imprimirMenu() {
		
		//Pintar menu
		System.out.println("1-Ingresar Alumno");
		System.out.println("2-Ingresar Materia");
		System.out.println("3-Asociar Materia a Alumno");
		System.out.println("4-Listar Alumnos con sus Materias");
		System.out.println("5-Salir");
		System.out.println("Ingrese una opción:");
		
	}

}
