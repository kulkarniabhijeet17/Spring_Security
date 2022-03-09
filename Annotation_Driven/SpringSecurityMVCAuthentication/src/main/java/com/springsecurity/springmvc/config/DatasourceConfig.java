package com.springsecurity.springmvc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:dataSource.properties")
public class DatasourceConfig {
	@Autowired
	private Environment env;

	@Bean
	@Primary
	@Autowired
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("oracle.driver-class-name"));
		dataSource.setUrl(env.getProperty("oracle.url"));
		dataSource.setUsername(env.getProperty("oracle.username"));
		dataSource.setPassword(env.getProperty("oracle.password"));
		return dataSource;
	}

	@Bean
	@Autowired
	@Qualifier("getDataSource")
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		return jdbcTemplate;
	}
}