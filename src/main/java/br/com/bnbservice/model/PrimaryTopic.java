package br.com.bnbservice.model;

public class PrimaryTopic {

	private Author author;

	private Isbn isbn;

	private String label;

	private String title;

	private String datePublished;

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Isbn getIsbn() {
		return isbn;
	}

	public void setIsbn(Isbn isbn) {
		this.isbn = isbn;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDatePublished() {
		return datePublished;
	}

	public void setDatePublished(String datePublished) {
		this.datePublished = datePublished;
	}

	@Override
	public String toString() {
		return "PrimaryTopic [author=" + author + ", isbn=" + isbn + ", label=" + label + ", title=" + title
				+ ", datePublished=" + datePublished + "]";
	}

}