package co.edu.uptc.appstore.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


import co.edu.uptc.appstore.constants.CommonConstants;
import co.edu.uptc.appstore.enums.ETypeFile;
import co.edu.uptc.appstore.interfaces.IActionFile.IActionsFile;
import co.edu.uptc.appstore.model.Product;
import co.edu.uptc.appstore.model.Sale;

public class ManagementProduct extends FilePlain implements IActionsFile {
private final String NAME_TAG_TIENDA= "Products";
	
	private List <Product> ListProduct;
	
	public ManagementProduct() {
		this.ListProduct = new ArrayList<>();
	}
	
	public void addProduct(Product pro) {
		this.ListProduct.add(pro);
	}
	
	public void dumpFile(ETypeFile eTypeFile) {
		if(ETypeFile.PLAIN.equals(eTypeFile)) {
			this.dumpFilePlain();
		}
	}

	public void loadStore(ETypeFile eTypeFile) {
		if(ETypeFile.PLAIN.equals(eTypeFile)) {
			this.loadFilePlain();
		}
	}

	private void dumpFilePlain() {
		String rutaArchivo = confValue.getPath().concat(confValue.getNameFileTXT());
		List<String> records = new ArrayList<>();
		 for(Product product : ListProduct){
			 StringBuilder contentProduct = new StringBuilder();
			 contentProduct.append(product.getCode()).append(CommonConstants.SEMI_COLON);
			 contentProduct.append(product.getDescription()).append(CommonConstants.SEMI_COLON);
			 contentProduct.append(product.getPrice()).append(CommonConstants.SEMI_COLON);
			 contentProduct.append(product.getLot()).append(CommonConstants.SEMI_COLON);
			 records.add(contentProduct.toString());
		 }
		 this.writer(rutaArchivo, records);
	}
	
	private void loadFilePlain() {
		List<String> contentInLine = this.reader(confValue.getPath().concat(confValue.getNameFileTXT()));
		System.out.println(contentInLine.size());
		contentInLine.forEach(row -> {
			System.out.println(row);
			StringTokenizer tokens = new StringTokenizer(row, CommonConstants.SEMI_COLON);
			while(tokens.hasMoreElements()){
				String code = tokens.nextToken();
				String description = tokens.nextToken();
				String price = tokens.nextToken();
				double price2 = Double.parseDouble(price);
				String lot = tokens.nextToken();
				int lot2 = Integer.parseInt(lot);
				ListProduct.add(new Product(code,description,price,lot));
			}
		});
	}
	
	public List<Product> getListProduct() {
		return ListProduct;
	}
	public void setListProduct(List<Product> listProduct) {
		ListProduct = listProduct;
	}
	
}