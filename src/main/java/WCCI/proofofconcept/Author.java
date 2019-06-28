package WCCI.proofofconcept;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author {

	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(mappedBy = "author")
	private Collection<Post> posts = new ArrayList<Post>();
	//I don't know why adding " = new ArrayList<Post>()" is significant
	
	public void addPost(Post post) {
		this.posts.add(post);
		
	}
	private String name;

	public Author(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	protected Author(){
		
	}
	
	
	public String getName() {
		return name;
	}

	public Collection<Post> getPosts()	{
		return posts;
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
		Author other = (Author) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
	
	
}
