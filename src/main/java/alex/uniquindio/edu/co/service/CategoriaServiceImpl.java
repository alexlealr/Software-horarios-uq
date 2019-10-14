package alex.uniquindio.edu.co.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alex.uniquindio.edu.co.entity.Categoria;
import alex.uniquindio.edu.co.entity.Libro;
import alex.uniquindio.edu.co.repository.CategoriaRepository;
import alex.uniquindio.edu.co.repository.LibroRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	CategoriaRepository repository;
	
	@Override
	public Iterable<Categoria> getAllUsers() {
		return repository.findAll();
	}

	private boolean checkCodigoExist(Categoria asig) throws Exception {
		Optional<Categoria> asignaturaFound = repository.findByCodigo(asig.getCodigo());
		if (asignaturaFound.isPresent()) {
			throw new Exception("Codigo no disponible");
		}
		return true;	
	}
	
	@Override
	public Categoria createCategoria(Categoria asig) throws Exception {
		if (checkCodigoExist(asig)) {
			asig = repository.save(asig);
		}
		return asig;
	}

	@Override
	public Categoria getCategoriaById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("El libro para editar no existe."));
	}
	
    
	
	@Override
	public Categoria updateCategoria(Categoria fromUser) throws Exception {
		Categoria toAsignatura = getCategoriaById(fromUser.getId());
		mapAsignatura(fromUser, toAsignatura);
		return repository.save(toAsignatura);
	}
	
	/**
	 * Map everythin but the password.
	 * @param from
	 * @param to
	 */
	protected void mapAsignatura(Categoria from,Categoria to) {
		to.setNombre(from.getNombre());
		to.setEdad(from.getEdad());
	}

	@Override
	public void deleteCategoria(Long id) throws Exception {
		Categoria asig = repository.findById(id).orElseThrow(() -> new Exception("Categoria no encontrada -"+this.getClass().getName()));

		repository.delete(asig);
		
	}
	
	

}
