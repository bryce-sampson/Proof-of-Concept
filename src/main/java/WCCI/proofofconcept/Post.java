package WCCI.proofofconcept;

public class Post {
	String Title;
	Author author;
	Genre genre;
	String PublishDate;
	String Body;
	String Tags;
	
	public Post( String title,Author author, Genre genre, String publishDate, String body) {
		super();
		Title = title;
		this.author = author;
		this.genre = genre;
		PublishDate = publishDate;
		Body = body;
	}
	public String getTitle() {
		return Title;
	}
	public String getBody() {
		return Body;
	}
//	public String getAuthor() {
//		return Author;
//	}
	public String getPublishDate() {
		return PublishDate;
	}
//	public String getGenre() {
//		return Genre;
//	}
	public String getTags() {
		return Tags;
	}


}
