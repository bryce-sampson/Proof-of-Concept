package WCCI.proofofconcept;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Post {

	@ManyToOne
	private Author author;
	@ManyToOne
	private Genre genre;

	@Id
	@GeneratedValue
	private Long id;

	String title;
	String publishDate;
	String body;
	String tags;

	public Post(String title, Author author, Genre genre, String publishDate, String body) {
		super();
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.publishDate = publishDate;
		this.body = body;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

//	public String getAuthor() {
//		return Author;
//	}
	public String getPublishDate() {
		return publishDate;
	}

//	public Genre getGenre() {
//		return genre;
//	}
	public String getTags() {
		return tags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Post other = (Post) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
