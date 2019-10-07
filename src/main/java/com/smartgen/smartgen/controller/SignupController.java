package com.smartgen.smartgen.controller;

import java.sql.Date;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smartgen.smartgen.model.User;
import com.smartgen.smartgen.model.Role;
import com.smartgen.smartgen.repository.RoleRepository;
import com.smartgen.smartgen.repository.UserRepository;

@Controller
public class SignupController {
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private RoleRepository roleRepository;
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup() {

		return "signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String CreateUser(HttpSession session, ModelMap model, @RequestParam String nom, @RequestParam String prenom, @RequestParam String email, @RequestParam String password)
    {
		
       
     User userExists = userRepository.findByEmail(email);
     if(userExists == null)
     {
         /** User user = new User(nom, prenom, email, password, new Date(System.currentTimeMillis())); **/
    	 Role role = roleRepository.findByName("Normal");
    	 User user = new User(nom, prenom, email, password,role); 
         userRepository.save(user);
         session.setAttribute("user", user);
         session.setAttribute("loggedin", "true");
         
         model.addAttribute("user", user);
         model.addAttribute("loggedin", "true");
         
         return "login";
     }
     else {
         model.addAttribute("error1", "ce email existe deja");
         return "signup";
     }

    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		   System.out.print("hello wrold from login GEt ");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String welcomePage(HttpSession session , ModelMap model, @RequestParam String email, @RequestParam String password) {
       
        User userExists = userRepository.findByEmail(email);
        System.out.println(email);
        if (userExists != null) {
            if (userExists.getPassword().equals(password)) {
            	User user = new User(userExists.getId(),userExists.getNom(), userExists.getPrenom(), userExists.getEmail(), userExists.getPassword());
            	Role role = userExists.getRole();
            	String user_role =role.getName(); 
            	
                model.addAttribute("user", user);
                model.addAttribute("user_role", user_role);
                model.addAttribute("loggedin", "true");
                
                
                session.setAttribute("user", user);
                session.setAttribute("loggedin", "true");
                session.setAttribute("user_role", user_role);
                
                session.setMaxInactiveInterval(0);
                
                
                if(user_role.equals("Normal")) {
                	return "index";
                } else {
                	return "admin/admin_ressources";	
                }
                 
                	
                
                
            } else {
                model.addAttribute("login_error", "Le mot de passe est incorrect");
                return "login";
            }

        } else {
            model.addAttribute("login_error", "Le Compte n'existe pas");
            return "login";
        }

    }
	
	@GetMapping("/logout")
    public String logout(HttpSession session) {
		session.setAttribute("loggedin","false");
		
		session.setAttribute("user",null);
        return "logout";
    }
	
	

}
