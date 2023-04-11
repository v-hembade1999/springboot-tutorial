package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter
{

	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		// TODO Auto-generated method stub
		http 
		     .csrf().disable()
		     .authorizeHttpRequests()
		     .antMatchers("/home").hasRole("NORMAL")
		     .antMatchers("/signin").permitAll()
		     .anyRequest()
		     .authenticated()
		     .and()
		     .formLogin()
		     .loginPage("/signin")
		     .loginProcessingUrl("/dologin")
		     .defaultSuccessUrl("/users/");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication().withUser("rock").password(this.passwordencoder().encode("redhat")).roles("NORMAL");
		auth.inMemoryAuthentication().withUser("jack").password(this.passwordencoder().encode("redhat")).roles("NORMAL");
	}
    
	@Bean
	public PasswordEncoder passwordencoder() 
	{
	    return new BCryptPasswordEncoder(10);
	}
	

	
	
	

	
	
}
