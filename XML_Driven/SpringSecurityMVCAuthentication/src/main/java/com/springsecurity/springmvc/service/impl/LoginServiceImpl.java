package com.springsecurity.springmvc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springsecurity.springmvc.dao.LoginDao;
import com.springsecurity.springmvc.service.LoginService;
import com.springsecurity.springmvc.util.UserBean;

@Service
public class LoginServiceImpl implements LoginService {
	private LoginDao loginDao;

	@Override
	public List<UserBean> login(String username, String password) {
		return loginDao.login(username, password);
	}

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
}