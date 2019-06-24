package WCCI.proofofconcept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/genres")
public class GenreController {

	@Autowired
	private GenreRepository genreRepo;

	@RequestMapping("")
	public String renderGenresAll(Model model) {
		model.addAttribute("genresModel", genreRepo.findAll());
		return "genresView";
	}

	@RequestMapping("{name}")
	public String renderOneGenre(@PathVariable("name") String name, Model model) {
		model.addAttribute("genreModel", genreRepo.findByName(name));
		return "genreView";

	}

}
