package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.Page;
import dao.AuthorDAO;
import entity.Author;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
public class AuthorDAOTest {
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
	
	@Test
	public void testQueryAuthorsByCondition(){
		Map<String, Object> map=new HashMap<String, Object>();
		Page page=new Page();
		page.setCurrentPage(1);
		Author author=new Author();
		author.setName("奎恩");
		map.put("author", author);
		map.put("page", page);
		System.out.println("THE MAP INFO IS "+map);
		System.out.println("THE AUTHOR INFO IS "+author.getName());
		System.out.println("THE PAGE INFO IS "+page.getCurrentPage());
		List<Author> list=authorDAO.queryAuthorsByCondition(map);
		for (Author author2 : list) {
			System.out.println("THE AUTHOR IS "+author2.getName()+", and THE AUTHOR D IS "+author2.getDescription());
		}
		System.out.println("THE SEARCH INFO IS "+list);
	}
}
