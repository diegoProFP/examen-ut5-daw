package spotify.irenegonzalez126;

import java.util.ArrayList;
import java.util.List;
/**
 * @author irene.gonzalez162@educa.madrid.org 
 * @version 1.5
 */

public class Playlist {

	private String nombre;
	private int totalSegundos;
	private List<Cancion> canciones;

	
	/**
	 * Este método devuelve la duración de la playlist 
	 * @return los segundos de duración 
	 */
	//En los comentarios describir cómo se obtienen los minutos y a partir de qué dato de la clase.
	public double obtenerDuracionTotal() {
		return (double) totalSegundos / 60;
	}
		
	/**
	 * Es un método para ñadir canciones a la playlist 	
	 * @param nueva
	 * @return un boleean exito 
	 * @throws DatosInvalidosException
	 * @since 1.0 
	 * {@link DatosInvaludosException}
	 * {@link Cancion}
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

  /**
   * Este método realiza la búsqueda de una canción en la playlist 
   * @param nombre
   * @return  boolean encontrado
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
	
	/**
	 * 
	 * @param nombreCancion
	 * @return
	 * @deprecated Se ha realizado una versión mejorada de este metodo 
	 * @see encontrarCancionPorNombre(String nombre)
	 * @since 1.0
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