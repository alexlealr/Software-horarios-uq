package alex.uniquindio.edu.co.service;

import alex.uniquindio.edu.co.entity.Usuario;

public interface UsuarioService {
	
	
public Iterable<Usuario> getAllUsers();
	
	public Usuario createUsuario(Usuario asig) throws Exception;
	
	public Usuario getUsuarioById(Long id) throws Exception;

	public Usuario updateUsuario(Usuario asig) throws Exception;
		
	public void deleteUsuario(Long id) throws Exception;

}
