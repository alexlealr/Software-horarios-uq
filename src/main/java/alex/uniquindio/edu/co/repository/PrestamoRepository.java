package alex.uniquindio.edu.co.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import alex.uniquindio.edu.co.entity.Prestamo;

/**
 * Interfaz que propporciona operaciones basicas de un crud para la
 * entidad de prestamo
 * @author alexander leal
 *
 */
@Repository
public interface PrestamoRepository extends CrudRepository<Prestamo, Long>{
	


}
