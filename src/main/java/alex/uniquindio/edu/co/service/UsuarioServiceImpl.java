package alex.uniquindio.edu.co.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alex.uniquindio.edu.co.entity.Libro;
import alex.uniquindio.edu.co.entity.Usuario;
import alex.uniquindio.edu.co.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{


	@Autowired
	UsuarioRepository repository;
	
	@Override
	public Iterable<Usuario> getAllUsers() {
		return repository.findAll();
	}
	
	private boolean checkCodigoExist(Usuario asig) throws Exception {
		Optional<Usuario> asignaturaFound = repository.findByCodigo(asig.getCodigo());
		if (asignaturaFound.isPresent()) {
			throw new Exception("Codigo no disponible");
		}
		return true;	
	}

	@Override
	public Usuario createUsuario(Usuario asig) throws Exception {
		if (checkCodigoExist(asig)) {
			asig = repository.save(asig);
		}
		return asig;
	}

	@Override
	public Usuario getUsuarioById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("El usuario para editar no existe."));
	}

	@Override
	public Usuario updateUsuario(Usuario fromUser) throws Exception {
		Usuario toUsuario = getUsuarioById(fromUser.getId());
		mapUsuario(fromUser, toUsuario);
		return repository.save(toUsuario);
	}
	
	protected void mapUsuario(Usuario from,Usuario to) {
		to.setCodigo(from.getCodigo());
		to.setNombre(from.getNombre());
		to.setApellido(from.getApellido());
		to.setCorreo(from.getCorreo());
        to.setTelefo(from.getTelefo());
        to.setEdad(from.getEdad());
	}

	@Override
	public void deleteUsuario(Long id) throws Exception {
		Usuario asig = repository.findById(id).orElseThrow(() -> new Exception("Asignatura no encontrada -"+this.getClass().getName()));

		repository.delete(asig);
		
	}

}
