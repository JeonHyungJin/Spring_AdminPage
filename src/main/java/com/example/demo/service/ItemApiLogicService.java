package com.example.demo.service;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ifs.CrudInterface;
import com.example.demo.model.entity.Item;
import com.example.demo.model.network.Header;
import com.example.demo.model.network.request.ItemApiRequest;
import com.example.demo.model.network.response.ItemApiResponse;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.PartnerRepository;

@Service
public class ItemApiLogicService extends BaseService<ItemApiRequest, ItemApiResponse, Item> {

	@Autowired
	private PartnerRepository partnerRepository;

	@Override
	public Header<ItemApiResponse> create(Header<ItemApiRequest> request) {
		// TODO Auto-generated method stub

		ItemApiRequest body = request.getData();

		Item item = Item.builder().status(body.getStatus()).name(body.getName()).title(body.getTitle())
				.content(body.getContent()).price(body.getPrice()).brandName(body.getBrandName())
				.registeredAt(LocalDateTime.now()).partner(partnerRepository.getOne(body.getPartnerId())).build();

		Item newItem = baseRepository.save(item);
		return response(newItem);
	}

	@Override
	public Header<ItemApiResponse> read(Long id) {
		// TODO Auto-generated method stub

		return baseRepository.findById(id).map(item -> response(item)).orElseGet(() -> Header.ERROR("데이터 없음"));
	}

	@Override
	public Header<ItemApiResponse> update(Header<ItemApiRequest> request) {
		// TODO Auto-generated method stub

		ItemApiRequest body = request.getData();

		baseRepository.findById(body.getId()).map(entityItem -> {
			entityItem.setStatus(body.getStatus()).setTitle(body.getTitle()).setContent(body.getContent())
					.setName(body.getName()).setPrice(body.getPrice()).setBrandName(body.getBrandName())
					.setPartner(partnerRepository.getOne(body.getPartnerId())).setStatus(body.getStatus())
					.setRegisteredAt(body.getRegisterdAt()).setUnregisteredAt(body.getUnregisterdAt());

			return entityItem;

		}).map(newEntityItem -> {
			baseRepository.save(newEntityItem);
			return newEntityItem;
		}).map(item -> response(item))

				.orElseGet(() -> Header.ERROR("데이터 없음"));

		return null;
	}

	@Override
	public Header delete(Long id) {
		// TODO Auto-generated method stub

		return baseRepository.findById(id).map(item -> {
			baseRepository.delete(item);
			return Header.OK();
		}).orElseGet(() -> Header.ERROR("데이터 없음"));

	}

	private Header<ItemApiResponse> response(Item item) {
		ItemApiResponse body = ItemApiResponse.builder().id(item.getId()).status(item.getStatus()).name(item.getName())
				.title(item.getTitle()).content(item.getContent()).price(item.getPrice()).brandName(item.getBrandName())
				.registerdAt(item.getRegisteredAt()).unregisterdAt(item.getUnregisteredAt())
				.partnerId(item.getPartner().getId()).build();

		return Header.OK(body);
	}

}
