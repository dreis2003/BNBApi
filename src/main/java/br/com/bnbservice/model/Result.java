package br.com.bnbservice.model;

public class Result {

	private PrimaryTopic primaryTopic;

	private String label;

	public PrimaryTopic getPrimaryTopic() {
		return primaryTopic;
	}

	public void setPrimaryTopic(PrimaryTopic primaryTopic) {
		this.primaryTopic = primaryTopic;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Result [primaryTopic=" + primaryTopic + ", label=" + label + "]";
	}

}