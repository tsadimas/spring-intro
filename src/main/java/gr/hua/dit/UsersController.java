package gr.hua.dit;

import java.util.List;
import java.util.Locale;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gr.hua.dit.dao.UserDAO;
import gr.hua.dit.models.User;

@Controller
@RequestMapping(value = "/users")
public class UsersController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	@Qualifier("userDAO")
	private UserDAO userDAO;
	
	@RequestMapping(value = "all", method = RequestMethod.GET)
	public String users(Model model) {
		List<User> usersList= userDAO.getAll();
		
		model.addAttribute("usersList", usersList);
		
		return "users";
		
	}
	
	@RequestMapping(value="register", method = RequestMethod.POST)
	public String createUser(Model model, @ModelAttribute("user")User user) {
		
		logger.info("form name "+ user.getName() );
		userDAO.save(user);
		return "redirect:/dit/users";

	}
	
	@RequestMapping(value="register", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("title", "Register");
		User user = new User();
		model.addAttribute("user", user);
		return "user";
		
	}
	

}
