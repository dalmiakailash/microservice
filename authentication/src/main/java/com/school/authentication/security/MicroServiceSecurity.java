package com.school.authentication.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MicroServiceSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource datasource;
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.headers().cacheControl().disable();
		http.headers().frameOptions().disable();
		http.requestCache().disable();
		http.csrf().disable();
		http
			.authorizeRequests()
			.antMatchers("/user/**")
			.authenticated()
			.and()
			.httpBasic();
	}
	
	@Override
	public void configure(final WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/", "/h2-console/**");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.passwordEncoder(passwordEncoder())
		.dataSource(datasource)
		.usersByUsernameQuery("SELECT user_id, password, '1' as enable FROM USERS WHERE user_id=?")
		.authoritiesByUsernameQuery("select u.user_id, r.role from USERS u inner join USERS_ROLES  ur ON ur.user_id = u.id\r\n" + 
				"inner join ROLES r on ur.role_id = r.id\r\n" + 
				"where u.user_id=?");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	
}
