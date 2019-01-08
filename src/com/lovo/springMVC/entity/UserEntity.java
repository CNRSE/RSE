package com.lovo.springMVC.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="zc_user")
public class UserEntity {

	/**用户ID*/
	@Id
	@Column(length=32)
	@GenericGenerator(name="uuuid",strategy="uuid")
	@GeneratedValue(generator="uuuid")
	private String userId;
	
	@Column(length=32)
	private String username;
	@Column(length=32)
	private String password;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
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
}
