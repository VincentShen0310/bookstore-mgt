package main.java.service;

import java.util.List;
import main.java.entity.Book;

public interface BookService {

	Book queryBookByID(int id);

	List<Book> queryAllBooks();

	void addOneBook(String name, String description, int status, int isDisplay,
			int authorId);

	void updateOneBook(String name, String description, int status,
			int isDisplay, int authorId);

}
