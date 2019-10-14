package alex.uniquindio.edu.co.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import alex.uniquindio.edu.co.entity.Libro;
import alex.uniquindio.edu.co.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	public Optional<Usuario> findByCodigo(String codigo);
	public Optional<Usuario> findByUsername(String correo);


}
