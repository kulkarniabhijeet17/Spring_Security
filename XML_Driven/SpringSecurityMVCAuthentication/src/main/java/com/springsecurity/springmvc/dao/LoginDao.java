package com.springsecurity.springmvc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springsecurity.springmvc.handlers.UserDetailsRowMapper;
import com.springsecurity.springmvc.util.UserBean;

@Repository
public class LoginDao {
	private JdbcTemplate jdbcTemplate;

	public List<UserBean> login(String username, String password) {
		String sql = "select first_name, last_name from USERS where username = ?";

		List<UserBean> userBeanList = (List<UserBean>) jdbcTemplate.query(sql, new Object[] { username },
				new UserDetailsRowMapper());

		return userBeanList;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}