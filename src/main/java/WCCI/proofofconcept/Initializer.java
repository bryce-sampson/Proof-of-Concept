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

		Author dan = new Author("dan");
		authorRepo.save(dan);
		Genre punk = new Genre("punk");
		genreRepo.save(punk);
		Post post = new Post("title", dan, punk, "date", "body");
		postRepo.save(post);
		PostTag guitar = new PostTag("guitar");
		postTagRepo.save(guitar);
	}

}
