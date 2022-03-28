package com.ssafy.springtest.service;

import java.util.List;

import com.ssafy.springtest.dto.CountryStatusDto;

public interface CountryStatusService {

	int insert(CountryStatusDto countrystatusdto);
	
	int update(CountryStatusDto countrystatusdto);
	
	int delete(String seq);
	
	CountryStatusDto select(String seq);
	
	List<CountryStatusDto> search();
	
}
