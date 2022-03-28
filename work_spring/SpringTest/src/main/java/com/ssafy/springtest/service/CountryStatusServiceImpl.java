package com.ssafy.springtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.springtest.dto.CountryStatusDto;
import com.ssafy.springtest.mapper.CountryStatusMapper;

@Service
public class CountryStatusServiceImpl implements CountryStatusService{
	@Autowired
	private CountryStatusMapper repo;
	
	public CountryStatusMapper getcsm() {
		return repo;
	}

	// @Autowired
	public void setRepo(CountryStatusMapper repo) {
		this.repo = repo;
	}

	@Override
	public int insert(CountryStatusDto countrystatusdto) {
		return repo.insert(countrystatusdto);
	}

	@Override
	public int update(CountryStatusDto countrystatusdto) {
		return repo.update(countrystatusdto);
	}

	@Override
	public int delete(String no) {
		return repo.delete(no);
	}

	@Override
	public CountryStatusDto select(String no) {
		return repo.select(no);
	}

	@Override
	public List<CountryStatusDto> search() {
		return repo.search();
	}

}
