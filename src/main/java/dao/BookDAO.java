package main.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import main.java.entity.Book;

public interface BookDAO {
	//根据ID查询图书信息
	Book queryBookByID(@Param("id") int id);
	
	//查询所有图书信息
	List<Book> queryAllBooks();

	//插入图书
	void addOneBook(@Param("name") String name,
			@Param("description") String description,
			@Param("status") int status, @Param("isDisplay") int isDisplay,
			@Param("authorId") int authorId);
	
	//编辑图书
	void updateOneBook(@Param("name") String name,
			@Param("description") String description,
			@Param("status") int status, @Param("isDisplay") int isDisplay,
			@Param("authorId") int authorId);
}
