package com.example.demo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ifs.CrudInterface;
import com.example.demo.model.network.Header;
import com.example.demo.model.network.request.ItemApiRequest;
import com.example.demo.model.network.response.ItemApiResponse;
import com.example.demo.service.ItemApiLogicService;

@RestController
@RequestMapping("/api/item")
public class ItemApiController implements CrudInterface<ItemApiRequest, ItemApiResponse> {

	@Autowired
	private ItemApiLogicService itemApiLogicService;

	@Override
	@PostMapping("")
	public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {
		// TODO Auto-generated method stub
		return itemApiLogicService.create(request);
	}

	@Override
	@GetMapping("{id}")
	public Header<ItemApiResponse> read(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return itemApiLogicService.read(id);
	}

	@Override
	@PutMapping("")
	public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> request) {
		// TODO Auto-generated method stub
		return itemApiLogicService.update(request);
	}

	@Override
	@DeleteMapping("{id}")
	public Header delete(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return itemApiLogicService.delete(id);
	}

}
