package spotify.idel2;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una lista de reproducción de canciones.
 * Permite gestionar el nombre de la lista, la duración total en minutos
 * y las canciones que contiene.
 * Autor: tuemail@educaMadrid
 * Version: 1.5
 */
public class Playlist {

    private String nombre;
    private int totalSegundos;
    private List<Cancion> canciones;

    /**
     * Calcula la duración total de la lista de reproducción en minutos.
     * La duración se obtiene dividiendo el total de segundos entre 60.
     *
     * @return La duración total en minutos.
     */
    public double obtenerDuracionTotal() {
        return (double) totalSegundos / 60;
    }

    /**
     * Agrega una nueva canción a la lista de reproducción.
     *
     * @param nueva La canción que se va a agregar.
     * @return true si la canción se agrega con éxito, false si la canción ya existe en la lista.
     * @throws DatosInvalidosException si la canción o su nombre es nulo.
     */
    public boolean agregarCancion(Cancion nueva) throws DatosInvalidosException {
        boolean exito = false;
        if (canciones == null) {
            this.canciones = new ArrayList<>();
        }
        if (nueva == null || nueva.getNombre() == null) {
            throw new DatosInvalidosException("La canción o su nombre es vacío");
        }
        boolean existeCancion = this.encontrarCancionPorNombre(nueva.getNombre());
        if (!existeCancion) {
            exito = canciones.add(nueva);
        }
        return exito;
    }

    /**
     * Busca una canción en la lista de reproducción por su nombre.
     *
     * @param nombre El nombre de la canción que se desea buscar.
     * @return true si la canción se encuentra en la lista, false en caso contrario.
     */
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
     * Este método está deprecado porque se ha implementado uno mejor: encontrarCancionPorNombre(String nombre).
     * @param nombreCancion El nombre de la canción que se desea buscar.
     * @return true si la canción se encuentra en la lista, false en caso contrario.
     * @deprecated Este método está deprecado y se recomienda utilizar encontrarCancionPorNombre(String nombre).
     */
    @Deprecated
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
