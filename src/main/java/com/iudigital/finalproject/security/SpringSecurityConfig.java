package com.iudigital.finalproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//1.
//Registrar en el autenticacion manager la clase userService que implementa la interfaz 
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	// Bean que creamos UserService
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean // para se guarde en el contenedor de spring y ser utilizados en el servidor de autorizacion
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	@Autowired // para que se pueda inyectar
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	    // convierte el password que ingresa el usuario a bcrypt para poder compararlo con el password
		// que esta en la base de datos guardado con bcrypt
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

	}

	@Override
	@Bean // para se guarde en el contenedor de spring y ser utilizados en el servidor de autorizacion
	protected AuthenticationManager authenticationManager() throws Exception {
		
		return super.authenticationManager();
		
	}
	
}