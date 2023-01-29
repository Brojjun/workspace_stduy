package com.ssafy.ws.step3;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 도서리스트를 컬렉션으로 유지하며 관리하는 클래스
 */
public class BookManagerImpl implements IBookManager {

	List<Book> books = new ArrayList<>();
	private static IBookManager ib = new BookManagerImpl();

	BookManagerImpl() {
		super();
	}

	public static IBookManager getInstance() {
		return ib;
	}

	@Override
	public void add(Book book) {
		// TODO Auto-generated method stub
		this.books.add(book);
	}

	@Override
	public void remove(String isbn) {
		// TODO Auto-generated method stub
		for (int i = this.books.size(); i >= 0; i--)
			if (this.books.get(i).getIsbn().equals(isbn))
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
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getIsbn().equals(isbn))
				return books.get(i);
		}
		return null;
	}

	@Override
	public Book[] searchByTitle(String title) {
		// TODO Auto-generated method stub
		Book[] immBooks = new Book[books.size()];
		int cnt = 0;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getTitle().equals(title))
				immBooks[cnt++] = books.get(i);
		}
		return immBooks;
	}

	@Override
	public Magazine[] getMagazines() {
		// TODO Auto-generated method stub
		Magazine[] magazines = new Magazine[books.size()];
		int cnt = 0;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i) instanceof Magazine)
				magazines[cnt++] = (Magazine) books.get(i);
		}
		return magazines;
	}

	@Override
	public Book[] getBooks() {
		// TODO Auto-generated method stub
		Book[] immBooks = new Book[books.size()];
		int cnt = 0;
		for (int i = 0; i < books.size(); i++) {
			if (!(books.get(i) instanceof Magazine))
				immBooks[cnt++] = books.get(i);
		}
		return immBooks;
	}

	@Override
	public int getTotalPrice() {
		// TODO Auto-generated method stub
		int price = 0;
		for (int i = 0; i < books.size(); i++) {
			price += books.get(i).getPrice();
		}
		return price;
	}

	@Override
	public double getPriceAvg() {
		// TODO Auto-generated method stub
		int price = 0;
		for (int i = 0; i < books.size(); i++) {
			price += books.get(i).getPrice();
		}
		return price / books.size();
	}

	@Override
	public void sell(String isbn, int quantity) {
		// TODO Auto-generated method stub]
		// 원하는 기능이 적혀있지 않습니다. 

	}

	@Override
	public void buy(String isbn, int quantity) {
		// TODO Auto-generated method stub
		// 원하는 기능이 적혀있지 않습니다. 

	}
	//역직렬화
	public void loadData() {
		try {
			
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.dat"));
            books = (List<Book>) ois.readObject();
            ois.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("더이상 도서 없음");
		}		
	}

	//직렬화
	@Override
	public void saveData() {
		// TODO Auto-generated method stub
		try {
          ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.dat"));
          oos.writeObject(books);
          oos.close();
          
		} catch(IOException e){
			e.printStackTrace();
		}

	}
	// 코드를 작성해주세요.
}
