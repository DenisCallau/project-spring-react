package com.callau.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.callau.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
