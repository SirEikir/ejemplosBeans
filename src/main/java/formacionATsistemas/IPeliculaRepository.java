package formacionATsistemas;

import java.util.Collection;

public interface IPeliculaRepository {
	
	Collection<Pelicula> obtenerPeliculas();
		
	Pelicula buscarPelicula(Integer id);
	

}
