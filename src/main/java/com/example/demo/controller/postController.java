package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.SearchParam;

@RestController
@RequestMapping("/api")
public class postController {
	
	//HTML <Form>
	//ajax 검색
	//http post body -> data
	//json, xml, multipart-form / text-plain
	
	@PostMapping(value = "/postMethod")
	public SearchParam postMethod(@RequestBody SearchParam searchParam) {
		return searchParam;
	}
	
	
}
