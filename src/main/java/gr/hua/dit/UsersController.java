package gr.hua.dit;

import java.util.List;
import java.util.Locale;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.hua.dit.dao.UserDAO;
import gr.hua.dit.models.User;

@Controller
public class UsersController {
	@Autowired
	@Qualifier("userDAO")
	private UserDAO userDAO;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String users(Model model) {
		List<User> usersList= userDAO.getAll();
		
		model.addAttribute("usersList", usersList);
		
		return "users";
		
	}

}
