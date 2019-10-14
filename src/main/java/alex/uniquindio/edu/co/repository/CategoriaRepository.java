package alex.uniquindio.edu.co.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import alex.uniquindio.edu.co.entity.Categoria;




@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
	public Optional<Categoria> findByCodigo(String codigo);
}
	