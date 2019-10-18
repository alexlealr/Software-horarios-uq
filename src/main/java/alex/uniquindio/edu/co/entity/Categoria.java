package alex.uniquindio.edu.co.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

/**
 * Entidad categoria de libros
 * @author alexander leal
 *
 */
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

    /**
     * Constructor que inicializa todos los atributos
     */
    public Categoria() {
    super();
    }
	
    /**
     * Metodo get que obtiene la lista de libros
     * @return lista de libros
     */
	public List<Libro> getCodigoLibro() {
		return codigoLibro;
	}

	/**
	 * inicializa la lista de libros
	 * @param codigoLibro lista de libros
	 */
	public void setCodigoLibro(List<Libro> codigoLibro) {
		this.codigoLibro = codigoLibro;
	}
    /**
     * obtiene el id de la categoria
     * @return id
     */
	public Long getId() {
		return id;
	}
	/**
	 * inicializa el id de la categoria
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * obtiene el nombre de la categoria
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * inicializa el nombre de la categoria
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * obtiene la rango de edad para la categoria
	 * @return edad
	 */
	public String getEdad() {
		return edad;
	}
	/**
	 * inicializa la edad 
	 * @param edad
	 */
	public void setEdad(String edad) {
		this.edad = edad;
	}
	/**
	 * obtiene el serial de la entidad
	 * @return
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * obtiene el codigo de la categoria
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * incializa el codigo de la categoria
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
}
