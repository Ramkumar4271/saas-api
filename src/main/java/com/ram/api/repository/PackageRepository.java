package com.ram.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.api.entity.Package;

public interface PackageRepository extends JpaRepository<Package, Integer> {

}
