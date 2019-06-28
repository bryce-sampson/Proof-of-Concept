package WCCI.proofofconcept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/genre")
public class GenreController {

	@Autowired
	private GenreRepository genreRepo;

	@RequestMapping("")
	public String renderGenresAll(Model model) {
		model.addAttribute("genresModel", genreRepo.findAll());
		return "genresView";
	}

	@RequestMapping("/{name}")
	public String renderOneGenre(@PathVariable("name") String name, Model model) {
		model.addAttribute("genreModel", genreRepo.findByName(name));
		model.addAttribute("postsModel", genreRepo.findByName(name).getPosts());
		return "singleGenreView";

	}
	@PostMapping("/add/{name}")
	public String addGenre(@PathVariable("name")String name) {
		Genre genreToAdd = new Genre(name);
		genreRepo.save(genreToAdd);
		return "redirect:/";
		
		
		
	}


}
