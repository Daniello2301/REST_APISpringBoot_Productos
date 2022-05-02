package com.iudigital.finalproject.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Value("${security.oauth2.jwt.key}")
	private String jwtKey;
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore());
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
				//.antMatchers("/usuario/**")
				//.permitAll()
				//.antMatchers("/producto/**")
				//.permitAll()
				.antMatchers("/categoria/**")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.cors()
				.configurationSource(corsConfigurationSource());
	
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowedOrigins(Arrays.asList("*")); // Dominios, * es para todos
		corsConfiguration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS", "PATCH", "HEAD"));
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfiguration); // Para que se aplique a todos los end points de nuestros servicios

		return source;
		
	}
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		
		FilterRegistrationBean<CorsFilter> bean = 
				new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		
		return bean;
		
	}
	
	@Bean
	public JwtTokenStore tokenStore() {
		
		return new JwtTokenStore(accessTokenConverter());
		
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey(jwtKey); // secret key
		return tokenConverter;
		
	}
	
}
