package com.ssafy.springtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.springtest.service.CountryStatusService;
import com.ssafy.springtest.dto.CountryStatusDto;

@Controller
public class CountryController {
	
	@Autowired
	private CountryStatusService cService;
	
	@GetMapping("/country-status")
	public String showList(Model model) {
		List<CountryStatusDto> statuses = cService.search();
		model.addAttribute("statuses", statuses);
		return "country-status";
	}
	
	@GetMapping("/country-status/{cname}")
	public String countyStatusDetail(@PathVariable String seq, Model model) {
		CountryStatusDto countrystatusdto = cService.select(seq);
		model.addAttribute("article", countrystatusdto);
		
		return "detail";
	}
	
	@PostMapping("/regist")
	public String doRegist(@ModelAttribute("article") CountryStatusDto countrystatusdto, Model model) {
		cService.insert(countrystatusdto);
		
		model.addAttribute("article", countrystatusdto);
		
		return "regist_result";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String statusModify(CountryStatusDto countrystatusdto) {
		cService.update(countrystatusdto);
		return "redirect:/list";
	}
	
	@GetMapping("/delete/{seq}")
	public String statusDelete(@PathVariable String seq) {
		cService.delete(seq);
		return "redirect:/list";
	}

}
