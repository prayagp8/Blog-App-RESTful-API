package com.blog.service;

import com.blog.exception.LoginException;
import com.blog.modal.LoginDTO;

public interface LoginService {

	public String loginAccount(LoginDTO loginDTO) throws LoginException;

	public String logoutAccount(String role, String key) throws LoginException;

}
