package th.ac.ku.eng.kps.cpe.lab1.model;
import java.io.FileOutputStream;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class BookStore {
	static String ISBN;
	static String title;
	static String author;
	static String category;
	static int year;
	static byte edition;
	static double price;
	
public String getISBN() {
		return ISBN;
	}
public String getTitle() {
		return title;
	}
public String getAuthor() {
		return author;
	}
public String getCategory() {
		return category;
	}
public int getYear() {
		return year;
	}
public byte getEdition() {
		return edition;
	}
public double getPrice() {
		return price;
	}
public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
public void setTitle(String title) {
		this.title = title;
	}
public void setAuthor(String author) {
		this.author = author;
	}
public void setCategory(String category) {
		this.category = category;
	}
public void setYear(int year) {
		this.year = year;
	}
public void setEdition(byte edition) {
		this.edition = edition;
	}
public void setPrice(double price) {
		this.price = price;
	}
	public static void main(String[] args) throws Exception{
		
		BookStore b = new BookStore();
		b.setISBN("0123456001");
		b.setTitle("Java For Dummies");
		b.setAuthor("Tan Ah Teck");
		b.setCategory("Programming");
		b.setYear(2009);
		b.setEdition((byte)7);
		b.setPrice(19.99);
			
		Document doc = DocumentFactory.getInstance().createDocument();
		doc.addComment("bookstore.xml");
		
		Element bookstore = doc.addElement("bookstore");
		
		Element book =  bookstore.addElement("book");
		book.addAttribute("book" , b.getISBN());
		
		Element Title =  book.addElement("title");
		Title.addText(b.getTitle());
		
		Element Author =  book.addElement("author");
		Author.addText(b.getAuthor());
		
		Element Category =  book.addElement("category");
		Category.addText(b.getCategory());
		
		Element Year =  book.addElement("year");
		Year.addText(Integer.toString(b.getYear()));
		
		Element Edition =  book.addElement("edition");
		Edition.addText(Byte.toString(b.getEdition()));
		
		Element Price =  book.addElement("price");
		Price.addText(Double.toString(b.getPrice()));
		
		FileOutputStream fos = new FileOutputStream("BookStore.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(fos,format);
		writer.write(doc);
		writer.flush();
		writer.close();
		fos.close();
		}
	}

