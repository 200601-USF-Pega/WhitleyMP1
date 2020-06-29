package com.revature.foollickerbarp1.model;

public class Stock {

	private String alcoholType;
	private String alcoholName;
	private int alcoholContent;
	private int alcoholPrice;
	private int alcoholAmount;

	public Stock() {
	}

	public Stock(String alcoholType, String alcoholName, int alcoholContent, int alcoholPrice, int alcoholAmount) {
		this.alcoholType = alcoholType;
		this.alcoholName = alcoholName;
		this.alcoholContent = alcoholContent;
		this.alcoholPrice = alcoholPrice;
		this.alcoholAmount = alcoholAmount;
	}

	public int getAlcoholAmount() {
		return alcoholAmount;
	}

	public void setAlcoholAmount(int alcoholAmount) {
		this.alcoholAmount = alcoholAmount;
	}

	public String getAlcoholType() {
		return alcoholType;
	}

	public void setAlcoholType(String alcoholType) {
		this.alcoholType = alcoholType;
	}

	public String getAlcoholName() {
		return alcoholName;
	}

	public void setAlcoholName(String alcoholName) {
		this.alcoholName = alcoholName;
	}

	public int getAlcoholContent() {
		return alcoholContent;
	}

	public void setAlcoholContent(int alcoholContent) {
		this.alcoholContent = alcoholContent;
	}

	public int getAlcoholPrice() {
		return alcoholPrice;
	}

	public void setAlcoholPrice(int alcoholPrice) {
		this.alcoholPrice = alcoholPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + alcoholContent;
		result = prime * result + ((alcoholName == null) ? 0 : alcoholName.hashCode());
		result = prime * result + alcoholPrice;
		result = prime * result + ((alcoholType == null) ? 0 : alcoholType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		if (alcoholContent != other.alcoholContent)
			return false;
		if (alcoholName == null) {
			if (other.alcoholName != null)
				return false;
		} else if (!alcoholName.equals(other.alcoholName))
			return false;
		if (alcoholPrice != other.alcoholPrice)
			return false;
		if (alcoholType == null) {
			if (other.alcoholType != null)
				return false;
		} else if (!alcoholType.equals(other.alcoholType))
			return false;
		return true;
	}

}
