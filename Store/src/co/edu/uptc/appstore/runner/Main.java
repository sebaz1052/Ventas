package co.edu.uptc.appstore.runner;

import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.appstore.enums.ETypeFile;
import co.edu.uptc.appstore.model.Product;
import co.edu.uptc.appstore.model.Sale;
import co.edu.uptc.appstore.persistence.ManagementProduct;
import co.edu.uptc.appstore.persistence.ManagementSale;
import co.edu.uptc.appstore.runner.Main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		main.loadToFile();
		main.showContentPlain();
		main.loadToFile2();
		main.showContentPlain2();
		
	}
	public ManagementProduct loadToFile() {
		List<Product> prueba = new ArrayList<>();
		prueba.add(new Product("22255", "Crema", "8000", "2"));
		prueba.add(new Product("22256", "Shampoo", "10000", "3"));
		prueba.add(new Product("22257", "Desodorante", "6500", "4"));
		ManagementProduct management = new ManagementProduct();
		management.setListProduct(prueba);
		management.dumpFile(ETypeFile.PLAIN);
		return management;
	}
	
	public void showContentPlain() {
		ManagementProduct management = new ManagementProduct();		
		management.loadStore(ETypeFile.PLAIN);
		List<Product> product = management.getListProduct();
		product.forEach(System.out::println);	
		System.out.println("Existen: "+product.size()+" registros añadidos");
	}
	

	public ManagementSale loadToFile2() {
		List<Sale> proof = new ArrayList<>();
		proof.add(new Sale("22255", "8000", "27/04/2024"));
		proof.add(new Sale("22260", "9000", "27/04/2024"));
		proof.add(new Sale("22257", "10000", "27/04/2024"));
		ManagementSale management = new ManagementSale();
		management.setListSale(proof);
		management.dumpFile2(ETypeFile.PLAIN);
		return management;
	}
	
	public void showContentPlain2() {
		ManagementSale management = new ManagementSale();
		management.loadStore2(ETypeFile.PLAIN);
		List<Sale> sale = management.getListSale();
		sale.forEach(System.out::println);	
		System.out.println("Existen: "+sale.size()+" registros añadidos");	
	}

}
