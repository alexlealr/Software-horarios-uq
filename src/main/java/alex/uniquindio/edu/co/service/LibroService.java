 package alex.uniquindio.edu.co.service;

import alex.uniquindio.edu.co.entity.Libro;

public interface LibroService {

	public Iterable<Libro> getAllUsers();
	
	public Libro createLibro(Libro asig) throws Exception;
	
	public Libro getLibroById(Long id) throws Exception;

	public Libro updateLibro(Libro asig) throws Exception;
		
	public void deleteLibro(Long id) throws Exception;
	
}
