package yesder.bolsadeideas.Springboot.web.app.repository;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import yesder.bolsadeideas.Springboot.web.app.entity.Asignatura;

@Repository
public interface AsignaturaRepository extends CrudRepository<Asignatura, Long>{
	
	
		public Optional<Asignatura> findByCodigo(String codigo);

}
