package alex.uniquindio.edu.co.repository;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import alex.uniquindio.edu.co.entity.Libro;

@Repository
public interface LibroRepository extends CrudRepository<Libro, Long>{
	
		public Optional<Libro> findByCodigo(String codigo);

}
