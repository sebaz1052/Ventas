package co.edu.uptc.appstore.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import co.edu.uptc.appstore.config.Config;
import co.edu.uptc.appstore.constants.CommonConstants;

public class FilePlain {
	protected Config confValue;
	
	public FilePlain () {
		confValue= Config.getInstance();
	}
	private String readFile(String rutaNombre) {
		StringBuilder contenido = new StringBuilder();
        try {
            FileReader fr = new FileReader(rutaNombre);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append(CommonConstants.NEXT_LINE);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Se presento un error al leer el archivo especificado1");
        }
        return contenido.toString();
	}
        public void writeFile(String rutaNombreArchivo ,String content){
        	 try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaNombreArchivo))){
             	writer.write(content);
         } catch (IOException e) {
             System.out.println("Error al escribir en el archivo:" + e.getMessage());
         }
        }
        protected List<String> reader(String rutaNombre){
    		List<String> output = new ArrayList<>();
    		StringTokenizer tokens = new StringTokenizer(this.readFile(rutaNombre), CommonConstants.NEXT_LINE);
    		while (tokens.hasMoreElements()) { 
    			output.add(tokens.nextToken());
    		}
    		return output;
    	}
        protected void writer(String rutaNombre, List<String> file){
    		StringBuilder strContent = new StringBuilder();
    		file.forEach(record -> strContent.append(record).append(CommonConstants.NEXT_LINE));
    		writeFile(rutaNombre, strContent.toString());
    	}
    	
}


   		
