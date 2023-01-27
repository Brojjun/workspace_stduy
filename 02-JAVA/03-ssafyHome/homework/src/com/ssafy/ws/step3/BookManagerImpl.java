package com.ssafy.ws.step3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 도서리스트를 컬렉션으로 유지하며 관리하는 클래스
 */
public class BookManagerImpl implements IBookManager{

	List<Book>books = new ArrayList<>();
	private IBookManager ib = new BookManagerImpl();
	
	private BookManagerImpl() {
		super();
	}

	public IBookManager getInstance() {
		return this.ib;
	}
	
	@Override
	public void add(Book book) {
		// TODO Auto-generated method stub
		this.books.add(book);
	}

	@Override
	public void remove(String isbn) {
		// TODO Auto-generated method stub
		for(int i = this.books.size(); i >= 0; i--) 
			if(this.books.get(i).getIsbn().equals(isbn)) 
				this.books.remove(i);
		
	}

	@Override
	public Book[] getList() {
		// TODO Auto-generated method stub
		Book[] immBooks = books.toArray(new Book[books.size()]);
		return immBooks;
	}

	@Override
	public Book searchByIsbn(String isbn) {
		// TODO Auto-generated method stub
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getIsbn().equals(isbn))
				return books.get(i);
		}
		return null;
	}

	@Override
	public Book[] searchByTitle(String title) {
		// TODO Auto-generated method stub
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getTitle().equals(title))
				return books.get(i);
		}
		return null;
	}

	@Override
	public Magazine[] getMagazines() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book[] getBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPriceAvg() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void sell(String isbn, int quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buy(String isbn, int quantity) {
		// TODO Auto-generated method stub
		
	}

	private void loadData() {
		
	}
	
	@Override
	public void saveData() {
		// TODO Auto-generated method stub
		
	}
	//코드를 작성해주세요. 
}
