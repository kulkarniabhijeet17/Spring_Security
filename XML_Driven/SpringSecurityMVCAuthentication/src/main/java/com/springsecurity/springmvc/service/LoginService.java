package com.springsecurity.springmvc.service;

import java.util.List;

import com.springsecurity.springmvc.util.UserBean;

public interface LoginService {
	public List<UserBean> login(String username, String password);
}