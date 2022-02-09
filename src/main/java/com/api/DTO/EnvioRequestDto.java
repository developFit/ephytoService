package com.api.DTO;

public class EnvioRequestDto {
	
	private String from;
	private String to;
	private String type;
	private Integer status;
	private String certificateNumber;
	private String xml;
	
	public EnvioRequestDto() {}

	public EnvioRequestDto(String from, String to, String type, Integer status, String certificateNumber, String xml) {
		super();
		this.from = from;
		this.to = to;
		this.type = type;
		this.status = status;
		this.certificateNumber = certificateNumber;
		this.xml = xml;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}
	
	

}
