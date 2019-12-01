package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ifs.CrudInterface;
import com.example.demo.model.entity.OrderGroup;
import com.example.demo.model.network.Header;
import com.example.demo.model.network.request.OrderGroupApiRequest;
import com.example.demo.model.network.response.OrderGroupApiResponse;
import com.example.demo.repository.OrderGroupRepository;
import com.example.demo.repository.UserRepository;

@Service
public class OrderGroupApiLogicService extends BaseService<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Header<OrderGroupApiResponse> create(Header<OrderGroupApiRequest> request) {
		// TODO Auto-generated method stub
		OrderGroupApiRequest body = request.getData();

		OrderGroup orderGroup = OrderGroup.builder().status(body.getStatus()).orderType(body.getOrderType())
				.revAddress(body.getRevAddress()).revName(body.getRevName()).paymentType(body.getPaymentType())
				.totalPrice(body.getTotalPrice()).totalQuantity(body.getTotalQuantity()).orderAt(LocalDateTime.now())
				.arrivalDate(body.getArrivalDate()).user(userRepository.getOne(body.getUserId())).build();

		OrderGroup newOrderGroup = baseRepository.save(orderGroup);
		return response(newOrderGroup);
	}

	@Override
	public Header<OrderGroupApiResponse> read(Long id) {
		// TODO Auto-generated method stub
		baseRepository.findById(id).map(this::response).orElseGet(() -> Header.ERROR("데이터 없음"));
		return null;
	}

	 @Override
	    public Header<OrderGroupApiResponse> update(Header<OrderGroupApiRequest> request) {

	        return Optional.ofNullable(request.getData())
	                .map(body ->{
	                    return baseRepository.findById(body.getId())
	                        .map(orderGroup -> {
	                            orderGroup
	                                    .setStatus(body.getStatus())
	                                    .setOrderType(body.getOrderType())
	                                    .setRevAddress(body.getRevAddress())
	                                    .setRevName(body.getRevName())
	                                    .setPaymentType(body.getPaymentType())
	                                    .setTotalPrice(body.getTotalPrice())
	                                    .setTotalQuantity(body.getTotalQuantity())
	                                    .setOrderAt(body.getOrderAt())
	                                    .setArrivalDate(body.getArrivalDate())
	                                    .setUser(userRepository.getOne(body.getUserId()))
	                            ;
	                            return orderGroup;
	                        })
	                        .map(changeOrderGroup -> baseRepository.save(changeOrderGroup))
	                        .map(this::response)
	                        .orElseGet(()->Header.ERROR("데이터 없음"));
	                })
	                .orElseGet(()->Header.ERROR("데이터 없음"));
	    }


	@Override
	public Header delete(Long id) {
		// TODO Auto-generated method stub

		return baseRepository.findById(id).map(orderGroup -> {
			baseRepository.delete(orderGroup);
			return Header.OK();
		}).orElseGet(() -> Header.ERROR("데이터 없음"));
	}

	private Header<OrderGroupApiResponse> response(OrderGroup orderGroup) {
		OrderGroupApiResponse body = OrderGroupApiResponse.builder().id(orderGroup.getId())
				.status(orderGroup.getStatus()).orderType(orderGroup.getOrderType()).revName(orderGroup.getRevName())
				.revAddress(orderGroup.getRevAddress()).paymentType(orderGroup.getPaymentType())
				.totalPrice(orderGroup.getTotalPrice()).totalQuantity(orderGroup.getTotalQuantity())
				.orderAt(orderGroup.getOrderAt()).arrivalDate(orderGroup.getArrivalDate())
				.userId(orderGroup.getUser().getId()).build();

		return Header.OK(body);
	}

}
