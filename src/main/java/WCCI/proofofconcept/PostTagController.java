package WCCI.proofofconcept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/postTag")
public class PostTagController {

	@Autowired
	private PostTagRepository postTagRepo;
	
	@RequestMapping("")
	public String renderPostTagsAll(Model model) {
		model.addAttribute("postTagsModel", postTagRepo.findAll());
		return "tagsView";
	}
	@RequestMapping("/{name}")
	public String renderOnePostTag(@PathVariable("name") String name, Model model) {
	model.addAttribute("postTagModel", postTagRepo.findByName(name));
	return "singleTagView";
	}
	// had trouble getting these to work
	@PostMapping("/add/{name}")
        public String addPostTag(@PathVariable("name") String name) {
		PostTag postTagToAdd = new PostTag(name);
		postTagRepo.save(postTagToAdd);
		return "redirect:/postTag/" + postTagToAdd.getName();
	}
	
	}

