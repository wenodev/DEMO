package com.demo.demo0617.common.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findAll();
    List<Cart> findByMember(Member member);
    List<Cart> deleteAllById(Long id);
}
