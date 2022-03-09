package com.springsecurity.springmvc.handlers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springsecurity.springmvc.util.UserBean;

public class UserDetailsRowMapper implements RowMapper<UserBean> {
	@Override
	public UserBean mapRow(ResultSet arg0, int arg1) throws SQLException {
		UserBean userBean = new UserBean();
		userBean.setFirstName(arg0.getString("first_name"));
		userBean.setLastName(arg0.getString("last_name"));

		return userBean;
	}
}