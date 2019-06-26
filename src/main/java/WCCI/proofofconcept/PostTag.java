package WCCI.proofofconcept;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class PostTag {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany(mappedBy = "postTag")
	private Collection<Post> posts = new ArrayList<Post>();

	public void addPost(Post post) {
		this.posts.add(post);
		
	}
	private String name;

	public PostTag(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	protected PostTag() {

	}

	public String getName() {
		return name;
	}

	public Collection<Post> getPosts() {
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
		PostTag other = (PostTag) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}