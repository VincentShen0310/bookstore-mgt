package main.java.service.impl;

import java.util.List;

import main.java.dao.AuthorDAO;
import main.java.entity.Author;
import main.java.service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	private AuthorDAO authorDAO;
	
	public Author queryAuthorByID(int id) {
		return authorDAO.queryAuthorByID(id);
	}

	public List<Author> queryAllAuthors() {
		return authorDAO.queryAllAuthors(0, 100);
	}

	public void addOneAuthor(String name, String description, int status,
			int isDisplay, int updateUser) {
		authorDAO.addOneAuthor(name, description, status, isDisplay, updateUser);
	}

	public void updateOneAuthor(int id, String name, String description,
			int status, int isDisplay) {
		authorDAO.updateOneAuthor(id, name, description, status, isDisplay);
	}
	
	public List<Author> queryAuthorsByCondition(String name,
			String description, int status, int isDisplay) {
		return authorDAO.queryAuthorsByCondition(name, description, status, isDisplay);
	}
}
