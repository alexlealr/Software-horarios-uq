package alex.uniquindio.edu.co.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Usuario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy="native")
	private Long id;
	
	@Column(length=60)
	@NotBlank
	private String codigo;
	@Column
	@NotBlank
	private String nombre;
	@Column
	@NotNull
	private String apellido;
	@Column
	@NotNull
	private String correo;
	@Column(name = "role")
	private String role;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	@NotNull
	private String telefo;
	@Column
	@NotNull
	private String edad;
	
	@OneToMany(mappedBy= "identi")
    private List<Prestamo> presta;
	
	public Usuario() {
		super();
	}
	
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Prestamo> getPresta() {
		return presta;
	}

	public void setPresta(List<Prestamo> presta) {
		this.presta = presta;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefo() {
		return telefo;
	}
	public void setTelefo(String telefo) {
		this.telefo = telefo;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String dire) {
		this.edad = dire;
	}
	
	
}
