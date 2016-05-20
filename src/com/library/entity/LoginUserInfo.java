package com.library.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.library.domain.AbstractModel;
import com.library.enums.UserType;

public class LoginUserInfo {
	
	private AbstractModel model;

	private String sessionId;

	private Date loginTime;

	private String loginIp;

	private Map<Integer, SysFunc> sysFunc;

	private Map<String, SysFunc> urlFunc;

	/**
	 * 用户类型
	 */
	private UserType userType;

	public AbstractModel getModel() {
		return model;
	}

	public void setModel(AbstractModel model) {
		this.model = model;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Map<Integer, SysFunc> getSysFunc() {
		return sysFunc;
	}

	public void setSysFunc(Map<Integer, SysFunc> sysFunc) {
		this.sysFunc = sysFunc;
	}

	public Map<String, SysFunc> getUrlFunc() {
		return urlFunc;
	}

	public void setUrlFunc(Map<Integer, SysFunc> sysFunc) {
		this.urlFunc = new HashMap<String, SysFunc>();
		Set<Integer> keySet = sysFunc.keySet();
		for (Integer key : keySet) {
			SysFunc temp = sysFunc.get(key);
			this.urlFunc.put(temp.getUrl(), temp);
		}
	}

	@Override
	public String toString() {
		return "LoginUserInfo [model=" + model + ", sessionId=" + sessionId + ", loginTime=" + loginTime + ", loginIp="
				+ loginIp + ", userType=" + userType + "]";
	}

}
