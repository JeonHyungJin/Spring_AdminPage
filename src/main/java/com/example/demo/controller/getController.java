package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SearchParam;
import com.example.demo.model.network.Header;

@RestController
@RequestMapping("/api") // localhost:8080/api
public class getController {

	@RequestMapping(method = RequestMethod.GET, path = "/getMethod") // localhost:8080/api/getMethod
	public String getRequest() {
		return "Hi getMethod";
	}

	@GetMapping("/getParameter")
	public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd) {
		System.out.println(id + ", " + pwd);

		return id + pwd;
	}

	@GetMapping("/getMultiParameter")
	public SearchParam getMultiParameter(SearchParam searchParam) {
		System.out.println(searchParam.getAccount());
		System.out.println(searchParam.getEmail());
		System.out.println(searchParam.getPage());

		return searchParam;
	}

	@GetMapping("/header")
	public Header getHeader() {

		// {"resultCode" : "OK", "description" : "OK"}
		return Header.builder().resultCode("OK").description("OK").build();
	}

}
