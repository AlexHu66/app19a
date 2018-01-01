package app19a.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app19a.domain.Book;
import app19a.domain.Category;

@Service
public class BookServiceImpl implements BookService{

	private List<Category> categories;
	private List<Book> books;
	
	public BookServiceImpl(){
		categories = new ArrayList<Category>();
		Category category1 = new Category(1, "Computing");
		Category category2 = new Category(2, "Travel");
		Category category3 = new Category(3, "Health");
		categories.add(category1);
		categories.add(category2);
		categories.add(category3);
		
		books = new ArrayList<Book>();
		books.add(new Book(1L, "9780980839623", "Servlet & JSP", category1, "Budi Kurniawan"));
		books.add(new Book(2L, "1236547895445", "c# A Beginner", category1, "Jayden Ky"));
	}
	public List<Category> getAllcategories() {
		return categories;
	}

	public Category getCategory(int id) {
		for(Category category:categories){
			if (id == category.getId()){
				return category;
			}
		}
		return null;
	}

	public List<Book> getAllBooks() {
		return books;
	}

	public Book save(Book book) {
		book.setId(getNextId());
		books.add(book);
		return book;
	}

	public Book update(Book book) {
		int bookCount = books.size();
		for(int i=0; i<bookCount; i++){
			Book saveBook = books.get(i);
			if(saveBook.getId()==book.getId()){
				books.set(i, book);
				return book;
			}
		}
		return null;
	}

	public Book get(long id) {
		for(Book book:books){
			if(id==book.getId()){
				return book;
			}
		}
		return null;
	}

	public long getNextId() {
		long id = 0L;
		for(Book book:books){
			long bookId = book.getId();
			if(bookId>id){
				id = bookId;
			}
		}
		return id+1;
	}

}
