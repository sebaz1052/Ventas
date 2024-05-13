package co.edu.uptc.appstore.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import co.edu.uptc.appstore.constants.CommonConstants;
import co.edu.uptc.appstore.enums.ETypeFile;
import co.edu.uptc.appstore.interfaces.IActionFile2.IActionsFile2;
import co.edu.uptc.appstore.model.Sale;

public class ManagementSale extends FilePlain implements IActionsFile2 {
private final String NAME_TAG_TIENDA= "Sales";
	
	private List <Sale> ListSale;
	
	public ManagementSale() {
		this.ListSale = new ArrayList<>();
	}
	public void addSale(Sale sal) {
		this.ListSale.add(sal);
	}
	public void dumpFile2(ETypeFile eTypeFile) {
		if(ETypeFile.PLAIN.equals(eTypeFile)) {
			this.dumpFilePlain2();
		}
	}
	public void loadStore2(ETypeFile eTypeFile) {
		if(ETypeFile.PLAIN.equals(eTypeFile)) {
			this.loadFilePlain2();
		}
	}
	
	private void dumpFilePlain2() {
		String rutaArchivo = confValue.getPath().concat(confValue.getNameFileTXT2());
		List<String> records = new ArrayList<>();
		 for(Sale sale : ListSale){
			 StringBuilder contentSale = new StringBuilder();
			 contentSale.append(sale.getCode()).append(CommonConstants.SEMI_COLON);
			 contentSale.append(sale.getTotal()).append(CommonConstants.SEMI_COLON);
			 contentSale.append(sale.getSale_date()).append(CommonConstants.SEMI_COLON);
			 records.add(contentSale.toString());
		 }
		 this.writer(rutaArchivo, records);
	}
	
	private void loadFilePlain2() {
		List<String> contentInLine = this.reader(confValue.getPath().concat(confValue.getNameFileTXT2()));
		System.out.println(contentInLine.size());
		contentInLine.forEach(row -> {
			System.out.println(row);
			StringTokenizer tokens = new StringTokenizer(row, CommonConstants.SEMI_COLON);
			while(tokens.hasMoreElements()){
				String code = tokens.nextToken();
				String total = tokens.nextToken();
				//int total2 = Integer.parseInt(total);
				String sale_date = tokens.nextToken();
				ListSale.add(new Sale(code,total,sale_date));
			}
		});
	}
	
	public List<Sale> getListSale() {
		return ListSale;
	}
	public void setListSale(List<Sale> listSale) {
		ListSale = listSale;
	}

}
