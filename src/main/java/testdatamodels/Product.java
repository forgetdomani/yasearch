package testdatamodels;

public class Product{

	String name;
	String brand;

	public Product(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public boolean equals(Product p) {
		 return name.equals(p.getName());
	}

}
