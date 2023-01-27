package com.ssafy.ws.step3;

/**
 * 도서리스트를 관리하기 위한 클래스를 위한 명세역할의 인터페이스
 */
public interface IBookManager{
	//코드를 작성해주세요. 
	public void add(Book book);
	
	public void remove(String isbn) throws ISBNNotFoundException;
	
	public Book[] getList();
	
	public Book searchByIsbn(String isbn) throws ISBNNotFoundException;
	
	public Book[] searchByTitle(String title);
	
	public Magazine[] getMagazines();
	
	public Book[] getBooks();
	
	public int getTotalPrice();
	
	public double getPriceAvg();
	
	public void sell (String isbn, int quantity) throws QuantityException;
	
	public void buy(String isbn, int quantity)  throws QuantityException;
	
	public void saveData();
}
