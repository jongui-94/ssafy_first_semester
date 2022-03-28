package com.ssafy.springtest.mapper;

import java.util.List;

import com.ssafy.springtest.dto.CountryStatusDto;

public interface CountryStatusMapper {

	int insert(CountryStatusDto csd);
	
	int update(CountryStatusDto csd);
	
	int delete(String seq);
	
	CountryStatusDto select(String seq);
	
	List<CountryStatusDto> search();
}
