package alex.uniquindio.edu.co.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alex.uniquindio.edu.co.entity.Libro;
import alex.uniquindio.edu.co.repository.LibroRepository;

/**
 * Clase que implementa los metodos del crud de libro
 * @author alexander leal
 *
 */
@Service
public class LibroServiceImpl implements LibroService {

	/**
	 * Repositorio de libro
	 */
	@Autowired
	LibroRepository repository;
	
	/**
	 * Permite recorrer todos los datos almacenados en libro
	 * @return
	 */
	@Override
	public Iterable<Libro> getAllUsers() {
		return repository.findAll();
	}
    /**
     * verifica si el codigo del libro existe en la base de datos
     * @param asig objeto libro
     * @return
     * @throws Exception
     */
	private boolean checkCodigoExist(Libro asig) throws Exception {
		Optional<Libro> asignaturaFound = repository.findByCodigo(asig.getCodigo());
		if (asignaturaFound.isPresent()) {
			throw new Exception("Codigo no disponible");
		}
		return true;	
	}
	
	/**
	 * Permite crear un libro
	 * @param asig objeto libro
	 * @return
	 * @throws Exception
	 */
	@Override
	public Libro createLibro(Libro asig) throws Exception {
		if (checkCodigoExist(asig)) {
			asig = repository.save(asig);
		}
		return asig;
	}
   
	/**
	 * Permite obtener un libro por el id
	 * @param id del libro
	 * @return
	 * @throws Exception
	 */
	@Override
	public Libro getLibroById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("El libro para editar no existe."));
	}
	
	/**
	 * permite actualizar un libro
	 * @param asig objeto libro
	 * @return
	 * @throws Exception
	 */
	
	@Override
	public Libro updateLibro(Libro fromUser) throws Exception {
		Libro toAsignatura = getLibroById(fromUser.getId());
		mapAsignatura(fromUser, toAsignatura);
		return repository.save(toAsignatura);
	}
	
	/**
	 * Map everythin but the password.
	 * @param from
	 * @param to
	 */
	protected void mapAsignatura(Libro from,Libro to) {
		to.setCodigo(from.getCodigo());
		to.setNombre(from.getNombre());
		to.setDescripcion(from.getDescripcion());
		to.setCateg(from.getCateg());
        to.setImagen(from.getImagen());
	}

	/**
	 * Permite eliminar un libro por su id
	 * @param id del libro
	 * @throws Exception
	 */
	@Override
	public void deleteLibro(Long id) throws Exception {
		Libro asig = repository.findById(id).orElseThrow(() -> new Exception("Asignatura no encontrada -"+this.getClass().getName()));

		repository.delete(asig);
		
	}
	
	
	
}
