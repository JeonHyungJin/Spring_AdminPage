package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.ifs.CrudInterface;
import com.example.demo.model.network.Header;

public abstract class Crudcontroller<Req, Res> implements CrudInterface<Req, Res>{

	protected CrudInterface<Req, Res> baseService;
	
	@Override
	@PostMapping("")
	public Header<Res> create(@RequestBody Header<Req> request) {
		// TODO Auto-generated method stub
		return baseService.create(request);
	}

	@Override
	@GetMapping("{id}")
	public Header<Res> read(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return baseService.read(id);
	}

	@Override
	@PutMapping("")
	public Header<Res> update(@RequestBody Header<Req> request) {
		// TODO Auto-generated method stub
		return baseService.update(request);
	}

	@Override
	@DeleteMapping("{id}")
	public Header delete(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return baseService.delete(id);
	}

}
