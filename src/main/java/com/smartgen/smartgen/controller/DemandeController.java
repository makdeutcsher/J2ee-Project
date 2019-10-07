package com.smartgen.smartgen.controller;

import java.nio.file.Path;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.smartgen.smartgen.controller.storage.FileSystemStorageService;
import com.smartgen.smartgen.controller.storage.StorageProperties;
import com.smartgen.smartgen.controller.storage.StorageService;
import com.smartgen.smartgen.model.Demande;
import com.smartgen.smartgen.model.DocumentDemande;
import com.smartgen.smartgen.model.Glossaire;
import com.smartgen.smartgen.model.Ressource;
import com.smartgen.smartgen.model.User;
import com.smartgen.smartgen.repository.DemandeRepository;

import com.smartgen.smartgen.repository.DocumentDemandeRepository;

import com.smartgen.smartgen.repository.RessourceRepository;

import com.smartgen.smartgen.repository.UserRepository;

@Controller
public class DemandeController {
	@Autowired
    private DemandeRepository demandeRepository;
	
	@Autowired

	private DocumentDemandeRepository documentDemandeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	private StorageService storageService ;


	@Autowired
    private RessourceRepository ressourceRepository;
	


    @RequestMapping(value = "/demandes", method = RequestMethod.GET)
	public ModelAndView demandes(HttpSession session) {
		
    	User currentUser=(User) session.getAttribute("user");
		ModelAndView modelAndView = new ModelAndView();
		
		// get intitutions list from db
		List<Demande> demandes = demandeRepository.findByUserId(currentUser.getId());
		//System.out.println(demandes.get(0).getDescription()+"************");
		modelAndView.addObject("mesDemandes", demandes);
		
		
		
		modelAndView.setViewName("demandes");
		return modelAndView;
	}

    

	@RequestMapping(value = "/demandeForm", method = RequestMethod.GET)
	public String demandeForm(HttpSession session, ModelMap model) {
		

		String loggedin = (String) session.getAttribute("loggedin");
		System.out.print(loggedin);
		if(loggedin.equals("true")) {
			return "demandeForm";
			
		} else {
			return "redirect:/";
		}
		
	}
	
	
	@RequestMapping(value = "/lancerdemande", method = RequestMethod.POST)
    public String CreateDemande(HttpSession session, ModelMap model, 
    		@RequestParam String description,
    		@RequestParam String rs_organisme, 
    		@RequestParam String nom_organisme, 
    		@RequestParam String type_permis,
    		@RequestParam String telephone_organisme,
    		@RequestParam String adresse_organisme,
    		@RequestParam String email_organisme,
    		@RequestParam List<String> selected_ressources,
    		@RequestParam String question1,
    		@RequestParam String question2,
    		@RequestParam String question3,
    		@RequestParam String question4
    		,@RequestParam("document_reponse1") MultipartFile file1
    		,@RequestParam("document_reponse2") MultipartFile file2
    		,@RequestParam("document_reponse3") MultipartFile file3
    		,@RequestParam("document_reponse4") MultipartFile file4
    		)
    {
		/* Demande  demande = new Demande(); 
         demandeRepository.save(demande);
         session.setAttribute("user", user);
         */
		
		
	
		
		List<Ressource> selectedRessources = new ArrayList<Ressource>();
		
		for(String item : selected_ressources) {
			System.out.println(item.toString());
			Ressource ressource=ressourceRepository.findByNom(item);
			System.out.println(ressource.getNom());
			selectedRessources.add(ressource);
			
		}
		
		
		if(session==null) {System.out.println("session is nulllllllllllllllllllllllll");}
         System.out.println("values " + description+rs_organisme+nom_organisme);
		User currentUser=(User) session.getAttribute("user");
		//User currentUser = userRepository.findById((long)1051,"");
         System.out.println(session.getAttribute("loggedin"));
		//System.out.println(currentUser.getId());
		
		System.out.println(currentUser.getNom());
		System.out.println(currentUser.getPrenom());
		System.out.println(currentUser.getEmail());

		List dossierDemande = new ArrayList<DocumentDemande>();
		
		
		System.out.println(file1.getOriginalFilename());
	
		String chemin = "/upload";///demandes/"+currentUser.getId()+"_"+currentUser.getNom()+"_"+currentUser.getPrenom();
		
		StorageProperties sp = new StorageProperties();
		sp.setLocation("./src/main/upload");
		FileSystemStorageService fss= new FileSystemStorageService(sp);
	
		System.out.print("demande lancer , user : "+currentUser.getNom());
		
		System.out.println("  file : "+file1.getOriginalFilename());

		
		System.out.print("demande lancer , user : "+currentUser.getId());

		if (currentUser!=null) {
			// if requires any other previliges 
			Demande  demande = new Demande( description, rs_organisme, nom_organisme,
			adresse_organisme, email_organisme, telephone_organisme,
			type_permis, currentUser.getId(), null,selectedRessources);
			
		
			System.out.println("demande succesfully created");
		
			demandeRepository.save(demande);
			//create directories
			fss.init();
			fss.store(file1, "Q1_"+demande.getId().toString()+".pdf");
			fss.store(file2, "Q2_"+demande.getId().toString()+".pdf");
			fss.store(file3, "Q3_"+demande.getId().toString()+".pdf");
			fss.store(file4, "Q4_"+demande.getId().toString()+".pdf");
			
			DocumentDemande document = new DocumentDemande(question1,"Q1_"+demande.getId().toString()+".pdf",chemin+"/Q1_"+demande.getId().toString()+".pdf");
			documentDemandeRepository.save(document);
			dossierDemande.add(document);
			
			document =new DocumentDemande(question2,"Q2_"+demande.getId().toString()+".pdf",chemin+"/Q2_"+demande.getId().toString()+".pdf");
			documentDemandeRepository.save(document);
			dossierDemande.add(document);
			
			document = new DocumentDemande(question3,"Q3_"+demande.getId().toString()+".pdf",chemin+"/Q3_"+demande.getId().toString()+".pdf");
			documentDemandeRepository.save(document);
			dossierDemande.add(document);
			
			document = new DocumentDemande(question4,"Q4_"+demande.getId().toString()+".pdf",chemin+"/Q4_"+demande.getId().toString()+".pdf");
			documentDemandeRepository.save(document);
			dossierDemande.add(document);
			
			
			demande.setDossierDemande(dossierDemande);
			demandeRepository.save(demande);
			
			System.out.println("demande succesfully added");
			
			return "redirect:/";
		}else {
		
		
		
		
		
			return "redirect:/";}
		
		
    }
}
	
