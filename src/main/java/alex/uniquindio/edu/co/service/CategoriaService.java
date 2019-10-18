package alex.uniquindio.edu.co.service;

import alex.uniquindio.edu.co.entity.Categoria;

/**
 * Capa de servicios que proporciona operaciones de crud necesarias para la
 * entidad de categoria
 * 
 * @author alexander leal
 *
 */
public interface CategoriaService {

	/**
	 * Permite recorrer todos los datos almacenados en categoria
	 * @return
	 */
	public Iterable<Categoria> getAllUsers();
	
	/**
	 * Permite crear una categoria 
	 * @param asig objeto categoria
	 * @return
	 * @throws Exception
	 */

	public Categoria createCategoria(Categoria asig) throws Exception;

	/**
	 * Permite obtener una categoria por el id
	 * @param id de la categoria
	 * @return
	 * @throws Exception
	 */
	public Categoria getCategoriaById(Long id) throws Exception;

	/**
	 * permite actualizar una categoria
	 * @param asig objeto categoria
	 * @return
	 * @throws Exception
	 */
	public Categoria updateCategoria(Categoria asig) throws Exception;

	/**
	 * Permite eliminar una categoria por su id
	 * @param id de la categoria
	 * @throws Exception
	 */
	public void deleteCategoria(Long id) throws Exception;
}
