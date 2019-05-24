package br.com.bnbservice.model;

public class Publication {
	private String href;

	private String label;

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "ClassPojo [href = " + href + ", label = " + label + "]";
	}
}