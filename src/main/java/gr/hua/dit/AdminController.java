package gr.hua.dit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.hua.dit.dao.UserDAO;
import gr.hua.dit.models.User;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	@Qualifier("userDAO")
	private UserDAO userDAO;
	
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public String administer(Model model) {
		List<User> usersList = userDAO.getAll();

		model.addAttribute("usersList", usersList);
		model.addAttribute("action", "edit");

		return "users";

	}

}
