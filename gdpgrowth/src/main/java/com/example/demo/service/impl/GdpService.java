package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.example.demo.dto.ResponseDto;
import com.example.demo.service.GDPserveice;

@Service
public class GdpService implements GDPserveice{

	@Value("${datasetGDP}")
	private String fileName;
	
	
	@Override
	public ResponseDto getGDPRate(String countryCode,int year) throws Exception {
		System.out.println(countryCode);
		System.out.println(year);
		ResponseDto responseDto = new ResponseDto();
		List<List<String>> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(ResourceUtils.getFile("classpath:"+fileName)))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        if (values[1].equals(countryCode) && (values[2].equals(Integer.toString(year)) || values[2].equals(Integer.toString(year-1)))) {
			        records.add(Arrays.asList(values));
				}
		    }
		   
		    if (records.size() == 2) {
			    System.out.println(records);

		    	double previousYearRate = Double.parseDouble ((records.get(0)).get(3));
		    	double currentYearRate = Double.parseDouble ((records.get(1)).get(3));
		    	double gRate = (currentYearRate-previousYearRate )/ previousYearRate;
		    	System.out.println(gRate);
		    	HashMap<String, Double> result = new HashMap<>();
		    	result.put("GDPGrowthRate", gRate);
		    	responseDto.setResponseDto(result);

			}else {
				
		    responseDto.setErrorCode(500);
		    responseDto.setErrorDescription("Error Occured while calculation");
		    responseDto.setStatus(false);
			}
		}
		
		return responseDto;
		
	}

}
