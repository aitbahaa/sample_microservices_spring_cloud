package ihm.ci.test.cloud.microservices.currencycalculservice.controller.bean;

import java.math.BigDecimal;

public class ExchangeCalcul {
	
	private long id;
	private String from;
	private String to;
	private BigDecimal valueExchange;
	private BigDecimal quantity;
	private BigDecimal total;
	private int port;
	
	
	public ExchangeCalcul() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ExchangeCalcul(long id, String from, String to, BigDecimal valueExchange, BigDecimal quantity,
			BigDecimal total, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.valueExchange = valueExchange;
		this.quantity = quantity;
		this.total = total;
		this.port = port;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
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


	public BigDecimal getValueExchange() {
		return valueExchange;
	}


	public void setValueExchange(BigDecimal valueExchange) {
		this.valueExchange = valueExchange;
	}


	public BigDecimal getQuantity() {
		return quantity;
	}


	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}


	public BigDecimal getTotal() {
		return total;
	}


	public void setTotal(BigDecimal total) {
		this.total = total;
	}


	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}
	
	

}
