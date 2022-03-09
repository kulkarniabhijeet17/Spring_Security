package com.springsecurity.springmvc.common.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.springsecurity.springmvc.service.LoginService;
import com.springsecurity.springmvc.util.ApplicationContextProvider;
import com.springsecurity.springmvc.util.UserBean;

@Controller
@SessionAttributes("userBean")
public class LoginController {
	private LoginService loginService;

	@RequestMapping(value = { "/chp" }, method = RequestMethod.GET)
	public String getLoginPage(Model model) {
		model.addAttribute("userBean", new UserBean());
		return "chpLogin";
	}

	@RequestMapping(value = "/processLogin", method = RequestMethod.POST)
	public String processLogin(Model model, @ModelAttribute("userBean") UserBean userBean, BindingResult bindingResult,
			SessionStatus status) {
		loginService = (LoginService) ApplicationContextProvider.getBean("loginService");
		String username = userBean.getUsername();
		String password = userBean.getPassword();

		List<UserBean> userDetailsList = loginService.login(username, password);
		for (UserBean userDetails : userDetailsList) {
			model.addAttribute("user", userDetails.getFirstName() + " " + userDetails.getLastName());
		}

		if (bindingResult.hasErrors()) {
			return "chpLogin";
		}

		return "homePage";
	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String loginError(ModelMap model) {
		model.addAttribute("error", "true");
		return "denied";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "logout";
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
}