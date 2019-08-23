package pl.psnc.hamerhed.mongodb.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pl.psnc.hamerhed.mongodb.model.Gender;
import pl.psnc.hamerhed.mongodb.model.User;
import pl.psnc.hamerhed.mongodb.persistance.UserRepository;

@Controller
public class UsersController {

	private UserRepository UserRepository;
	
	@Autowired
	public UsersController(pl.psnc.hamerhed.mongodb.persistance.UserRepository userRepository) {
		super();
		UserRepository = userRepository;
	}



	@GetMapping("/users/list")
	public String getList(Model model) {
		System.out.println("users list");
		List<User> users = UserRepository.findAll();
		model.addAttribute("users", users);
		
		return "users-list";
	}
	
	@GetMapping("/users/add/{gender}")
	public String addUser(@PathVariable(value="gender") String gender, Model model) {
		User user = null;
		System.out.println("add user [" + gender + "]");
		if("male".equals(gender)) {
			user = new User(Gender.MALE);
			System.out.println("add male");
		} else if ("female".equals(gender)) {
			user = new User(Gender.FEMALE);
		}
		
		if(user != null) {
			UserRepository.save(user);
		}
		
		List<User> users = UserRepository.findAll();
		model.addAttribute("users", users);
		return "users-list";
	}
}
