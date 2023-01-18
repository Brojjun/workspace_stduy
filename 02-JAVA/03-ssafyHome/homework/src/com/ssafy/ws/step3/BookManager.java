package com.ssafy.ws.step3;

public class BookManager {
	private int MAX_SIZE = 10000;
	private Book[] books = new Book[MAX_SIZE];
	private int size = 0;
	
	public void add (Book book) {
		books[size++] = book;
	}
	
	public void remove (String isbn) {
		for (int i = 0; i < size; i++) {
			if(books[i] == null) continue;
			
			else if(isbn.equals(books[i].getIsbn())){
				books[i] = null;
			}
		}
	}
	
	public Book[] getList () {
		Book[] bk = new Book[size];
		for(int i = 0; i < this.size; i++) {
			bk[i] = books[i];
		}
		return bk;
	}
	
	public Book searchByisbn(String isbn) {
		for(int i = 0; i < size; i++) {
			if(books[i] == null) continue;
			if(isbn.equals(books[i].getIsbn()))
				return books[i];
		}
		return null;
	}
}
