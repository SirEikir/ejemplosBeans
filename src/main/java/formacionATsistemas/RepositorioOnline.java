package formacionATsistemas;

import java.util.Collection;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//Omitimos esta clase para que no tenga conflicto a la hora
//@Primary
public class RepositorioOnline implements IPeliculaRepository {

	@Override
	public Collection<Pelicula> obtenerPeliculas() {
		throw new RuntimeException();
	}

	@Override
	public Pelicula buscarPelicula(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
