package com.ssafy.springtest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="CountryStatusDto : 국가 상태 정보", description = "국가의 상세 상태 정보를 나타낸다.")
public class CountryStatusDto {
	
	@ApiModelProperty(value = "상태 번호")
	private int seq;
	
	@ApiModelProperty(value = "국가 명")
	private String cname;
	
	@ApiModelProperty(value = "확진자 수")
	private int patient;
	
	@ApiModelProperty(value = "지역 코드")
	private String rcode;
	
	public CountryStatusDto() {}

	public CountryStatusDto(int seq, String cname, int patient, String rcode) {
		super();
		this.seq = seq;
		this.cname = cname;
		this.patient = patient;
		this.rcode = rcode;
	}

	

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getPatient() {
		return patient;
	}

	public void setPatient(int patient) {
		this.patient = patient;
	}

	public String getRcode() {
		return rcode;
	}

	public void setRcode(String rcode) {
		this.rcode = rcode;
	}

	@Override
	public String toString() {
		return "CountryStatusDto [seq=" + seq + ", cname=" + cname + ", patient=" + patient + ", rcode=" + rcode + "]";
	}
}
