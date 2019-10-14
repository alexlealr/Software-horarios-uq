package alex.uniquindio.edu.co.service;

import alex.uniquindio.edu.co.entity.Categoria;

public interface CategoriaService {
	
public Iterable<Categoria> getAllUsers();
	
	public Categoria createCategoria(Categoria asig) throws Exception;
	
	public Categoria getCategoriaById(Long id) throws Exception;

	public Categoria updateCategoria(Categoria asig) throws Exception;
		
	public void deleteCategoria(Long id) throws Exception;
}
