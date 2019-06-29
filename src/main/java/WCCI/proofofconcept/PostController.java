package WCCI.proofofconcept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/author")
public class PostController {

	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private AuthorRepository authorRepo;
	
	@Autowired
	private GenreRepository genreRepo;

	@RequestMapping("")
	public String renderAuthorsAll(Model model) {
		model.addAttribute("authorsModel", authorRepo.findAll());
		return "authorsView";
	}

	@RequestMapping("{id}")
	public String findAllPostByAuthor(@PathVariable ("id") Long id, Model model) {
		model.addAttribute("authorModel", authorRepo.findById(id).get());
		model.addAttribute("postsModel", authorRepo.findById(id).get().getPosts());
		return "singleAuthorView";
	}

	@RequestMapping({"/post/{id}"})
	public String findPostById(@PathVariable("id") Long id, Model model) {
		model.addAttribute("postModel", postRepo.findById(id).get());
		model.addAttribute("postsModel", postRepo.findById(id).get().getAuthor());
		return "singlePostView";
	}

	@PostMapping("/add/post/")
	public String addPost(String title, Author author, Genre genre, String publishDate, String body) {
		Post postToAdd = new Post(title, author, genre, publishDate, body);
		postRepo.save(postToAdd);
		return "redirect:/author/post" + postToAdd.getId();
		
	}
	
//	changed from post to author, posted need a object to be made, the author was easier
	@PostMapping("/add/{name}")
	public String addAuthor(@PathVariable("name") String name) {
		Author authorToAdd = new Author(name);
		authorRepo.save(authorToAdd);
		return "redirect:/";
		
	}

	
}
