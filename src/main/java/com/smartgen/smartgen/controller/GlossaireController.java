package com.smartgen.smartgen.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smartgen.smartgen.model.Glossaire;
import com.smartgen.smartgen.model.User;
import com.smartgen.smartgen.repository.GlossaireRepository;


@Controller
public class GlossaireController {
	
	@Autowired
    private GlossaireRepository glossaireRepository;
	

	@RequestMapping(value = "/glossaire", method = RequestMethod.GET)
    public String glossaire(ModelMap model) {
		
		 List<Glossaire> glossaires = glossaireRepository.findAll();
		 model.addAttribute("glossaires", glossaires);
		
		/*Glossaire glossaire = new Glossaire("Ressources génétiques"," le terme « ressources génétiques » désigne le matériel\r\n" + 
				"génétique provenant de plantes, d’animaux et de microbes présentant une valeur\r\n" + 
				"d’utilisation potentielle");
		glossaireRepository.save(glossaire);*/
		
        return "glossaire";
    }
	
	
	
	
	
}


