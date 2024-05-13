package co.edu.uptc.appstore.model;

public class Sale {

	private String code;
	private String total;
	private String sale_date;
	
	public Sale(String code, String total, String sale_date) {
		super();
		this.code = code;
		this.total = total;
		this.sale_date = sale_date;
	}
	public Sale(String code, String sale_date) {
		super();
		this.code = code;
		this.sale_date = sale_date;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getSale_date() {
		return sale_date;
	}
	public void setSale_date(String sale_date) {
		this.sale_date = sale_date;
	}
	@Override
	public String toString() {
		return "Sale [code=" + code + ", total=" + total + ", sale_date=" + sale_date + "]";
	}
	
	
	
}
