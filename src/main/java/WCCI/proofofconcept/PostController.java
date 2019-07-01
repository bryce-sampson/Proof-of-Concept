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
	public String findAllPostByAuthor(@PathVariable("id") Long id, Model model) {
		model.addAttribute("authorModel", authorRepo.findById(id).get());
		model.addAttribute("authorsModel", authorRepo.findAll());
		model.addAttribute("postsModel", authorRepo.findById(id).get().getPosts());
		model.addAttribute("genresModel", genreRepo.findAll());
		return "singleAuthorView";
	}

	@RequestMapping({ "/post/{id}" })
	public String findPostById(@PathVariable("id") Long id, Model model, String name) {
		model.addAttribute("postModel", postRepo.findById(id).get());
		return "singlePostView";
	}

	@PostMapping("post")
	public String addPost(String title, Author author, String genreName, String publishDate, String body) {
		System.out.println("GENRE: " + genreName);
		Genre genreToLink = genreRepo.findByName(genreName);
		Post postToAdd = new Post(title, author, genreToLink, publishDate, body);
		postRepo.save(postToAdd);
		genreRepo.save(genreToLink);
		return "redirect:/author/" + postToAdd.getAuthor().getId();

	}

//    changed from post to author, posted need a object to be made, the author was easier
	@PostMapping("add")
	public String addAuthor(String name) {
		authorRepo.save(new Author(name));
		return "redirect:/author";

	}

}
