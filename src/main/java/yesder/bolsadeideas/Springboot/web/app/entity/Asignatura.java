package yesder.bolsadeideas.Springboot.web.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
@Entity
@Table(name = "asignaturas")
public class Asignatura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String codigo;
	@NotEmpty
	private String nombre;
	@NotEmpty
	private int numCreditos;
	@NotEmpty
	private int numHorasSemestre;
	@NotEmpty
	private int codRequisito;
	@NotEmpty
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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;
}
