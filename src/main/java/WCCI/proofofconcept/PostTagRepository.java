package WCCI.proofofconcept;

import org.springframework.data.repository.CrudRepository;

public interface PostTagRepository extends CrudRepository<PostTag, Long> {
	
	PostTag findByName(String Name);
}
