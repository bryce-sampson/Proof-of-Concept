package WCCI.proofofconcept;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
  
	@RequestMapping("/")
	public String rendorHome(Model model) {
		model.addAttribute("homeModel", "");
		return "homeView";
	}
	
	@RequestMapping("/home")
	public String rendorHomePage(Model model) {
		model.addAttribute("homeModel", "");
		return "homeView";
	}
}
