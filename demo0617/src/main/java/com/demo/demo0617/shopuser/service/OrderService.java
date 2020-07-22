package com.demo.demo0617.shopuser.service;

import com.demo.demo0617.common.domain.OrderRepository;
import com.demo.demo0617.common.domain.Orders;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Transactional
    public Orders saveOrder(Orders order) {
        return orderRepository.save(order);
    }

    @Transactional
    public List<Orders> findAll(){
        return orderRepository.findAll();
    }


}
