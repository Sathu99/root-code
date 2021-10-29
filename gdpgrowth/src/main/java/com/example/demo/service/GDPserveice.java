package com.example.demo.service;

import com.example.demo.dto.ResponseDto;

public interface GDPserveice {

	ResponseDto getGDPRate(String countryCode,int year) throws Exception;
}
