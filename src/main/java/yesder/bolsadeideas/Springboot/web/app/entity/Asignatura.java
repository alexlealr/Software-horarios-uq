package yesder.bolsadeideas.Springboot.web.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Asignatura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7684570809035513741L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy="native")
	private Long id;
	
	@Column
	@NotBlank
	private String codigo;
	@Column
	@NotBlank
	private String nombre;
	@Column
	@NotBlank
	private int nivel;
	@Column
	@NotBlank
	private int tipoAsign;
	@Column
	@NotBlank
	private int unidades;
	@Column
	@NotBlank
	private String activa;
	@Column
	@NotBlank
	private int opcionGrado;
	@Column
	@NotBlank
	private int tipoAct;
	
	
	
	public Asignatura() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public int getTipoAsign() {
		return tipoAsign;
	}
	public void setTipoAsign(int tipoAsign) {
		this.tipoAsign = tipoAsign;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public String getActiva() {
		return activa;
	}
	public void setActiva(String activa) {
		this.activa = activa;
	}
	public int getOpcionGrado() {
		return opcionGrado;
	}
	public void setOpcionGrado(int opcionGrado) {
		this.opcionGrado = opcionGrado;
	}
	public int getTipoAct() {
		return tipoAct;
	}
	public void setTipoAct(int tipoAct) {
		this.tipoAct = tipoAct;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
