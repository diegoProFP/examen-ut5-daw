package sergiopaniaguavega;

import java.util.ArrayList;
import java.util.List;

//Poner comentario de la clase, con la descripción de qué es lo que hace  
//De autor poned vuestro email de educaMadrid. 
//La version de la clase es la 1.5

/**
 * Esta clase es una playlist en la que añadir canciones a una lista y encontrar canciones en ella buscando por su nombre.
 * @author sergio.paniaguavega@educamadrid.org
 * @version 1.5
 */

public class Playlist {

	private String nombre;
	private int totalSegundos;
	private List<Cancion> canciones;

	
	// Poner descripcion, valor de retorno.
	//En los comentarios describir cómo se obtienen los minutos y a partir de qué dato de la clase.
	
	
	/**
	 * Esta funcion sirve para obtener la duracion total de la playlist en minutos dividiendo el total de segundos entre 60.
	 * @return Devuelve el total de minutos en formato de double a partir de los segundos totales.
	 * @see #totalSegundos
	 */
	
	public double obtenerDuracionTotal() {
		return (double) totalSegundos / 60;
	}
		
		
		
	// Poner descripcion, parametros de entrada, valor de retorno, y excepción. Además que pueda
	// referenciar tanto a las clases Cancion y DatosInvalidosException
	//Existe desde la version 1.0
	
	
	
	/**
	 * Esta funcion agrega una Cancion nueva a la Playlist, comprobando si existe la lista y si el elemento canción no está vacío. 
	 * @param nueva Es la cancion que se quiere agregar a la playlist.
	 * @return Devuelve si ha tenido exito al añadir la cancion o no, en forma de booleano.
	 * @throws DatosInvalidosException Lanza esta excepcion en caso de que la Cancion introducida este vacia o que no tenga ningun nombre.
	 * @see Cancion
	 * @see DatosInvalidosException
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
	 * Esta funcion sirve para encontrar una cancion de la playlist buscando a traves de su nombre.
	 * @param nombre El nombre de la cancion que el usuario desea encontrar.
	 * @return Devuelve si ha encontrado o no la cancion, en forma de booleano. 
	 * @since 1.5
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
	 * Esta funcion sirve para encontrar una cancion en la playlist a partir de un nombre.
	 * @param nombreCancion El nombre de la cancion que se quiere encontrar.
	 * @return Devuelve si ha encontrado la cancion buscada o no, en forma de booleano.
	 * @since 1.0
	 * @deprecated Desde la version 1.5, se debe utilizar la funcion mas optima: {@link #encontrarCancionPorNombre(String)}
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