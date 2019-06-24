package WCCI.proofofconcept;

import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {
	//to use the findByName method here he need the name string to be Name not genName, this default method expects
	// the attribute string to be called Name
	Genre findByName(String Name);
}
