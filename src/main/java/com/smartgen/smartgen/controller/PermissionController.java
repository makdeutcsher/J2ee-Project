package com.smartgen.smartgen.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smartgen.smartgen.model.Glossaire;
import com.smartgen.smartgen.model.Institution;
import com.smartgen.smartgen.model.Ressource;
import com.smartgen.smartgen.model.Role;
import com.smartgen.smartgen.model.User;
import com.smartgen.smartgen.repository.RoleRepository;
import com.smartgen.smartgen.repository.UserRepository;

@Controller
public class PermissionController {
	@Autowired
    private RoleRepository roleRepository;
	
	@Autowired
    private UserRepository userRepository;
	
	
	
 
	@RequestMapping(value = "/admin/roles", method = RequestMethod.GET)
	public String role(ModelMap model) {

		List<Role> roles = roleRepository.findAll();
		model.addAttribute("roles",roles); 
		return "admin/admin_roles";
	}
	
	@RequestMapping(value = "/admin/roles", method = RequestMethod.POST)
    public String CreateRole(ModelMap model, @RequestParam String role, @RequestParam String permissions)
    {
       
        
    	 Role role1 = new Role(role,permissions); 
         roleRepository.save(role1);
         model.addAttribute("role", role1);
         return "redirect:/admin/roles";
     }

	
	
	@RequestMapping(value = "/admin/permissions", method = RequestMethod.GET)
	public String permissions(ModelMap model) {

		List<User> users = userRepository.findAll();
		model.addAttribute("users",users); 
		List<Role> roles = roleRepository.findAll();
		model.addAttribute("roles",roles); 
		
		return "admin/admin_permissions";
	}
	

	@RequestMapping(value = "/admin/permissions", method = RequestMethod.POST)
    public String CreateUser(ModelMap model, 
    		@RequestParam String nom, 
    		@RequestParam String prenom, 
    		@RequestParam String email, 
    		@RequestParam String role,
    		@RequestParam String password)
    {
		User userExists = userRepository.findByEmail(email);
	     if(userExists == null)
	     {
	    	 System.out.print(role);
	    	 Role _role = roleRepository.findByName(role);
	    	 System.out.print(_role);
	    	 
	    	 
	    	 User user = new User(nom, prenom, email, password,_role); 
	         userRepository.save(user);	
	               
	         model.addAttribute("succces", "Admnistrateur cree avec succes");
	         List<Role> roles = roleRepository.findAll();
			 model.addAttribute("roles",roles); 
	         return "admin/admin_permissions";
	     }
	     else {
	    	 List<Role> roles = roleRepository.findAll();
			 model.addAttribute("roles",roles); 
	         model.addAttribute("error1", "ce email existe deja");
	         return "admin/admin_permissions";
	     }
	     
	  

       
     }
	
	
	
	

	
  
	
	
}


