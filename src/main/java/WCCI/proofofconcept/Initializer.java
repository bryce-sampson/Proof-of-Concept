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

		authorRepo.save(new Author("Young the Giant"));
		authorRepo.save(new Author("Ludwig van Beethoven"));
		authorRepo.save(new Author("Volbeat"));
		//update save feature of genre and post and add tag
		Genre alternative = new Genre("Alternative Rock");
		Genre classical = new Genre("Classical");
		Genre rock = new Genre("Rock");
		genreRepo.save(alternative);
		genreRepo.save(classical);
		genreRepo.save(rock);
		PostTag keyboard = new PostTag("Keyboard");
		PostTag piano = new PostTag("Piano");
		PostTag cowboyWestern = new PostTag("Cowboy Western");
		PostTag oldWestRock = new PostTag("Old West Rock");
		postTagRepo.save(keyboard);
		postTagRepo.save(piano);
		postTagRepo.save(cowboyWestern);
		postTagRepo.save(oldWestRock);
		postRepo.save(new Post("Cough Syrup", authorRepo.findByName("Young the Giant"), alternative, "2008", "Mellow guitar and cello contrast the sunny preceding tracks, the lyrics contemplate apathy and misdirection, and yet the chorus is still so compelling that you find yourself humming it hours later."));
		postRepo.save(new Post("Symphony No. 5", authorRepo.findByName("Ludwig van Beethoven"), alternative, "1808", "Radiant beams shoot through this region's deep night, and we become aware of gigantic shadows which, rocking back and forth, close in on us and destroy everything within us except the pain of endless longing—a longing in which every pleasure that rose up in jubilant tones sinks and succumbs, and only through this pain, which, while consuming but not destroying love, hope, and joy, tries to burst our breasts with full-voiced harmonies of all the passions, we live on and are captivated beholders of the spirits."));
		postRepo.save(new Post("Outlaw Gentlemen", authorRepo.findByName("Volbeat"), rock, "2016", "Why are these danish lads such fans of the old american western frontier"));
		postRepo.save(new Post("Guitar Gangsters", authorRepo.findByName("Volbeat"), rock, "2008", "this music was not in a saloon"));
		
	}

}
