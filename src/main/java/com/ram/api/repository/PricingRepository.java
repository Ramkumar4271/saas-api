package com.ram.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ram.api.entity.Pricing;

@Repository
public interface PricingRepository extends JpaRepository<Pricing, Integer> {

}
