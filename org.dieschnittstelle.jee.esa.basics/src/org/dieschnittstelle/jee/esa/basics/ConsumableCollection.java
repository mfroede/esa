package org.dieschnittstelle.jee.esa.basics;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ConsumableCollection {
	
	// the log4j logger	
	protected static Logger logger = Logger.getLogger(ConsumableCollection.class);

	// the file to read in
	private String collectionFilePath;
	
	// the builder to use for creating the consumables
	private IConsumableBuilder builder; 
	
	// the elements we will read in from the xml file
	private List<IConsumable> consumables = new ArrayList<IConsumable>();
	
	public ConsumableCollection(String collectionFilePath,IConsumableBuilder builder) {
		this.collectionFilePath = collectionFilePath;
		this.builder = builder;
	}
	
	public void load() {
		logger.debug("load()");
		
		try {
			// obtain the builtin document builder factory
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			// obtain a builder from the factory
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            
            // obtain an input stream for the document to be read in from the classpath
            InputStream is = getClass().getClassLoader().getResourceAsStream(collectionFilePath);
            logger.debug("obtained an input stream: " + is);
            
            Document doc = docBuilder.parse (is);
            logger.debug("read document from input stream: " + doc);
            
            // now we obtain all consumable elements from the file (for simplicity, we use string literals here, but note that constants would be more appropriate!)
            NodeList consumableElements  = doc.getElementsByTagName("consumable");
            logger.debug("got " + consumableElements.getLength() + " consumable elements");
            
            for (int i=0; i< consumableElements.getLength();i++) {
            	// let the builder create the consumable and add it to the list
            	consumables.add(builder.buildConsumableFromElement((Element)consumableElements.item(i)));
            }
            
            logger.debug("read in consumables: " + this.consumables);
		}
		catch (Exception e) {
			String err = "got exception trying to read in consumables: " + e;
			logger.error(err,e);
			throw new RuntimeException(err);
		}
	}	
	
	public List<IConsumable> getConsumables() {
		return this.consumables;
	}
	
}
