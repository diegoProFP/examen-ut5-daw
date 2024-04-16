package spotify.aaronalonsoaparicio;

import java.util.ArrayList;
import java.util.List;

//Poner comentario de la clase, con la descripción de qué es lo que hace  
//De autor poned vuestro email de educaMadrid. 
//La version de la clase es la 1.5

/**
 * Clase  que nos define las caracteristicas y las funciones de la Playlist
 *@autor aaronalonsoaparicio
 *@version 1.5 
 *
 */


public class Playlist {

	private String nombre;
	private int totalSegundos;
	private List<Cancion> canciones;

	
	// Poner descripcion, valor de retorno.
	//En los comentarios describir cómo se obtienen los minutos y a partir de qué dato de la clase.
	
	/**
	 * Este metodo nos dice en segundos cuanto dura la Playlist, obtenemos el valor de los valor totalSegundos de la clase
	 * 
	 * @return totalSegundos lo pasamos a minutos y nos devuelve el valor con decimales 
	 */
	public double obtenerDuracionTotal() {
		return (double) totalSegundos / 60;
	}
		
		
		
	// Poner descripcion, parametros de entrada, valor de retorno, y excepción. Además que pueda
	// referenciar tanto a las clases Cancion y DatosInvalidosException
	//Existe desde la version 1.0
	
	/**
	 * Agragamos una nueva cancion la Playlist
	 * @param nueva
	 * @return exito true si la cancion no esta en la Playlist false si si esta.
	 * @throws DatosInvalidosException Lanzamos una excepcion cuando no añadimos una cancion o el nombre de esta esta vacio
	 * @since 1.0
	 * @see #Cancion
	 * @see #DatosInvalidosException
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
	 * Bucamos una cancion segun su nombre
	 * @param nombre
	 * @return encontrado true si se ha encontrado, false si no.
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
	 * Buscamos una cancion en la Playlist
	 * @param nombreCancion
	 * @return encontrado
	 * @deprecated Este metodo ya no se usa, se ha sustituido por {@link #encontrarCancionPorNombre(String)}
	 * @since  1.0
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