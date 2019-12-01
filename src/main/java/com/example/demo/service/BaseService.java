package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.ifs.CrudInterface;
import com.example.demo.model.network.Header;

@Component
public abstract class BaseService<Req, Res, Entity> implements CrudInterface<Req, Res> {

	@Autowired(required = false)
	protected JpaRepository<Entity, Long> baseRepository;
	
}
