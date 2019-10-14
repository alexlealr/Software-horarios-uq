package alex.uniquindio.edu.co.entity;

import java.io.Serializable;
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
public class Categoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 725725141914824891L;

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
   	private String edad;
    @OneToMany(mappedBy = "categ")
	private List<Libro> codigoLibro;

    
    public Categoria() {
    super();
    }
	public Categoria(Long id, @NotBlank String nombre, @NotBlank String edad, String codigo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.codigo=codigo;
	}
	
	public List<Libro> getCodigoLibro() {
		return codigoLibro;
	}

	public void setCodigoLibro(List<Libro> codigoLibro) {
		this.codigoLibro = codigoLibro;
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
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
}
