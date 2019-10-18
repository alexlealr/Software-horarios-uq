package alex.uniquindio.edu.co;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Clase principal de la aplicacion
 * @author alexander leal
 *
 */
@SpringBootApplication
public class ProyectoGradoApplication extends SpringBootServletInitializer {
	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ProyectoGradoApplication.class);
	}

	/**
	 * metodo main que permite que la app se ejecute
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProyectoGradoApplication.class, args);
	}

}
