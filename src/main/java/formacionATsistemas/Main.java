package formacionATsistemas;

import java.nio.file.DirectoryStream.Filter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		IAppContainer appContainer = context.getBean(IAppContainer.class);
		IPeliculaRepository peliculaRepository = appContainer.getRepository();
		
		//Ejercicio1 
		//Comprobar si existe alguna pelicula de Accion
		boolean pelisAccion = peliculaRepository.obtenerPeliculas().stream()
			.filter(pelicula -> pelicula.getGenero().equals("Accion"))
			.findAny().isPresent();
		
		System.out.println("Ejercicio 1: ¿Hay películas de acción? " + pelisAccion);
		
		//Ejercicio 2 
		//Contar peliculas del siglo pasado
		long countPelisOld = peliculaRepository.obtenerPeliculas().stream()
				.filter(pelicula -> pelicula.getFechaEstreno() < 2001).count();
		
		System.out.println("Ejercicio 2 :  Cuantas peliculas se han estrenado el siglo pasado? "
							+ countPelisOld);
		
		//Ejercicio 3 
		//Obtener el listado de titulos de peliculas
		List<String> tituloPeliculas = peliculaRepository.obtenerPeliculas().stream()
					.map(pelicula -> pelicula.getTitulo()).collect(Collectors.toList());
		
		System.out.println("Ejercicio 3 : Listado de peliculas : ");
		//String. join coge cada parametro y lo añade por el separador de la lista indicada
		System.out.println(String.join(", ", tituloPeliculas));
		
		//Ejercicio 4
		//Obtener el listado de peliculas del siglo pasado ordenadas por titulo
		List<Pelicula> listadoPeliculas = peliculaRepository.obtenerPeliculas().stream()
				.filter(pelicula -> pelicula.getFechaEstreno() < 2001)
				.sorted(Comparator.comparing(Pelicula::getFechaEstreno))
				.collect(Collectors.toList());
		
		System.out.println("Ejercicio 4 : Listado de peliculas del siglo pasado ordenadas por titulo ");
		for (Pelicula p : listadoPeliculas) {
			System.out.println(p);
		}
		
	
		


	}

}
