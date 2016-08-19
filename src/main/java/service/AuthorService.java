package main.java.service;

import java.util.List;

import main.java.entity.Author;

public interface AuthorService {

	Author queryAuthorByID(int id);

	List<Author> queryAllAuthors();
	
	void addOneAuthor(String name, String description, int status,
			int isDisplay, int updateUser);

	void updateOneAuthor(int id,String name, String description, int status,
			int isDisplay);
	
}
