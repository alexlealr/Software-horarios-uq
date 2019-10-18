package alex.uniquindio.edu.co;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import alex.uniquindio.edu.co.service.UserDetailsServiceImpl;

/**
 * Clase que permite la seguridad de la aplicacion 
 * @author alexander leal
 *
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	//recursos disponibles de la aplicacion
	String[] resources = new String[]{
            "/include/**","/css/**","/img/**","/uploads/**"
    };
	
	/**
	 * Metodo que permite configurar los servicios y peticiones que
	 * se realicen durante la ejecucion de la aplicacion
	 */
	@Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
        .authorizeRequests()
        .antMatchers(resources).permitAll()  
        .antMatchers("/","/index", "/usuarioForm").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .permitAll()
            .defaultSuccessUrl("/usuarioForm")
            .failureUrl("/login?error=true")
            .usernameParameter("username")
            .passwordParameter("password")
            .and()
            .csrf().disable()
        .logout()
            .permitAll()
            .logoutSuccessUrl("/login?logout");
    }
    
	/*
	 * Variable que permite la encriptacion de las contraseñas de usuarios
	 */
	@Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * Metodo que realiza la encriptacion de contraseña de usuario
	 * @return bCryptPasswordEncoder contraseña encriptada
	 */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
    	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
    /**
     * Esta interfaz describe un objeto usuario que realiza el acceso a los datos 
     */
    @Autowired	
    UserDetailsServiceImpl userDetailsService;
    
    /**
     * Metodo que permite configurar la autenticación en memoria 
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
    	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    	
}
}