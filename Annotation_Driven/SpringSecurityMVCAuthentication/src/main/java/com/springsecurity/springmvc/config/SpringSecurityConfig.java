package com.springsecurity.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = { "com.springsecurity.springmvc.common.controller", "com.springsecurity.springmvc.dao",
		"com.springsecurity.springmvc.service.*" }, basePackageClasses = SpringSecurityConfig.class)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user1").password("user1Pass").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/home")
				.access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')").and().formLogin().loginPage("/login")
				.usernameParameter("ssoId").passwordParameter("password").and().exceptionHandling()
				.accessDeniedPage("/accessdenied");
	}
}