package WCCI.proofofconcept;

import java.util.Collection;

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
	private PostRepository postRepo;
	
	@Autowired
	private PostTagRepository postTagRepo;
	
	@RequestMapping("")
	public String renderPostTagsAll(Model model) {
		model.addAttribute("postTagsModel", postTagRepo.findAll());
		return "tagsView";
	}
	@RequestMapping("/{name}")
	public String renderOnePostTag(@PathVariable("name") String name, Model model ) {
	model.addAttribute("postTagModel", postTagRepo.findByName(name));
	model.addAttribute("postTagListModel", postTagRepo.findByName(name).getPosts());
	return "singleTagView";
	}
	// had trouble getting these to work
	@PostMapping("/add")
        public String addPostTag(String name, Long id) throws Exception {
		Collection<PostTag> postTags = (Collection<PostTag>) postTagRepo.findAll();
		if(!postTags.contains(postTagRepo.findByName(name))) {
			postRepo.findById(id).get().addPostTag(postTagRepo.save(new PostTag(name)));
			postRepo.save(postRepo.findById(id).get());
		} else if (!postRepo.findById(id).get().getPostTag().contains(postTagRepo.findByName(name))) {
			postRepo.findById(id).get().addPostTag(postTagRepo.save(postTagRepo.findByName(name)));
			postRepo.save(postRepo.findById(id).get());
		}
		
		return "redirect:/postTag";
	}
	
	}

