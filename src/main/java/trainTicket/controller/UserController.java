package trainTicket.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import trainTicket.po.User;
import trainTicket.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/login.action")
	public @ResponseBody ResponseEntity checkLogin(HttpSession session,String tel,String password) {
		User user = userService.findUserByTelAndPassword(tel, password);
		ResponseEntity responseEntity = new ResponseEntity();
		if(user != null) {
			session.setAttribute("user", user);
			responseEntity.setMessage("SUCCESS");
		}else {
			responseEntity.setMessage("FAIL");
		}
		responseEntity.setData(user);
		return responseEntity;
	}
	
	@RequestMapping("/logout.action")
	public @ResponseBody ResponseEntity logout(HttpSession session) {
		session.invalidate();
		return new ResponseEntity("SUCCESS", null);
	}
	
	@RequestMapping("/register.action")
	public @ResponseBody ResponseEntity register(User user) {
		user.setAuthority(1);
		if(userService.registerUser(user) == false) {
			return new ResponseEntity("FAIL", null);
		}
		else {
			return new ResponseEntity("SUCCESS", user);
		}
	}
}
