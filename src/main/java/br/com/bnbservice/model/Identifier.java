package br.com.bnbservice.model;

public class Identifier {
	private String href;

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	@Override
	public String toString() {
		return "ClassPojo [href = " + href + "]";
	}
}