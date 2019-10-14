package alex.uniquindio.edu.co.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import alex.uniquindio.edu.co.entity.Prestamo;


@Repository
public interface PrestamoRepository extends CrudRepository<Prestamo, Long>{
	


}
