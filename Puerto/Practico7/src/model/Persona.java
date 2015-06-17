package model;

public abstract class Persona {
	private String nombre;
	private String apellido;
	private int dni;
	
	
	
	public Persona() {
		super();
	}
	public Persona(String nombre, String apellido, int dni) {
		super();
		try{
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDni(dni);
		}
		catch (MiExcepcion ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) throws MiExcepcion {
		if (!Validacion.verificarString(nombre))
		{ throw new MiExcepcion("El nombre debe ser una cadena de caracteres");}
		
		if (!Validacion.verificarVacio(nombre))
		{ throw new MiExcepcion("El nombre no puede ser vacio");}
		
		
		if (Validacion.verificarNoNulo(nombre))
		{ throw new MiExcepcion("El nombre no puede ser nulo");
			
		}
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) throws MiExcepcion {
		if (!Validacion.verificarString(apellido))
		{ throw new MiExcepcion("El apellido debe ser una cadena de caracteres");}
		
		if (Validacion.verificarNoNulo(apellido))
		{ throw new MiExcepcion("El apellido no puede ser nulo");}
		
		if (!Validacion.verificarVacio(apellido))
		{ throw new MiExcepcion("El apellido no puede ser vacio");}
		
		
		this.apellido = apellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) throws MiExcepcion {
		
		if (!Validacion.verificarInt(dni))
		{ throw new MiExcepcion("El dni debe ser numérico");}
		
		if (Validacion.verificarNoNulo(dni))
		{ throw new MiExcepcion("El dni no puede ser nulo");}
		this.dni = dni;
	}
	

}
