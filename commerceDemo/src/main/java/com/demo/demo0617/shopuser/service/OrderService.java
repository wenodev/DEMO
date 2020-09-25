package com.demo.demo0617.shopuser.service;

import com.demo.demo0617.common.domain.OrderRepository;
import com.demo.demo0617.common.domain.Orders;
import com.demo.demo0617.common.dto.AddressDto;
import com.demo.demo0617.common.dto.MemberDto;
import com.demo.demo0617.common.dto.OrdersDto;
import com.demo.demo0617.common.dto.ProductDto;
import com.demo.demo0617.shopadmin.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class OrderService {

    private OrderRepository orderRepository;
    private ProductService productService;
    private MemberService memberService;
    private AddressService addressService;
    private CartService cartService;

    //단일 상품 주문서 생성
    @Transactional
    public OrdersDto readyForOrder(Long productId, int productQuantity) {

        ProductDto productDto = productService.findById(productId);

        //1번방식
        Orders orders = Orders.builder()
                .quantity(productQuantity)
                .totalPrice(productDto.getProductPrice() * productQuantity)
                .product(productDto.toEntity())
                .build();

        OrdersDto ordersDto = OrdersDto.builder()
                .orders(orders)
                .build();


        return ordersDto;
    }

    //주문서 데이터베이스 저장
    @Transactional
    public void saveOrders(List<Long> productId, List<Integer> quantity, List<Float> totalPrice, Long memberId, Long addressId) {

        MemberDto memberDto = memberService.findById(memberId);
        AddressDto addressDto = addressService.findById(addressId);

        List<Orders> ordersList = new ArrayList<>();
        for(int i=0; i<productId.size(); i++){
            ProductDto productDto = productService.findById(productId.get(i));

            Orders orders = Orders.builder()
                    .orderNumber("order-" + makeRandom())
                    .quantity(quantity.get(i))
                    .totalPrice(totalPrice.get(i))
                    .member(memberDto.toEntity())
                    .product(productDto.toEntity())
                    .address(addressDto.toEntity())
                    .build();

            OrdersDto ordersDto = OrdersDto.builder()
                    .orders(orders)
                    .build();

            ordersList.add(ordersDto.toEntity());
        }
        orderRepository.saveAll(ordersList);
    }


    //카트페이지에서 주문페이지로 이동
    @Transactional
    public List<Orders> orderFromCart(List<Long> id, List<Integer> quantity){

        List<Orders> ordersList = new ArrayList<>();

        for(int i=0; i<id.size(); i++){

            ProductDto productDto = productService.findById(id.get(i));

            Orders orders = Orders.builder()
                    .product(productDto.toEntity())
                    .quantity(quantity.get(i))
                    .totalPrice(productDto.getProductPrice() * quantity.get(i))
                    .build();
            ordersList.add(orders);
        }

        return ordersList;
    }

    @Transactional
    public float getSubTotal(List<Long> id, List<Integer> quantity){
        float subTotal = 0;

        for(int i=0; i<id.size(); i++){
            ProductDto productDto = productService.findById(id.get(i));
            subTotal += productDto.getProductPrice() * quantity.get(i);
        }

        return subTotal;
    }

    @Transactional
    public int getSumOfQuantity(List<Integer> quantity){
        return quantity.stream().mapToInt(n -> n).sum();
    }



    @Transactional
    public List<Orders> findAll(){
        return orderRepository.findAll();
    }

    @Transactional
    public int findTableNumber(){
        List<Orders> orderList = orderRepository.findAll();
        return orderList.size();
    }

    //주문번호 생성
    public int makeRandom(){
        return (int)(Math.random()*1000000000) % 10000;
    }

}
