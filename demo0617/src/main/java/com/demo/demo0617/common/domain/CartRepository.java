package com.demo.demo0617.common.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
//    @Query(value = "select * from cart where cart.")
//    public List<Cart> findAll();
}
