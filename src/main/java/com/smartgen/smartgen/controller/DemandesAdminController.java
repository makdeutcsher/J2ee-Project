package com.smartgen.smartgen.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.smartgen.smartgen.model.Demande;
import com.smartgen.smartgen.model.Glossaire;
import com.smartgen.smartgen.model.Institution;
import com.smartgen.smartgen.model.Role;
import com.smartgen.smartgen.model.User;
import com.smartgen.smartgen.repository.DemandeRepository;
import com.smartgen.smartgen.repository.RoleRepository;
import com.smartgen.smartgen.repository.UserRepository;

@Controller
public class DemandesAdminController {

	@Autowired
    private DemandeRepository demandeRepository;
	
	@RequestMapping(value = "/admin/demandes", method = RequestMethod.GET)
	public ModelAndView demandes() {
		
		ModelAndView modelAndView = new ModelAndView();
		
		// get intitutions list from db
		List<Demande> demandes = demandeRepository.findAll();
		modelAndView.addObject("demandes", demandes);
		
		
		
		modelAndView.setViewName("admin/admin_demandes");
		return modelAndView;
	}

	
	
	
}