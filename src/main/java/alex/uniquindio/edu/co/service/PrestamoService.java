package alex.uniquindio.edu.co.service;

import alex.uniquindio.edu.co.entity.Prestamo;

/**
 * Capa de servicios que proporciona operaciones de crud necesarias para la
 * entidad de prestamo
 * 
 * @author alexander leal
 *
 */
public interface PrestamoService {

	/**
	 * Permite recorrer todos los datos almacenados en prestamo
	 * 
	 * @return
	 */
	public Iterable<Prestamo> getAllUsers();

	/**
	 * Permite crear un prestamo
	 * @param asig objeto prestamo
	 * @return
	 * @throws Exception
	 */
	public Prestamo createPrestamo(Prestamo asig) throws Exception;

	/**
	 * Permite obtener prestamo por el id
	 * @param id del prestamo
	 * @return
	 * @throws Exception
	 */
	public Prestamo getPrestamoById(Long id) throws Exception;

	/**
	 * permite actualizar un prestamo
	 * @param asig objeto prestamo
	 * @return
	 * @throws Exception
	 */
	public Prestamo updatePrestamo(Prestamo asig) throws Exception;

	/**
	 * Permite eliminar un prestado por su id
	 * @param id del prestado
	 * @throws Exception
	 */
	public void deletePrestamo(Long id) throws Exception;
}
