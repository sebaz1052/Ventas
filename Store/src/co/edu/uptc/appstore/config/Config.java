package co.edu.uptc.appstore.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
private static Config config; //se cre una instancia de la misma clase
private Properties propiedades;
private String path;
private String nameFileTXT;
private String nameFileTXT2;

private Config() {
	this.propiedades= new Properties();
	try (FileInputStream entrada = new FileInputStream("resources/conf/appconfig.properties")) {
        propiedades.load(entrada);
        this.path = propiedades.getProperty("app.file.path.txt");
        this.nameFileTXT = propiedades.getProperty("app.file.name.txt");
        this.nameFileTXT2 = propiedades.getProperty("app.file.name2.txt");;
    } catch (IOException ex) {
        System.err.println("Error al cargar el archivo properties de configuracion: " + ex.getMessage());
    }
}
public static Config getInstance() {
	if (config==null) {
		config= new Config();
	}
	return config;
}
public Properties getPropiedades() {
	return propiedades;
}
public void setPropiedades(Properties propiedades) {
	this.propiedades = propiedades;
}
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}
public String getNameFileTXT() {
	return nameFileTXT;
}
public void setNameFileTXT(String nameFileTXT) {
	this.nameFileTXT = nameFileTXT;
}
public String getNameFileTXT2() {
	return nameFileTXT2;
}
public void setNameFileTXT2(String nameFileTXT2) {
	this.nameFileTXT2 = nameFileTXT2;
}


}
