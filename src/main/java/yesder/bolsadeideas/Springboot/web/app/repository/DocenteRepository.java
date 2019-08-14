package yesder.bolsadeideas.Springboot.web.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import yesder.bolsadeideas.Springboot.web.app.entity.Docente;

@Repository
public interface DocenteRepository extends CrudRepository<Docente, Long> {

}
	