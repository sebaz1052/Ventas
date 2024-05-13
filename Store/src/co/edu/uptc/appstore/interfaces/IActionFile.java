package co.edu.uptc.appstore.interfaces;


import co.edu.uptc.appstore.enums.ETypeFile;

public class IActionFile {
	public interface IActionsFile {
		public void dumpFile(ETypeFile eTypeFile);
		public void loadStore(ETypeFile eTypeFile);
	}
}
