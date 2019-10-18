package alex.uniquindio.edu.co.service;

import alex.uniquindio.edu.co.entity.Usuario;

/**
 * Capa de servicios que proporciona operaciones de crud necesarias para la
 * entidad de usuario
 * 
 * @author alexander leal
 *
 */
public interface UsuarioService {


	/**
	 * Permite recorrer todos los datos almacenados en usuario
	 * @return
	 */
	public Iterable<Usuario> getAllUsers();

	/**
	 * Permite crear un usuario
	 * param asig objeto usuario
	 * @return
	 * @throws Exception
	 */
	public Usuario createUsuario(Usuario asig) throws Exception;

	/**
	 * Permite obtener un usuario por el id
	 * @param id del usuario
	 * @return
	 * @throws Exception
	 */
	public Usuario getUsuarioById(Long id) throws Exception;

	/**
	 * permite actualizar un usuario
	 * @param asig objeto usuario
	 * @return
	 * @throws Exception
	 */
	public Usuario updateUsuario(Usuario asig) throws Exception;
 

	/**
	 * Permite eliminar una usuario por su id
	 * @param id del usuario
	 * @throws Exception
	 */
	public void deleteUsuario(Long id) throws Exception;

}
