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
	private Genre genre;


	@RequestMapping("")
	public String findAllPostByAuthor(Model model) {
		model.addAttribute("authorModel", postRepo.findAll());
		return "singleAuthorView";
	}

	@RequestMapping({"/post/{id}"})
	public String findPostById(@PathVariable("id") Long id, Model model) {
		model.addAttribute("postModel", postRepo.findById(id));
		return "singlePostView";
	}

	@PostMapping("/add")
	public String addPost(Author author) {
		Post postToAdd = new Post("", author, genre, "", "");
		if (postRepo.findById(postToAdd.getId()) == null) {
			postRepo.save(postToAdd);
		}
		return "redirect:/post/{id}";
		
	}
	
	
	
	
	
	
	
	
	
	
}
