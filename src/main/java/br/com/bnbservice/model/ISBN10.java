package br.com.bnbservice.model;

public class ISBN10 {
	private String[] item;

	public String[] getItem() {
		return item;
	}

	public void setItem(String[] item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "ClassPojo [item = " + item + "]";
	}
}
