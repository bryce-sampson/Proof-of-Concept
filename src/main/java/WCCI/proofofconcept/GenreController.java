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

	// find out can use name method or use ID method
	@RequestMapping("{genName}")
	public String renderOneGenre(@PathVariable("genName") String genName, Model model) {
		model.addAttribute("genreModel", genreRepo.findByName(genName));
		return "genreView";
// add genre not found redirect
	}

}
