package spotify.spm086;

import java.util.ArrayList;
import java.util.List;

//Poner comentario de la clase, con la descripción de qué es lo que hace  
//De autor poned vuestro email de educaMadrid. 
//La version de la clase es la 1.5


/**
 * @author Sonia Perez
 * @version 1.0
 */

public class Playlist {

	private String nombre;
	private int totalSegundos;
	private List<Cancion> canciones;

	
	/**
	 * 
	 * @return Aqui devuelve el Total de segundos 
	 * Es un metodo donde la variable totaldesegundos se divide entre 60 para saber la duracion total
	 * 
	 */
	// Poner descripcion, valor de retorno.
	//En los comentarios describir cómo se obtienen los minutos y a partir de qué dato de la clase.
	public double obtenerDuracionTotal() {
		return (double) totalSegundos / 60;
	}
		
		
		/**
		 * 
		 * @param Aqui tenemos un metodo booleano donde te dice si la cancion esat o no esta ya en el ArrayList. El parametro nueva es de la clase Cancion
		 * @return Devuelve si existev ya la cancion un false
		 * @throws DatosInvalidosException
		 */
	// Poner descripcion, parametros de entrada, valor de retorno, y excepción. Además que pueda
	// referenciar tanto a las clases Cancion y DatosInvalidosException
	//Existe desde la version 1.0
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
	 * 
	 * @param nombre es un String y te dice como se llama la cancion. Este metodo encuentra la cancion por su nombre
	 * @return Te devuekve la cacnion encontrada
	 */
	// Poner descripcion, parametros de entrada, valor de retorno.
	//Existe desde la version 1.5
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
	 * @param nombreCancion Es un String y te dice su nombre
	 * @return Te devolvia su nombre pero ya tiene una version mejor
	 * @deprecated Tiene una nueva funcionalidad mejor y mas actualizada 
	 * 
	 */
	// Este metodo está deprecado porque se ha hecho uno mejor, y el que lo sustituye es el
	// encontrarCancionPorNombre(String nombre)
	//Existe desde la version 1.0
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