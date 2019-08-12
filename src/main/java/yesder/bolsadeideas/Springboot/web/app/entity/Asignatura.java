package yesder.bolsadeideas.Springboot.web.app.entity;

public class Asignatura {

	
	private String codigo;
	private String nombre;
	private int numCreditos;
	private int numHorasSemestre;
	private int codRequisito;
	private int semestre;
	
	
	
	public Asignatura() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumCreditos() {
		return numCreditos;
	}
	public void setNumCreditos(int numCreditos) {
		this.numCreditos = numCreditos;
	}
	public int getNumHorasSemestre() {
		return numHorasSemestre;
	}
	public void setNumHorasSemestre(int numHorasSemestre) {
		this.numHorasSemestre = numHorasSemestre;
	}
	public int getCodRequisito() {
		return codRequisito;
	}
	public void setCodRequisito(int codRequisito) {
		this.codRequisito = codRequisito;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	
	
}
