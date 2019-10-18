 package alex.uniquindio.edu.co.service;

import alex.uniquindio.edu.co.entity.Libro;

/**
 * Capa de servicios que proporciona operaciones de crud necesarias para la
 * entidad de libro
 * 
 * @author alexander leal
 *
 */
public interface LibroService {
	/**
	 * Permite recorrer todos los datos almacenados en libro
	 * @return
	 */
	public Iterable<Libro> getAllUsers();
	
	/**
	 * Permite crear un libro
	 * @param asig objeto libro
	 * @return
	 * @throws Exception
	 */
	public Libro createLibro(Libro asig) throws Exception;
	
	/**
	 * Permite obtener un libro por el id
	 * @param id del libro
	 * @return
	 * @throws Exception
	 */
	public Libro getLibroById(Long id) throws Exception;

	/**
	 * permite actualizar un libro
	 * @param asig objeto libro
	 * @return
	 * @throws Exception
	 */
	public Libro updateLibro(Libro asig) throws Exception;

	/**
	 * Permite eliminar un libro por su id
	 * @param id del libro
	 * @throws Exception
	 */
	public void deleteLibro(Long id) throws Exception;
	
}
