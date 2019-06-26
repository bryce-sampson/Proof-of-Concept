package WCCI.proofofconcept;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Author author;
	@ManyToOne
	private Genre genre;
	@ManyToMany
	private List<PostTag> postTag;

	String title;
	String publishDate;
	String body;

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

	protected Post() {

	}

	public String getTitle() {
		return title;
	}

	public Author getAuthor() {
		return author;
	}

	public Genre getGenre() {
		return genre;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public String getBody() {
		return body;
	}

	public List<PostTag> getPostTag() {
		return postTag;
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
