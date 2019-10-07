package com.smartgen.smartgen.controller;

import java.util.ArrayList;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.smartgen.smartgen.model.Institution;
import com.smartgen.smartgen.controller.storage.FileSystemStorageService;
import com.smartgen.smartgen.controller.storage.StorageProperties;
import com.smartgen.smartgen.model.Classe;
import com.smartgen.smartgen.model.Demande;
import com.smartgen.smartgen.model.DocApa;
import com.smartgen.smartgen.model.Document;
import com.smartgen.smartgen.model.DocumentDemande;
import com.smartgen.smartgen.model.Domaine;
import com.smartgen.smartgen.model.Ressource;
import com.smartgen.smartgen.model.User;
import com.smartgen.smartgen.repository.ClasseRepository;
import com.smartgen.smartgen.repository.DocApaRepository;
import com.smartgen.smartgen.repository.DocumentRepository;
import com.smartgen.smartgen.repository.DomaineRepository;
import com.smartgen.smartgen.repository.InstitutionRepository;
import com.smartgen.smartgen.repository.RessourceRepository;

@Controller
public class AdminController {
	@Autowired
    private InstitutionRepository institutionRepository;
	
	@Autowired
	private DomaineRepository domaineRepository;
	
	@Autowired
	private DocumentRepository documentRepository;
	
	@Autowired
    private ClasseRepository classeRepository;
	
	@Autowired
    private RessourceRepository ressourceRepository;
	
	@Autowired
	private DocApaRepository docApaRepository;
	
	@GetMapping("/admin/institutions")
    public ModelAndView institutions() {
		// ViewModel to pass params to the view
		ModelAndView modelAndView = new ModelAndView();
		
		// get intitutions list from db
		List<Institution> institutionsList = institutionRepository.findAll();
		modelAndView.addObject("institutions", institutionsList);
		
		// get domaines list from db
		List<Domaine> domainsList = domaineRepository.findAll();
		modelAndView.addObject("domaines", domainsList);
		
		modelAndView.setViewName("admin/admin_institutions");
	    return modelAndView;
    }
	
	
	@GetMapping("/admin/ressources")
    public ModelAndView ressources(HttpSession session) {
		
		String user_role = (String) session.getAttribute("user_role"); 
		
		
		
		// ViewModel to pass params to the view
		ModelAndView modelAndView = new ModelAndView();
		
		// get ressources list from db
		List<Ressource> ressourcesList = ressourceRepository.findAll();
		modelAndView.addObject("ressources", ressourcesList);
		
		// get classes list from db
		List<Classe> classesList = classeRepository.findAll();
		modelAndView.addObject("classes", classesList);
		
		modelAndView.setViewName("admin/admin_ressources");
		
	    return modelAndView;
    }
	
	
	

	@RequestMapping(value = "/admin/ressource/add", method = RequestMethod.POST)
    public ModelAndView CreateDemande(HttpSession session, ModelMap model, 
    		@RequestParam String nom,
    		@RequestParam String region, 
    		@RequestParam String caracteristiques, 
    		@RequestParam long classe,
    		@RequestParam String desc
    		,@RequestParam("file") MultipartFile file
    		,@RequestParam("documents") List<MultipartFile> documents
    		)
    {
		/* Demande  demande = new Demande(); 
         demandeRepository.save(demande);
         session.setAttribute("user", user);
         */
		StorageProperties x = new StorageProperties();
		x.setLocation("./src/main/upload");
		List<Document> ressources_documents = new ArrayList();
		FileSystemStorageService fss= new FileSystemStorageService(x);
		for(MultipartFile document : documents) {
			String fileName = document.getOriginalFilename();
			Document d = new Document(fileName, "http://localhost:5656/upload/" + fileName);
			documentRepository.save(d);
			ressources_documents.add(d);
			fss.store(document, fileName);
		}
		
		
		String image = fss.store(file, file.getOriginalFilename());
		
		
		Ressource ressource = new Ressource(desc,nom,image,region,caracteristiques,classe);
		ressource.setDocuments(ressources_documents);
		ressourceRepository.save(ressource);
		
		ModelAndView modelAndView = new ModelAndView();
		
		// get ressources list from db
		List<Ressource> ressourcesList = ressourceRepository.findAll();
		modelAndView.addObject("ressources", ressourcesList);
		
		// get classes list from db
		List<Classe> classesList = classeRepository.findAll();
		modelAndView.addObject("classes", classesList);
		
		modelAndView.setViewName("admin/admin_ressources");
		
		return modelAndView;
    }
	
	@GetMapping("/admin/doc_apa")
    public ModelAndView docapa() {
		// ViewModel to pass params to the view
		ModelAndView modelAndView = new ModelAndView();

		List<DocApa> docsList = docApaRepository.findAll();
		modelAndView.addObject("docsList", docsList);

		modelAndView.setViewName("admin/admin_doc_apa");
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin/docapa/add", method = RequestMethod.POST)
    public ModelAndView CreateDocApa(HttpSession session, ModelMap model,@RequestParam("file") MultipartFile file)
    {
		
		StorageProperties x = new StorageProperties();
		x.setLocation("./src/main/upload/apa_docs");
		
		FileSystemStorageService fss= new FileSystemStorageService(x);
		fss.init();
		String image = fss.store(file, file.getOriginalFilename());
		
		
		DocApa docApa = new DocApa(file.getOriginalFilename(),"upload/apa_docs/" + file.getOriginalFilename());
		docApaRepository.save(docApa);
		
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/doc_apa");

		List<DocApa> docsList = docApaRepository.findAll();
		modelAndView.addObject("docsList", docsList);

		modelAndView.setViewName("admin/admin_doc_apa");
		return modelAndView;
		
		
    }

}
