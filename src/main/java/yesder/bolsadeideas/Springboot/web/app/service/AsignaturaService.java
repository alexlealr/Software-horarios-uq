 package yesder.bolsadeideas.Springboot.web.app.service;

import yesder.bolsadeideas.Springboot.web.app.entity.Asignatura;

public interface AsignaturaService {

	public Iterable<Asignatura> getAllUsers();
	
	public Asignatura createAsignatura(Asignatura asig) throws Exception;
	
	public Asignatura getAsignaturaByCod(String cod) throws Exception;

	public Asignatura updateAsignatura(Asignatura asig) throws Exception;
		
	
}
