import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.em.dojo.models.Dojo;
import com.em.dojo.services.AppService;

@Controller
//This request mapping puts "dojo" in front of all URL link
@RequestMapping("/dojo")
public class DojoController {

	@Autowired
	private AppService aService;
	
//	-----------------------Rendering JSP and POST-----------------------------------
	@GetMapping("/new")
	public String createDojo(@ModelAttribute("dojo")Dojo dojo, Model viewModel) {
		return "newDojo.jsp";
	}
	@PostMapping("/createDojo")
	public String dojoCreate(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		}
		this.aService.createDojo(dojo);
		return "redirect:/dojo/new";
	}
//	------------------------------Display Certain Dojos--------------------------------------------
	@GetMapping("/{id}")
	public String showDojo(Model viewModel, @PathVariable("id")Long id) {
		viewModel.addAttribute("dojo", this.aService.getOneDojo(id));
		return "dojoDetails.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
