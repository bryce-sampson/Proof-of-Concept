package WCCI.proofofconcept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements CommandLineRunner {
	
	@Autowired
	private GenreRepository genreRepo;
	
	@Autowired
	private AuthorRepository authorRepo;
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private PostTagRepository postTagRepo;
	
	@Override
	public void run(String... args) throws Exception {

		authorRepo.save(new Author("dan"));
		//update save feature of genre and post and add tag
		Genre punk = new Genre("punk");
		genreRepo.save(punk);
		PostTag guitar = new PostTag("guitar");
		postTagRepo.save(guitar);
		postRepo.save(new Post("title", authorRepo.findByName("dan"), punk, "date", "body"));
	}

}
