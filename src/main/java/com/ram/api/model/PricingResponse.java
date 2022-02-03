package com.ram.api.model;

import java.util.List;

import com.ram.api.entity.Package;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PricingResponse {
	
	private int id;	
	private String name;	
	private double price;
	private List<Package> packages;
}
