package com.example.demo.component;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class LoginUserAuditorAware implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		// TODO Auto-generated method stub
		return Optional.of("AdminServer");
	}

}
