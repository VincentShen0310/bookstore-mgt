package test.java.dao;

import java.util.List;

import main.java.dao.AuthorDAO;
import main.java.entity.Author;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
public class AuthorDAOTestNew {
	@Autowired
	private AuthorDAO authorDAO;
	
	@Test
	public void testAddOneAuthor(){
		String name="东野圭吾";
		String description="东野圭吾";
		int status=1;
		int isDisplay=1;
		int updateUser=1;
		authorDAO.addOneAuthor(name, description, status, isDisplay, updateUser);
	}
	
	@Test
	public void testQueryAuthorByID(){
		int id=3;
		Author author=new Author();
		author=authorDAO.queryAuthorByID(id);
		System.out.println(author);

	}
	
	@Test
	public void testQueryAllAuthors(){
		List<Author> list=authorDAO.queryAllAuthors(0, 10);
		for (Author author : list) {
			System.out.println(author);
		}
	}
	
	@Test
	public void testUpdateOneAuthor(){
		int id=2;
		String name="东野圭吾";
		String description="东野圭吾";
		int status=1;
		int isDisplay=1;
		authorDAO.updateOneAuthor(id, name, description, status, isDisplay);
	}
}
