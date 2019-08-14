package yesder.bolsadeideas.Springboot.web.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Docente implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4032635468689409804L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy="native")
	private Long id;

	
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private String identificacion;
	@Column
	private String limitHoras;
	@Column
	private String telefono;
	@Column
	private String estado;
	@Column
	private String ciudad;
	@Column
	@Email
	private String correo;
	
	
	public Docente(String nombre, String apellido, String identificacion, String limitHoras, String telefono,
			String estado, String ciudad, String correo) {
		this.apellido = apellido;
		this.ciudad = ciudad;
		this.correo = correo;
		this.estado = estado;
		this.identificacion = identificacion;
		this.limitHoras = limitHoras;
		this.nombre =nombre;
		this.telefono = telefono;
		
	}
	
	public Docente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getLimitHoras() {
		return limitHoras;
	}
	public void setLimitHoras(String limitHoras) {
		this.limitHoras = limitHoras;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
