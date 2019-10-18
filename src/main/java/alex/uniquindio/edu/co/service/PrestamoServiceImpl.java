package alex.uniquindio.edu.co.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import alex.uniquindio.edu.co.entity.Prestamo;
import alex.uniquindio.edu.co.repository.PrestamoRepository;

/**
 * Clase que implementa los metodos del crud de prestamo
 * @author alexander leal
 *
 */
@Service
public class PrestamoServiceImpl implements PrestamoService{

	
	
	@Autowired
	PrestamoRepository repository;
	
	/**
	 * Permite recorrer todos los datos almacenados en prestamo
	 * 
	 * @return
	 */
	@Override
	public Iterable<Prestamo> getAllUsers() {
		return repository.findAll();
	}
	
 
	/**
	 * Permite crear un prestamo
	 * @param asig objeto prestamo
	 * @return
	 * @throws Exception
	 */
	@Override
	public Prestamo createPrestamo(Prestamo asig) throws Exception {

		asig = repository.save(asig);
		return asig;
	}

	/**
	 * Permite obtener prestamo por el id
	 * @param id del prestamo
	 * @return
	 * @throws Exception
	 */
	@Override
	public Prestamo getPrestamoById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("El prestamo para editar no existe."));
	}

	/**
	 * permite actualizar un prestamo
	 * @param asig objeto prestamo
	 * @return
	 * @throws Exception
	 */
	@Override
	public Prestamo updatePrestamo(Prestamo fromUser) throws Exception {
		Prestamo toUsuario = getPrestamoById(fromUser.getId());
		mapPrestamo(fromUser, toUsuario);
		return repository.save(toUsuario);
	}
	
	protected void mapPrestamo(Prestamo from,Prestamo to) {
		to.setCodigoLibro(from.getCodigoLibro());
		to.setIdenti(from.getIdenti());
		to.setDescripcion(from.getDescripcion());
		to.setEstado(from.getEstado());
		to.setFechaEntrega(from.getFechaEntrega());
        to.setFechaPrestamo(from.getFechaPrestamo());
   
	}

	/**
	 * Permite eliminar un prestado por su id
	 * @param id del prestado
	 * @throws Exception
	 */
	@Override
	public void deletePrestamo(Long id) throws Exception {
		Prestamo asig = repository.findById(id).orElseThrow(() -> new Exception("Prestamo no encontrado -"+this.getClass().getName()));

		repository.delete(asig);
		
	}

}
