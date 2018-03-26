package testdatamodels;

import java.util.ArrayList;

public class SearchCriteria {
	ArrayList<String> brands;
	String minPrice;

	public SearchCriteria() {
	}

	public ArrayList<String> getBrands() {
		return brands;
	}

	public void setBrands(ArrayList<String> brands) {
		this.brands = brands;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}

}
