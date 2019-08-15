package yesder.bolsadeideas.Springboot.web.app.service;

import java.util.Optional;

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
		return repository.findAll();
	}

	private boolean checkCodigoExist(Asignatura asig) throws Exception {
		Optional<Asignatura> asignaturaFound = repository.findByCodigo(asig.getCodigo());
		if (asignaturaFound.isPresent()) {
			throw new Exception("Codigo no disponible");
		}
		return true;	
	}
	
	@Override
	public Asignatura createAsignatura(Asignatura asig) throws Exception {
		if (checkCodigoExist(asig)) {
			asig = repository.save(asig);
		}
		return asig;
	}

	@Override
	public Asignatura getAsignaturaByCod(String cod) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Asignatura updateAsignatura(Asignatura asig) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
    /**
	@Override
	public Asignatura getAsignaturaByCod(String cod) throws Exception {
		return repository.findByCodigo(cod).orElseThrow(() -> new Exception("El usuario para editar no existe."));
	}
	
	@Override
	public Asignatura updateAsignatura(Asignatura fromUser) throws Exception {
		Asignatura toAsignatura = getAsignaturaByCod(fromUser.getCodigo());
		mapAsignatura(fromUser, toAsignatura);
		return repository.save(toAsignatura);
	}
	
	/**
	 * Map everythin but the password.
	 * @param from
	 * @param to
	 */
	
	
	
}
