package com.itsight.cuy.domain.dto;

import java.io.Serializable;

public class ResponseVisaDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1270822692117732344L;
	
	private ResHeader header;
	private ResOrder order;
	private ResDataMap dataMap;

	public ResponseVisaDto() {
		// TODO Auto-generated constructor stub
		this.header = new ResHeader();
		this.order = new ResOrder();
		this.dataMap = new ResDataMap();
	}

	public ResHeader getHeader() {
		return header;
	}

	public void setHeader(ResHeader header) {
		this.header = header;
	}

	public ResOrder getOrder() {
		return order;
	}

	public void setOrder(ResOrder order) {
		this.order = order;
	}

	public ResDataMap getDataMap() {
		return dataMap;
	}

	public void setDataMap(ResDataMap dataMap) {
		this.dataMap = dataMap;
	}
}
