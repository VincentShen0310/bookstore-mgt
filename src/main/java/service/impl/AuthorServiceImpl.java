package main.java.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.common.Page;
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

	public List<Author> queryAllAuthors(int offset,int limit) {
		return authorDAO.queryAllAuthors(offset, limit);
	}

	public void addOneAuthor(String name, String description, int status,
			int isDisplay, int updateUser) {
		authorDAO.addOneAuthor(name, description, status, isDisplay, updateUser);
	}

	public void updateOneAuthor(int id, String name, String description,
			int status, int isDisplay) {
		authorDAO.updateOneAuthor(id, name, description, status, isDisplay);
	}
	
//	public List<Author> queryAuthorsByCondition(String name,
//			String description, int status, int isDisplay) {
//		return authorDAO.queryAuthorsByCondition(name, description, status, isDisplay);
//	}
	
	public List<Author> queryAuthorsByCondition(String name,String description,int status,int isDisplay,Page page) {
		Map<String, Object> map=new HashMap<String, Object>();
		Author author=new Author();
		author.setName(name);
		author.setDescription(description);
		author.setStatus(status);
		author.setIsDisplay(isDisplay);
		map.put("author", author);
		map.put("page", page);
		return authorDAO.queryAuthorsByCondition(map);
	}
}
