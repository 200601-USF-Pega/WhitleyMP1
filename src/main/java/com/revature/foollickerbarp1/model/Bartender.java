package com.revature.foollickerbarp1.model;

import com.revature.foollickerbarp1.model.Account;

public class Bartender extends Account{
	
	private String codeName;
	private String userName;
	private String password;
	
	public Bartender(){}
	
	public Bartender(String codeName, String userName, String password) {
		super(codeName, userName, password);
		this.codeName = codeName;
		this.userName = userName;
		this.password = password;
	}
	
	public String getCodeName() {
		return codeName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codeName == null) ? 0 : codeName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bartender other = (Bartender) obj;
		if (codeName == null) {
			if (other.codeName != null)
				return false;
		} else if (!codeName.equals(other.codeName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
