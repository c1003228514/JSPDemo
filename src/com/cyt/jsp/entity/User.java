package com.cyt.jsp.entity;

public class User {
	private Integer userId;
	private String username;
	private String password;
	private String sex;
	private String headImg;
	private String admin;
	private String tel;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public User(Integer userId, String username, String password, String sex, String headImg, String admin,
			String tel) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.headImg = headImg;
		this.admin = admin;
		this.tel = tel;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
}
