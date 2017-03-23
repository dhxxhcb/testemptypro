package com.xoa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {
	private static final long serialVersionUID = -8210551658849840411L;

	/**
	 * ID
	 */
	@Id
	@Column(name = "UID")
	private Integer ID;

	/**
	 * 登陆账号
	 */
	@Column(name = "USER_ID")
	private String login;

	/**
	 * 密码
	 */
	@Column(name = "PASSWORD")
	private String passWord;

	/**
	 * ID
	 * @return
	 */
	public Integer getID() {
		return ID;
	}

	/**
	 * ID
	 * @param iD
	 */
	public void setID(Integer iD) {
		ID = iD;
	}
	
	/**
	 * 登录账号
	 * @return
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * 登录账号
	 * @param login
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
	/**
	 * 密码
	 * @return
	 */
	public String getPassWord() {
		return passWord;
	}
	
	/**
	 * 密码
	 * @param passWord
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	

}
