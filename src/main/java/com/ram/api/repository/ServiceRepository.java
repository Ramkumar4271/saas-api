package com.ram.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ram.api.entity.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {

}
