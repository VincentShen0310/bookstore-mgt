package service;

import java.util.List;

import common.Page;
import entity.Book;

public interface BookService {

	Book queryBookByID(int id);

	List<Book> queryAllBooks();

	void addOneBook(String name, String description, int status, int isDisplay,
			int authorId);

	void updateOneBook(int id,String name, String description, int status,
			int isDisplay,int authorId);

	List<Book> queryBooksByCondition(String name, String description, int status,
			int isDisplay, String authorName,Page page);
	
}
