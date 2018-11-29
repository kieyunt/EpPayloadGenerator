package com.ac.model.pm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ac.model.BaseEntity;

@Entity
@Table(name="PM_USER")
public class PmUser extends BaseEntity {

	@Id
	@Column(name = "USER_ID")
	private Long userId;

	@Column(name = "LOGIN_ID")
	private String loginId;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "DESIGNATION")
	private String designation;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
}
