package WCCI.proofofconcept;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long>{

}


//aaron said I would need a h2 dependency