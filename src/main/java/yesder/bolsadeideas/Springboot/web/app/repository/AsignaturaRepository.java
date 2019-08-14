package yesder.bolsadeideas.Springboot.web.app.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import yesder.bolsadeideas.Springboot.web.app.entity.Asignatura;

@Repository
public interface AsignaturaRepository extends CrudRepository<Asignatura, Long>{
	
	
	

}
