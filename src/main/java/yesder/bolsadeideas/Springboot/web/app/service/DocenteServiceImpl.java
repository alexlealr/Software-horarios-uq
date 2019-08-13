package yesder.bolsadeideas.Springboot.web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yesder.bolsadeideas.Springboot.web.app.entity.Docente;
import yesder.bolsadeideas.Springboot.web.app.repository.DocenteRepository;

@Service
public class DocenteServiceImpl implements DocenteService {

	@Autowired
	DocenteRepository repository;
	
	@Override
	public Iterable<Docente> getAllUsers() {
		return repository.findAll();
	}

}
