package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDto;
import com.example.demo.service.GDPserveice;

@RestController
@RequestMapping("/gdp/getRate")
public class gdpController {

	@Autowired
	GDPserveice gdPserveice;
	
	@GetMapping("/getGDP")
	public ResponseDto getGDPgrowthRate(@RequestParam("countryCode") String countryCode,@RequestParam("year") int year) {
		try {
			return gdPserveice.getGDPRate(countryCode,year);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
