package main.java.dao;

import java.util.List;
import java.util.Map;

import main.java.entity.Author;

import org.apache.ibatis.annotations.Param;

public interface AuthorDAO {

	// 根据ID查询作者信息
	Author queryAuthorByID(@Param("id") int id);

	// 查询所有作者信息
	List<Author> queryAllAuthors(@Param("offset") int offset,
			@Param("limit") int limit);

	// 插入信息
	void addOneAuthor(@Param("name") String name,
			@Param("description") String description,
			@Param("status") int status, @Param("isDisplay") int isDisplay,
			@Param("updateUser") int updateUser);

	// 修改信息
	void updateOneAuthor(@Param("id") int id, @Param("name") String name,
			@Param("description") String description,
			@Param("status") int status, @Param("isDisplay") int isDisplay);

	//根据条件查询信息
	List<Author> queryAuthorsByCondition(Map<String,Object> map);
	
//	List<Author> queryAuthorsByCondition(@Param("name") String name,
//	@Param("description") String description,
//	@Param("status") int status, @Param("isDisplay") int isDisplay);
	
}
