package com.savio.algamoneyapi.service;

import org.springframework.security.core.context.SecurityContextHolder;

import com.savio.algamoneyapi.security.UserSS;

public class UserService {

	public static UserSS authenticated() { //metodo que retorna um usuario logado
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}
}
