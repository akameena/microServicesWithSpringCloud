package com.anil.currencyconversion.model;

public class CurrencyConversionData {

	private int  id;
	private  int conversionMultiple;
	private int  port;
	private  int  total_amount;
	
	@Override
	public String toString() {
		return "CurrencyConversionData [id=" + id + ", conversionMultiple=" + conversionMultiple + ", port=" + port
				+ ", total_amount=" + total_amount + ", to=" + to + "]";
	}
	public int getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}
	public CurrencyConversionData(int id, int conversionMultiple, int port, int total_amount, String to) {
		super();
		this.id = id;
		this.conversionMultiple = conversionMultiple;
		this.port = port;
		this.total_amount = total_amount;
		this.to = to;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	private String to;
	public String get_to() {
		return to;
	}
	public void set_to(String _to) {
		this.to = _to;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(int conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public CurrencyConversionData() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}
