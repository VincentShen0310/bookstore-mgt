package service;

import java.util.List;

import common.Page;
import entity.Author;

public interface AuthorService {

	Author queryAuthorByID(int id);

	List<Author> queryAllAuthors(int offset, int limit);
	
	void addOneAuthor(String name, String description, int status,
			int isDisplay, int updateUser);

	void updateOneAuthor(int id,String name, String description, int status,
			int isDisplay);
	
	List<Author> queryAuthorsByCondition(String name,String description,int status,int isDisplay, Page page);
	
}
