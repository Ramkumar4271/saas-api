package com.ram.api.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.ram.api.entity.Package;
import com.ram.api.entity.Pricing;
import com.ram.api.model.APIResponse;
import com.ram.api.model.PricingResponse;
import com.ram.api.repository.PricingRepository;

@Service
public class PricingServiceImpl implements PricingService {

	@Autowired
	private PricingRepository repository;

	@Autowired
	private PackageService packageService;

	@Override
	public APIResponse getPricings() {
		
		List<Pricing> pricings = this.repository.findAll();
		List<Package> packages= this.packageService.getPackages();
		
		Map<Integer, List<Package>> groupedList = packages.stream().collect(Collectors.groupingBy(Package::getP_id));
		List<PricingResponse> list = pricings.stream().map(p -> new PricingResponse(p.getId(), p.getName(), p.getPrice(), groupedList.get(p.getId()))).collect(Collectors.toList());
		
		return APIResponse.builder().status(HttpStatus.OK).data(list).build();
	}

}
