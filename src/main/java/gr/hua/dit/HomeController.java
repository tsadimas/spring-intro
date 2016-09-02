package gr.hua.dit;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gr.hua.dit.dao.UserDAO;
import gr.hua.dit.models.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	@Autowired
	@Qualifier("userDAO")
	private UserDAO userDAO;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.info("SPRING VERSION " + org.springframework.core.SpringVersion.getVersion());

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("pageTitle", "Welcome Page");
		model.addAttribute("serverTime", formattedDate);

		return "welcome";
	}
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.info("SPRING VERSION " + org.springframework.core.SpringVersion.getVersion());

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("pageTitle", "Home Page");
		model.addAttribute("serverTime", formattedDate);

		return "home";
	}
	

	@RequestMapping("login")
	public ModelAndView getLoginForm(@RequestParam(required = false) String authfailed, String logout, String denied) {
		String message = "";
		if (authfailed != null) {
			message = "Invalid username of password, try again !";
		} else if (logout != null) {
			message = "Logged Out successfully, login again to continue !";
		} else if (denied != null) {
			message = "Access denied for this user !";
		}
		return new ModelAndView("login", "message", message);
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String createUser(Model model, @ModelAttribute("user") @Valid User user, BindingResult result) {

		if (result.hasErrors()) {
			return "user";
		}

		logger.info("form name " + user.getName());
		if (user.getId() == 0) {
			logger.info(" New User ");
			userDAO.save(user);
		} else {
			logger.info(" Existing User ");
			userDAO.update(user);
		}

		return "redirect:/login";

	}
	
	
	

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("title", "Register");
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("action", "/dit/register");
		return "user";

	}

	@RequestMapping("user")
	public String geUserPage() {
		return "user";
	}

	@RequestMapping("admin")
	public String geAdminPage() {
		return "admin";
	}

	@RequestMapping("403page")
	public String ge403denied() {
		return "redirect:login?denied";
	}

}
