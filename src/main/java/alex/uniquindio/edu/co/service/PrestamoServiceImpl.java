package alex.uniquindio.edu.co.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alex.uniquindio.edu.co.entity.Prestamo;
import alex.uniquindio.edu.co.entity.Usuario;
import alex.uniquindio.edu.co.repository.PrestamoRepository;

@Service
public class PrestamoServiceImpl implements PrestamoService{

	
	
	@Autowired
	PrestamoRepository repository;
	
	@Override
	public Iterable<Prestamo> getAllUsers() {
		return repository.findAll();
	}
	


	@Override
	public Prestamo createPrestamo(Prestamo asig) throws Exception {

		asig = repository.save(asig);
		return asig;
	}

	@Override
	public Prestamo getPrestamoById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("El usuario para editar no existe."));
	}

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

	@Override
	public void deletePrestamo(Long id) throws Exception {
		Prestamo asig = repository.findById(id).orElseThrow(() -> new Exception("Prestamo no encontrado -"+this.getClass().getName()));

		repository.delete(asig);
		
	}

}
