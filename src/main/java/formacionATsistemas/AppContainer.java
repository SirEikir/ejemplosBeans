package formacionATsistemas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppContainer implements IAppContainer {

	@Autowired
	private IPeliculaRepository repo;


	@Autowired
	public AppContainer(IPeliculaRepository repo) {
		this.repo = repo;
	}

	@Autowired
	public void setRepo(IPeliculaRepository repo) {
		this.repo = repo;
	}


	@Override
	public IPeliculaRepository getRepository() {
		return repo;
	}
	
}


class Foo {
	public void foo() {
		AppContainer container = new AppContainer();
		container.setRepo(new PeliculaRepository());
	}
}