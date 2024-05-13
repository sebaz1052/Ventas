package co.edu.uptc.appstore.model;

public class Product {
 
	private String code;
	private String description;
	private String price;
	private String lot;
	
	public Product() {
		
	}

	public Product(String code, String description, String price, String lot) {
		super();
		this.code = code;
		this.description = description;
		this.price = price;
		this.lot = lot;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getLot() {
		return lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", description=" + description + ", price=" + price + ", lot=" + lot + "]";
	}
	
}
