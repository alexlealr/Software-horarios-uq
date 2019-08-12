package yesder.bolsadeideas.Springboot.web.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;



public class Docente {


	private Long id;
	
	
	private String nombre;
	 
	private String apellido;
	 
	private String telefono;
	 
	private String asignaturas; //lista
	
	private String x;
	
	

}
