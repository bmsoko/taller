package model;

public class Validacion {
	
	public static boolean verificarNoNulo(Object param)
	{
		if (param==null)
			{
				return true;
			}
		
	return false;
	}
	
	public static boolean verificarString(Object param)
	{
		if (param instanceof String )
		{
			return true;
		}
		
		return false;
	}
	
	public static boolean verificarVacio(Object param)
	{
		if ((((String)param).trim()).length() == 0 )
		{
			return false;
		}
		
		return true;
	}
	
	public static boolean verificarInt(Object param)
	{
		if (param instanceof Integer)
		{
			return true;
		}
		
		return false;
	}

}
