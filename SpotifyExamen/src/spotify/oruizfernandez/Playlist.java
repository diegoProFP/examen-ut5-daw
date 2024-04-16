package spotify.oruizfernandez;

import java.util.ArrayList;
import java.util.List;
/**
 * @version 1.5
 * @author oruizfernandez@educa.madrid.org
 * Esta clase simula spotify la cual te devuelve los segundos que dura una cación permite añadir canciones a la playlist y buscar canciones.
 */

public class Playlist {

	private String nombre;
	private int totalSegundos;
	private List<Cancion> canciones;

	/**
	 * devuelve cuanto dura la cancion en minutos a partir de totalsegundos y diviendolo entre 60
	 * @return totalsegundos 
	 * devuelve el numero total de minutos que dura la cancion.
	 */
	
	public double obtenerDuracionTotal() {
		return (double) totalSegundos / 60;
	}
		
		/**
		 * @param nueva
		 * @return añade la cancion a la playlist
		 * @throws DatosInvalidosException
		 * @since 1.0
		 * @see {@link #Cancion}
		 * @see {@link #DatosInvalidosException}
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
	 * @since 1.5
	 * @param nombre nombre de la cancion
	 * @return devuelve la cancion buscada
	 * Este metodo es la version mejorada del metodo {@Link #encontrarCancion(String)}
	 */
	// Poner descripcion, parametros de entrada, valor de retorno.
	
	public boolean encontrarCancionPorNombre(String nombre) {
		boolean encontrado = false;
		int contador = 0;
		while (!encontrado && contador < canciones.size()) {


			if (canciones.get(contador).getNombre().equalsIgnoreCase(nombre)) {
				encontrado = true;
			}

			contador++;
		}

		return encontrado;
	}
	/**
	 * @since 1.0
	 * @deprecated este metodo esta obsoleto y lo sustituye el metodo {@link #encontrarCancionPorNombre(String)}
	 * @param nombreCancion nombvre de la cacion
	 * @return devuelve la cancion buscada
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