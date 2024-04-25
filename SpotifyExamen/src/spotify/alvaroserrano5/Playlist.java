package spotify.alvaroserrano5;

/**
 * @author alvaro.serrano5
 * @version 1.5
 * la clase describe la clase playlist con metodos como el de obtener la duracion de una cancion en minutos o agregar canciones
 */

import java.util.ArrayList;
import java.util.List;

//Poner comentario de la clase, con la descripción de qué es lo que hace  
//De autor poned vuestro email de educaMadrid. 
//La version de la clase es la 1.5

public class Playlist {

	private String nombre;
	private int totalSegundos;
	private List<Cancion> canciones;

	
	// Poner descripcion, valor de retorno.
	//En los comentarios describir cómo se obtienen los minutos y a partir de qué dato de la clase.
	
	/**
	 * 
	 * @return el la duracion total de una cancion en minutos
	 * con este metodo usamos el total en segundos y lo dividimos entre 60 para que te de los minutos
	 */
	
	public double obtenerDuracionTotal() {
		return (double) totalSegundos / 60;
	}
		
		
		
	// Poner descripcion, parametros de entrada, valor de retorno, y excepción. Además que pueda
	// referenciar tanto a las clases Cancion y DatosInvalidosException
	//Existe desde la version 1.0
	
	/**
	 * este es un metodo en el que se hace el proceso de añadir una cancion a la playlist
	 * 
	 * @param nueva nombre dado a la cancion que a sido añadida recientemente
	 * 
	 * @return si a tenido exito el proceso de añadir una cancion en la playlist
	 * 
	 * @see {@link #Cancion}
	 * @see {@link #DatosInvalidosException}
	 * 
	 * @since 1.0
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
	 * es un metodo en el que compara que el nombre de la cancion obtenida en cada vuelta es igual a la que se quiere
	 * 
	 * @param nombre el nombre de la cancion
	 * 
	 * @since 1.5
	 * 
	 * @return devuelve si a encontrado la cancion obtenida con la que se quiere
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
	 * es un metodo en el que compara que el nombre de la cancion obtenida en cada vuelta es igual a la que se quiere
	 * 
	 * @param nombreCancion el nombre de la cancion
	 * 
	 * @deprecated metodo obsoleto para encontrar una cancion {@link #encontrarCancionPorNombre(String)}
	 * 
	 * @since 1.0
	 * 
	 * @return devuelve si a encontrado la cancion obtenida con la que se quiere
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