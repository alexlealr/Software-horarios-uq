package alex.uniquindio.edu.co.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

/**
 * Entidad prestamos de libros
 * @author alexander leal
 *
 */
@Entity
public class Prestamo implements Serializable{

	/**
	 *serial de la entidad 
	 */
	private static final long serialVersionUID = 8377524303096827312L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy="native")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idUsuario")
	private Usuario identi;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idlibro")
	private Libro codigoLibro;
	
	@Column
	private Date fechaPrestamo ;
	@Column
	private String estado;
	@Column
	private String descripcion;
	@Column
	private Date fechaEntrega;
	
	/**
	 * inicializa los datos de la entidad
	 */
	public Prestamo() {
		super();
	}

	/**
	 * metodo que calcula los dias de un libro prestado
	 * @return dias prestado
	 */
   public int diasCalculados() {
	   int dias=(int) ((fechaEntrega.getTime()-fechaPrestamo.getTime())/86400000);
	   return dias;
   }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getIdenti() {
		return identi;
	}

	public void setIdenti(Usuario identi) {
		this.identi = identi;
	}

	public Libro getCodigoLibro() {
		return codigoLibro;
	}

	public void setCodigoLibro(Libro codigoLibro) {
		this.codigoLibro = codigoLibro;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}