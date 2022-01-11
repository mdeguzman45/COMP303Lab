package com.spring.jpa;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public CustomCustomerDetailsService customerDetailsService() {
		return new CustomCustomerDetailsService();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenthicationProvider() {
		DaoAuthenticationProvider  authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(customerDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenthicationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/program").authenticated()
		.anyRequest()
		.permitAll()
		.and()
		.formLogin()
		.loginPage("/")
		.loginProcessingUrl("/login")
		.usernameParameter("username")
		.passwordParameter("password")
		.defaultSuccessUrl("/program")
		.and()
		.csrf()
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
//		http.authorizeRequests()
//		.anyRequest()
//		.permitAll();
		
//		http.authorizeRequests()
//		.antMatchers("/program").authenticated()
//		.anyRequest().permitAll()
//		.and()
//		.formLogin().loginPage("/")
//		
//		
//		.formLogin("/")
//		.usernameParameter("username")
//		.defaultSuccessUrl("/program")
//		.permitAll()
//		.and()
//		.logout().logoutUrl("/").permitAll();
	}
	
	
}
