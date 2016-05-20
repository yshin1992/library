
package com.library.domain;

/**
 * 图书管理员实体类
 * 
 * @author YanShuai
 * @version 1.0,2015年7月12日
 * @See
 * @since V1.0
 */
public class Manager implements AbstractModel {
	private static final long serialVersionUID = 4071354057780722536L;

	String managerID;

	String username;

	String password;

	String sex;

	String telephone;

	String email;

	/**
	 * 用户的状态 0为正常 1为已删除
	 */
	Boolean status;

	public String getManagerID() {
		return managerID;
	}

	public void setManagerID(String managerID) {
		this.managerID = managerID;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * 是否为超级管理员
	 */
	private Boolean isadmin;

	public Boolean getIsadmin() {
		return isadmin;
	}

	public void setIsadmin(Boolean isadmin) {
		this.isadmin = isadmin;
	}

	@Override
	public String toString() {
		return "Manager [managerID=" + managerID + ", username=" + username + ", password=" + password + ", sex=" + sex
				+ ", telephone=" + telephone + ", email=" + email + ", status=" + status + ", isadmin=" + isadmin + "]";
	}

}