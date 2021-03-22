package stackjava.com.springmvchello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import stackjava.com.springmvchello.entities.User;

@Controller
public class UserController {

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String doGetAddUser(Model model) {
		if (!model.containsAttribute("user")) {
			model.addAttribute("user", new User());
		}
		return "add-user";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String doPostAddUser(@ModelAttribute("user") @Validated User user, BindingResult result) {
		if (result.hasErrors()) {
			for (ObjectError objectError: result.getAllErrors()) {
				System.out.println(objectError);
				System.out.println(objectError.getCode());
			}
			return "add-user";
		}
		return "view-user";
	}

}
