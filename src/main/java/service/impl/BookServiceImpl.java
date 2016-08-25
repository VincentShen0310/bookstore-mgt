package main.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.dao.BookDAO;
import main.java.entity.Book;
import main.java.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDAO;

	public Book queryBookByID(int id) {
		return bookDAO.queryBookByID(id);
	}

	public List<Book> queryAllBooks() {
		return bookDAO.queryAllBooks();
	}

	public void addOneBook(String name, String description, int status,
			int isDisplay, int authorId) {
		bookDAO.addOneBook(name, description, status, isDisplay, authorId);

	}

	public void updateOneBook(int id,String name, String description, int status,
			int isDisplay,int authorId) {
		bookDAO.updateOneBook(id,name, description, status, isDisplay,authorId);
	}

	public List<Book> queryBooksByCondition(String name, String description,
			int status, int isDisplay,String authorName) {
		return bookDAO.queryBooksByCondition(name, description, status, isDisplay,authorName);
	}
	
}
