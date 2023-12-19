package th.ac.ku.eng.kps.cpe.lab1.model;

import java.util.*;

public class BookStore2 {
	private String title;
	private List<String> author;
	private List<String> catagory;
	private int year;
	private Byte edition;
	private double price;
	private String isbn;
	private String language;
	
	public BookStore2() {
		this.title = "";
		this.edition = 0;
		this.author = new ArrayList<String>();
		this.catagory= new ArrayList<String>();
		this.language= "";
	}

	public void setIsbn(String string) {
		this.isbn = string;
	}
	public String getIsbn() {
		return this.isbn;
	}

	public void setTitle(String string) {
		this.title = string;
	}
	public String getTitle() {
		return this.title;
	}

	public void setAuthor(String string) {
		this.author.add(string);
	}
	public List<String> getAuthor() {
		return this.author;
	}

	public void setCatagory(String string) {
		this.catagory.add(string);
	}
	public List<String> getCatagory() {
		return this.catagory;
	}

	public void setEdition(byte b) {
		this.edition = b;
	}
	public Byte getEdition() {
		return this.edition;
	}

	public void setYear(int i) {
		this.year = i;
	}
	public int getYear() {
		return this.year;
	}

	public void setPrice(double d) {
		this.price = d;
		
	}
	public double getPrice() {
		return this.price;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
}