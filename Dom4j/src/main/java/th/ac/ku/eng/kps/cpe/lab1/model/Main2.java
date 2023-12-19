package th.ac.ku.eng.kps.cpe.lab1.model;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.*;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Main2 {
	public static void main(String[] args) throws Exception {
		
		List<BookStore2> bl= new ArrayList<BookStore2>();
		
		BookStore2 b = new BookStore2() ;
		b.setIsbn("0123456001");
		b.setTitle("Java For Dummies");
		b.setAuthor("Tan Ah Teck");
		b.setCatagory("Programming");
		b.setYear(2009);
		b.setEdition((byte)7);
		b.setPrice(19.99);
		
		bl.add(b);
		
		BookStore2 b2 = new BookStore2() ;
		b2.setIsbn("0123456002");
		b2.setTitle("Java For Dummies");
		b2.setAuthor("Tan Ah Teck");
		b2.setCatagory("Programming");
		b2.setYear(2008);
		b2.setPrice(25.99);
		
		bl.add(b2);
		
		BookStore2 b3 = new BookStore2() ;
		b3.setIsbn("0123456010");
		b3.setTitle("The Complete Guide to Fishing");
		b3.setAuthor("Bill jones");
		b3.setAuthor("James Cook");
		b3.setAuthor("Mary Turning");
		b3.setCatagory("Fishing");
		b3.setCatagory("Leisure");
		b3.setLanguage("Frence");
		b3.setYear(2000);
		b3.setEdition((byte)2);
		b3.setPrice(49.99);
		bl.add(b3);
		
		Document doc = DocumentFactory.getInstance().createDocument();
		doc.addComment("bookstore2.xml");
		
		Element bookstore = doc.addElement("bookstore");
		

		for(BookStore2 blk : bl) {
			Element book = bookstore.addElement("book");
			book.addAttribute("ISBN", blk.getIsbn());
			
			Element elem = book.addElement("title");
			elem.addText(blk.getTitle());
			
			if(!blk.getAuthor().isEmpty()) {
			for(String au : blk.getAuthor()) {
				elem = book.addElement("author");
				elem.addText(au);
			}}
			
			if(!blk.getCatagory().isEmpty()) {
			for(String cat : blk.getCatagory()) {
				elem = book.addElement("catagory");
				elem.addText(cat);
			}}

			
			elem = book.addElement("year");
			elem.addText(Integer.toString(blk.getYear()));
			
			
			if(blk.getEdition()!=0) {
			elem = book.addElement("edition");
			elem.addText(Byte.toString(blk.getEdition()));
			}
			
			elem = book.addElement("price");
			elem.addText(Double.toString(blk.getPrice()));
			
			
		}
		
		
		
		
		
		

		FileOutputStream fos = new FileOutputStream("bookstore2.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(fos, format);
		writer.write(doc);
		writer.flush();
		writer.close();
		fos.close();

		
		
		
	}
}