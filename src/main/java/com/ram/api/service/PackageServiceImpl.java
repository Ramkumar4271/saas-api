package com.ram.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.api.entity.Package;
import com.ram.api.repository.PackageRepository;

@Service
public class PackageServiceImpl implements PackageService {

	@Autowired
	private PackageRepository repository;

	@Override
	public List<Package> getPackages() {
		return repository.findAll();
	}
	
}
