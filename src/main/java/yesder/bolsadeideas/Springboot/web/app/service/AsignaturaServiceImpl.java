package yesder.bolsadeideas.Springboot.web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yesder.bolsadeideas.Springboot.web.app.entity.Asignatura;
import yesder.bolsadeideas.Springboot.web.app.repository.AsignaturaRepository;
import yesder.bolsadeideas.Springboot.web.app.repository.DocenteRepository;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

	@Autowired
	AsignaturaRepository repository;
	
	@Override
	public Iterable<Asignatura> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
