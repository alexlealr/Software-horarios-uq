package alex.uniquindio.edu.co.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import alex.uniquindio.edu.co.entity.Usuario;
import alex.uniquindio.edu.co.repository.UsuarioRepository;


/**
 * Se encarga de capturar el username y la password y buscarla en la bd
 * para poder loguear al usuario
 * @author alexander leal
 *
 */
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService{

	/**
	 * Repositorio de usuario
	 */
	@Autowired
    UsuarioRepository userRepository;



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 
		//Busca el usuario en el repositorio y si no existe lanza una exepcion
		Usuario appUser = 
	               userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User does not exist!"));
		
		   List<GrantedAuthority> roles= new ArrayList<>();
		   roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		   
	   
	   UserDetails user =  new User(appUser.getUsername(), appUser.getPassword(), roles);
	  
	    return user;
		
	}

}