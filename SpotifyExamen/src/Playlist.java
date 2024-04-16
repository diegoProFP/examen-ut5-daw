

import java.util.ArrayList;
import java.util.List;

//Poner comentario de la clase, con la descripción de qué es lo que hace  
//De autor poned vuestro email de educaMadrid. 
//La version de la clase es la 1.5
/**
 * @author ivanpencef
 * @version 1.5
 * La clase contiene una lista de canciones de las cuales contiene datos tales como nombre y duracion
 */
public class Playlist {

	private String nombre;
	private int totalSegundos;
	private List<Cancion> canciones;

	
	// Poner descripcion, valor de retorno.
	//En los comentarios describir cómo se obtienen los minutos y a partir de qué dato de la clase.
	
	/**
	 * Metodo para obtener el total de segundos de duracion
	 * @return totalSegundos esta variable contiene los segundos, el metodo nos devuelve un double con la duracion total
	 */
	public double obtenerDuracionTotal() {
		return (double) totalSegundos / 60;
	}
		
		
		
	// Poner descripcion, parametros de entrada, valor de retorno, y excepción. Además que pueda
	// referenciar tanto a las clases Cancion y DatosInvalidosException
	//Existe desde la version 1.0
	
	/**
	 * 
	 * @param nueva Recibe este parametro  
	 * @return Nos devuelve true o false segun si agregamos la cancion con exito o no
	 * @throws DatosInvalidosException Captura la excepcion si los datos son incorrectos
	 * Esta desde la @version 1.0
	 */
	public boolean agregarCancion(Cancion nueva) throws DatosInvalidosException {

		boolean exito = false;
		if (canciones == null) {
			this.canciones = new ArrayList<>();
		}
		if (nueva == null || nueva.getNombre() == null) {
			throw new DatosInvalidosException("La cancion o su nombre es vacía");
		}

		boolean existeCancion = this.encontrarCancionPorNombre(nueva.getNombre());
		if (!existeCancion) {
			exito = canciones.add(nueva);
		}

		return exito;
	}


	
	// Poner descripcion, parametros de entrada, valor de retorno.
	//Existe desde la version 1.5
	
	/**
	 * El metodo sirve para buscar canciones por su nombre
	 * @param nombre Este es el parametro que se recibe para hacer la busqueda
	 * @return Devuelve true si la busqueda tuvo exito o false en caso contrario, esta desde la @version 1.5
	 */
	public boolean encontrarCancionPorNombre(String nombre) {
		boolean encontrado = false;
		int contador = 0;
		while (!encontrado && contador < canciones.size()) {

			// Si el nombre de la cancion obtenida en cada vuelta es igual a la que se
			// quiere
			if (canciones.get(contador).getNombre().equalsIgnoreCase(nombre)) {
				encontrado = true;
			}

			contador++;
		}

		return encontrado;
	}
	
	// Este metodo está deprecado porque se ha hecho uno mejor, y el que lo sustituye es el
	// encontrarCancionPorNombre(String nombre)
	//Existe desde la version 1.0
	
	/**
	 * 
	 * @param nombreCancion Dato de entrada con el cual se hace la busqueda
	 * @return Devuelve true si la busqueda tuvo exito y false si esta no lo tuvo.
	 * @deprecated Este metodo existe desde la @version 1.0, esta obsoleto y se ha creado uno mejor, deberia dejar de usarse
	 * @see encontrarCancionPorNombre(String nombre) 
	 * 
	 */
	public boolean encontrarCancion(String nombreCancion) {
		boolean encontrado = false;

		for (int cont = 0; cont < canciones.size(); cont++) {
			Cancion cancionExtraida = this.canciones.get(cont);
			if (cancionExtraida.getNombre().equals(nombreCancion)) {
				encontrado = true;
				break;
			}
			
		}
		return encontrado;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTotalSegundos() {
		return totalSegundos;
	}

	public void setTotalSegundos(int totalSegundos) {
		this.totalSegundos = totalSegundos;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}
}