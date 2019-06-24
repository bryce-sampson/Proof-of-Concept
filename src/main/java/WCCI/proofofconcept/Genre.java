package WCCI.proofofconcept;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genre {
	
	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(mappedBy = "genre")
	private Collection<Post> posts;
	
	private String name;

	public Genre(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	protected Genre() {
		
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
		Genre other = (Genre) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
}
