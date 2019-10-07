package com.smartgen.smartgen.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.smartgen.smartgen.model.Institution;
import com.smartgen.smartgen.model.Ressource;
import com.smartgen.smartgen.model.Role;
import com.smartgen.smartgen.model.Classe;
import com.smartgen.smartgen.model.DocApa;
import com.smartgen.smartgen.model.User;
import com.smartgen.smartgen.model.Domaine;
import com.smartgen.smartgen.repository.ClasseRepository;
import com.smartgen.smartgen.repository.DocApaRepository;
import com.smartgen.smartgen.repository.DomaineRepository;
import com.smartgen.smartgen.repository.InstitutionRepository;
import com.smartgen.smartgen.repository.RoleRepository;

@Controller
public class HomeController {
	
	@Autowired
    private InstitutionRepository institutionRepository;
	
	@Autowired
    private DomaineRepository domaineRepository;
	
	@Autowired
    private ClasseRepository classeRepository;
	
	@Autowired
	private DocApaRepository docApaRepository;
	
	@Autowired
    private RoleRepository roleRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		
		return "index";
	}
	
	
	@GetMapping("/institutions")
    public ModelAndView  institutions() {
		
		// ViewModel to pass params to the view
		ModelAndView modelAndView = new ModelAndView();
				
		// get intitutions list from db
		List<Domaine> domainsList = domaineRepository.findAll();
		modelAndView.addObject("domaines", domainsList);
		
		modelAndView.setViewName("institutions_list");
	    return modelAndView;
    }
	
	@GetMapping("/ressources")
    public ModelAndView  ressources() {
		
		// ViewModel to pass params to the view
		ModelAndView modelAndView = new ModelAndView();
		
		// get intitutions list from db
		List<Classe> classesList = classeRepository.findAll();
		modelAndView.addObject("classes", classesList);
				
		modelAndView.setViewName("ressources_list");
	    return modelAndView;
    }
	
	@GetMapping("/nagoya")
    public String nagoya() {
        return "nagoya";
    }
	
	
	@GetMapping("/user")
    public String user() {
		
        return "user";
    }

	
	
	@GetMapping("/admin")
    public String admin() {
        return "admin/admin_institutions";
    }
	
	@GetMapping("/multitage")
    public String multitage(ModelMap model) {
		List<Role> roles = roleRepository.findAll();
		model.addAttribute("roles",roles); 
        return "multitag";
    }
	
	
	
	
	@GetMapping("/lois")
	public ModelAndView lois() {
		// ViewModel to pass params to the view
		ModelAndView modelAndView = new ModelAndView();

		List<DocApa> docsList = docApaRepository.findAll();
		modelAndView.addObject("docsList", docsList);

		modelAndView.setViewName("lois");
		return modelAndView;
	}
	
		
}


