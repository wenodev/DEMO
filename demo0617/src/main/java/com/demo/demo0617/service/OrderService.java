package com.demo.demo0617.service;

import com.demo.demo0617.domain.OrderRepository;
import com.demo.demo0617.domain.Orders;
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
