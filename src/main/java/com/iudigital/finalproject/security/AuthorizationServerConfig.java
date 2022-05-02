package com.iudigital.finalproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenStore jwtTokenStore;
	@Autowired
	private JwtAccessTokenConverter jwtAccessTokenConverter;
	
	@Value("${security.oauth2.client.id}")
	private String clientId;
	@Value("${security.oauth2.client.secret}")
	private String clientSecret;
	@Value("${security.oauth2.jwt.expire}")
	private int expire;
	
	// Permiso que van a tener nuestros end points del 
	// servidor de autorizacion de oauth2 para generar y validar token
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()") // para que cualquiera pueda acceder a la ruta oauth/token
				.checkTokenAccess("isAuthenticated()");
	}
	
	// Para registrar los clientes que se van a conectar a nuestros servicios
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		clients.inMemory()
		        .withClient(clientId)
				.secret(passwordEncoder.encode(clientSecret))
				.scopes("read", "write") // ALCANCE
				.authorizedGrantTypes("password") // para solicitar credenciales del usuario
				.accessTokenValiditySeconds(expire);
		
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		
		
		
		endpoints
				 .authenticationManager(authenticationManager)
				 .tokenStore(jwtTokenStore)
				 .accessTokenConverter(jwtAccessTokenConverter);
				 
		
	}
	
}
