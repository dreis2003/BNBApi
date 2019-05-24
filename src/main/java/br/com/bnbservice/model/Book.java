package br.com.bnbservice.model;

public class Book {

	private String resultLabel;
	private String resultPrimaryTopicTitle;
	private String resultPrimaryTopicAuthorLabel;
	private String resultPrimaryTopicDatePublished;
	private String resultPrimaryTopicIsbn;

	public String getResultLabel() {
		return resultLabel;
	}

	public void setResultLabel(String resultLabel) {
		this.resultLabel = resultLabel;
	}

	public String getResultPrimaryTopicTitle() {
		return resultPrimaryTopicTitle;
	}

	public void setResultPrimaryTopicTitle(String resultPrimaryTopicTitle) {
		this.resultPrimaryTopicTitle = resultPrimaryTopicTitle;
	}

	public String getResultPrimaryTopicAuthorLabel() {
		return resultPrimaryTopicAuthorLabel;
	}

	public void setResultPrimaryTopicAuthorLabel(String resultPrimaryTopicAuthorLabel) {
		this.resultPrimaryTopicAuthorLabel = resultPrimaryTopicAuthorLabel;
	}

	public String getResultPrimaryTopicDatePublished() {
		return resultPrimaryTopicDatePublished;
	}

	public void setResultPrimaryTopicDatePublished(String resultPrimaryTopicDatePublished) {
		this.resultPrimaryTopicDatePublished = resultPrimaryTopicDatePublished;
	}

	public String getResultPrimaryTopicIsbn() {
		return resultPrimaryTopicIsbn;
	}

	public void setResultPrimaryTopicIsbn(String resultPrimaryTopicIsbn) {
		this.resultPrimaryTopicIsbn = resultPrimaryTopicIsbn;
	}

}