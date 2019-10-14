package alex.uniquindio.edu.co.service;

import alex.uniquindio.edu.co.entity.Prestamo;

public interface PrestamoService {

	
	
public Iterable<Prestamo> getAllUsers();
	
	public Prestamo createPrestamo(Prestamo asig) throws Exception;
	
	public Prestamo getPrestamoById(Long id) throws Exception;

	public Prestamo updatePrestamo(Prestamo asig) throws Exception;
		
	public void deletePrestamo(Long id) throws Exception;
}
