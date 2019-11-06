/**
 * 
 */
package com.classes;

abstract class Document {

	protected String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Document() {
		this("Document...");
		System.out.println("Document->def");
	}

	public Document(String text) {
		setText(text);
		System.out.println("Document->param...");
	}

	public abstract void print();

	public abstract void open();

	public abstract void save();

	public abstract void close();
}

class Word extends Document {

	protected int pages;

	public Word(String text) {
		super(text);
		setPages(0);
	}

	public Word() {
		this("Word...");
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public void print() {
		System.out.println("Word printing...");
	}

	@Override
	public void open() {
		System.out.println("Word opening...");
	}

	@Override
	public void save() {
		System.out.println("Word saving...");
	}

	@Override
	public void close() {
		System.out.println("Word closing...");
	}

	public void addPage() {
		setPages(getPages() + 1);
	}

}

class Excel extends Document {

	protected int sheets;

	public Excel(String text) {
		super(text);
		setSheets(0);
	}

	public Excel() {
		this("Excel...");
	}

	public int getSheets() {
		return sheets;
	}

	public void setSheets(int pages) {
		this.sheets = pages;
	}

	@Override
	public void print() {
		System.out.println("Excel printing...");
	}

	@Override
	public void open() {
		System.out.println("Excel opening...");
	}

	@Override
	public void save() {
		System.out.println("Excel saving...");
	}

	@Override
	public void close() {
		System.out.println("Excel closing...");
	}

	public void addSheet() {
		setSheets(getSheets() + 1);
	}

}

class PowerPoint extends Document {

	protected int slides;

	public PowerPoint(String text) {
		super(text);
		setSlides(0);
	}

	public PowerPoint() {
		this("PowerPoint...");
	}

	public int getSlides() {
		return slides;
	}

	public void setSlides(int pages) {
		this.slides = pages;
	}

	@Override
	public void print() {
		System.out.println("PowerPoint printing...");
	}

	@Override
	public void open() {
		System.out.println("PowerPoint opening...");
	}

	@Override
	public void save() {
		System.out.println("PowerPoint saving...");
	}

	@Override
	public void close() {
		System.out.println("PowerPoint closing...");
	}

	public void addSlide() {
		setSlides(getSlides() + 1);
	}

}

class Pdf extends Document {

	protected int pages;

	public Pdf(String text) {
		super(text);
		setPages(0);
	}

	public Pdf() {
		this("Pdf...");
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public void print() {
		System.out.println("Pdf printing...");
	}

	@Override
	public void open() {
		System.out.println("Pdf opening...");
	}

	@Override
	public void save() {
		System.out.println("Pdf saving...");
	}

	@Override
	public void close() {
		System.out.println("Pdf closing...");
	}

	public void addPage() {
		setPages(getPages() + 1);
	}

}

class LaserPrinter {
	static int wordCount;
	static int excelCount;
	static int powerPointCount;
	static int documentCount;

	static void print(Word word) {
		++wordCount;
		word.print();
	}

	static void print(Excel excel) {
		++excelCount;
		excel.print();
	}

	static void print(PowerPoint powerPoint) {
		++powerPointCount;
		powerPoint.print();
	}

	static void print(Document document) {
		if (document instanceof Word)
			print((Word) document);
		else if (document instanceof Excel)
			print((Excel) document);
		else if (document instanceof PowerPoint)
			print((PowerPoint) document);
		else {
			++documentCount;
			document.print();
		}
	}
}

/**
 * @author Allianz3076
 *
 */
public class TestDocument {
	public static void main(String[] args) {
		Word word = new Word();
		Excel excel = new Excel();
		PowerPoint powerPoint = new PowerPoint();
		Pdf pdf = new Pdf();

		word.print();
		word.open();
		word.save();
		word.close();
		System.out.println("Word pages: " + word.getPages());
		word.addPage();
		System.out.println("Added page to Word");
		System.out.println("Word pages: " + word.getPages());

		excel.print();
		excel.open();
		excel.save();
		excel.close();
		System.out.println("Excel sheets: " + excel.getSheets());
		excel.addSheet();
		System.out.println("Added sheet to Excel");
		System.out.println("Excel sheets: " + excel.getSheets());

		powerPoint.print();
		powerPoint.open();
		powerPoint.save();
		powerPoint.close();
		System.out.println("PowerPoint slides: " + powerPoint.getSlides());
		powerPoint.addSlide();
		System.out.println("Added slide to PowerPoint");
		System.out.println("PowerPoint slides: " + powerPoint.getSlides());
		
		pdf.print();
		pdf.open();
		pdf.save();
		pdf.close();
		System.out.println("Pdf pages: " + pdf.getPages());
		pdf.addPage();
		System.out.println("Added page to Pdf");
		System.out.println("Pdf pages: " + pdf.getPages());
		
		Document[] docs = new Document[4];
		
		docs[0] = word;
		docs[1] = excel;
		docs[2] = powerPoint;
		docs[3] = pdf;
		
		for(Document doc: docs) {
			LaserPrinter.print(doc);
		}
		
		System.out.println("LaserPrinter.wordCount: " + LaserPrinter.wordCount);
		System.out.println("LaserPrinter.excelCount: " + LaserPrinter.excelCount);
		System.out.println("LaserPrinter.powerPointCount: " + LaserPrinter.powerPointCount);
		System.out.println("LaserPrinter.documentCount: " + LaserPrinter.documentCount);
		
		
		

	}
}
