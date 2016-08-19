package main.java.entity;

/*
 * 作者信息
 */

import java.util.Date;

public class Author {

	private int id;
	private String name;
	private String description;
	private int status;
	private int isDisplay;

	private Date updateTime;
	private int updateUser;

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
		return "Author [id=" + id + ", name=" + name + ", description="
				+ description + ", status=" + status + ", isDisplay="
				+ isDisplay + ", updateTime=" + updateTime + ", updateUser="
				+ updateUser + "]";
	}

}
