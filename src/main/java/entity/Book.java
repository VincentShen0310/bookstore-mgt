package main.java.entity;

/*
 * 图书信息
 */
import java.util.Date;

public class Book {
	private int id;
	private String name;
	private String description;
	private int status;
	private int isDisplay;
	private int authorId;
	private Date updateTime;
	private int updateUser;
	private Author author;
	
 	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIsDisplay() {
		return isDisplay;
	}
	public void setIsDisplay(int isDisplay) {
		this.isDisplay = isDisplay;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public int getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(int updateUser) {
		this.updateUser = updateUser;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", description="
				+ description + ", status=" + status + ", isDisplay="
				+ isDisplay + ", authorId=" + authorId + ", updateTime="
				+ updateTime + ", updateUser=" + updateUser + ", author="
				+ author + "]";
	}
	
}
