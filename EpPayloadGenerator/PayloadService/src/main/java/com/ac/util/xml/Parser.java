package com.ac.util.xml;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

public class Parser {
	
	private static Parser me;
	private static BidirectionMap map;
	
	public static Parser getInstance() {
		if (me == null) {
			me = new Parser();
			map = ClassMapper.initMap();
		}
		return me;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String parseObj(Object obj) throws JAXBException {
		String result="";
		if (obj!=null) {
			Class c = obj.getClass();
			final JAXBContext context = JAXBContext.newInstance(c.getPackage().getName());
			// Create a stringWriter to hold the XML
			final StringWriter stringWriter = new StringWriter();

			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new EpNamespacePrefixMapper());
			marshaller.marshal(new JAXBElement(getQName(c), c, obj), stringWriter);

			result = stringWriter.toString();
			//Remove type
			result = result.replaceAll(" (.{2,5}):type=\"(.+):(.+)\" ","");
		}
		return result;
	}

	@SuppressWarnings("rawtypes")
	private QName getQName(Class in) {

		QName result;
		String tag = map.getQName(in);	
		String tagName=tag;
		
         if(tagName.contains("/")){
        	 tagName=map.getValue(in);
         }
		if(tag != null)
			result = new QName(ClassMapper.ns+tag,tagName);
		else
			result = new QName(ClassMapper.ns+"Object","Object");
		
		return result;
	}
	
}
