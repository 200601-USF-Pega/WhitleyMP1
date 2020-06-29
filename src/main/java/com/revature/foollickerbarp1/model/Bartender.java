package com.revature.foollickerbarp1.model;

import com.revature.foollickerbarp1.model.Account;

public class Bartender extends Account {

	String username;
	double tipAmount;

	public Bartender() {
	}

	public Bartender(String userName, double tipAmount) {
		super();
		this.username= userName;
		this.tipAmount = tipAmount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getTipAmount() {
		return tipAmount;
	}

	public void setTipAmount(double tipAmount) {
		this.tipAmount = tipAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(tipAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		if (Double.doubleToLongBits(tipAmount) != Double.doubleToLongBits(other.tipAmount))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}