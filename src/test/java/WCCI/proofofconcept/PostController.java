package WCCI.proofofconcept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/author/post")
public class PostController {
	
	@Autowired
	private PostRepository postRepo;
	
	@RequestMapping({"{id}"})
	public String findPostById(@PathVariable("id") Long id,Model model) {
		model.addAttribute("postModel", postRepo.findById(id));
		return "singlePostView";
		
		
	}
	

}
