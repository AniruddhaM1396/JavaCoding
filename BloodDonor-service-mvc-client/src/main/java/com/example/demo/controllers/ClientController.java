package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.BloodDonor;
import com.example.demo.entity.BloodDonorCamp;


@Controller
public class ClientController {
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private ModelAndView mdlView;
	
	@Autowired
	private BloodDonor bloodDonor;
	
	@Autowired
	private BloodDonorCamp bloodDonorCamp;
	
	//To get the list of donors
	 @GetMapping(path="/list")
	    public ModelAndView view(@ModelAttribute("command") BloodDonor bloodDonor) { 
		 	ResponseEntity<List<BloodDonor>> donors = this.template.exchange("http://localhost:8080/api/v1/donors/",
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<BloodDonor>>() {
            });
		 	List<BloodDonor> donorList = donors.getBody();
		 	mdlView.addObject("donorList",donorList);
		 	mdlView.setViewName("viewDonor");
	        mdlView.addObject("command",bloodDonor);
		 	
	        return mdlView;
	    }
	 
	 @PostMapping(path="/bloodgroup")
	 public ModelAndView viewDonorgroup(@ModelAttribute("command") BloodDonor bloodDonor) { 
		 Map<String,String> params = new HashMap<String,String>();
	        params.put("donorBloodgroup", String.valueOf(bloodDonor.getDonorBloodgroup()));
	        System.out.println(params);
		 
		 ResponseEntity<List<BloodDonor>> donors = this.template.exchange("http://localhost:8080/api/v1/donors/bloodgroup/{donorBloodgroup}", HttpMethod.GET, null, new ParameterizedTypeReference<List<BloodDonor>>() {}, params);
		 			
		 	List<BloodDonor> donorList = donors.getBody();
		 	mdlView.addObject("donorList",donorList);
		 	mdlView.setViewName("viewDonor");
	        
	        return mdlView;
	    }
	
	 //To get the list of eligible donors
	 @GetMapping(path="/eligible")
	    public ModelAndView eligible(@ModelAttribute("command") BloodDonor bloodDonor) { 
		 	ResponseEntity<List<BloodDonor>> donors = this.template.exchange("http://localhost:8080/api/v1/donors/eligible",
                 HttpMethod.GET, null, new ParameterizedTypeReference<List<BloodDonor>>() {
         });
		 	List<BloodDonor> donorList = donors.getBody();
		 	System.out.println(donorList);
		 	mdlView.addObject("donorList",donorList);
		 	mdlView.setViewName("viewDonor");
	        mdlView.addObject("command",bloodDonor);
		 	
	        return mdlView;
	    }
	 
	 //To get the list of eligible donors of a particular blood group
	 @GetMapping(path="/eligiblegroup")
	    public ModelAndView click() {        
	        mdlView.setViewName("donorRequired");
	        mdlView.addObject("command",bloodDonor);
	        
	        return mdlView;
	    }
	 @PostMapping(path="/eligiblebloodgroup")
	 public ModelAndView vieweligibleDonorgroup(@ModelAttribute("command") BloodDonor bloodDonor) { 
		 Map<String,String> params = new HashMap<String,String>();
	        params.put("donorBloodgroup", String.valueOf(bloodDonor.getDonorBloodgroup()));
	        System.out.println(params);
		 
		 ResponseEntity<List<BloodDonor>> donors = this.template.exchange("http://localhost:8080/api/v1/donors/eligiblebloodgroup/{donorBloodgroup}", HttpMethod.GET, null, new ParameterizedTypeReference<List<BloodDonor>>() {}, params);
		 			
		 	List<BloodDonor> donorList = donors.getBody();
		 	mdlView.addObject("donorList",donorList);
		 	mdlView.setViewName("viewDonor");
	        
	        return mdlView;
	    }
	
	//To add blood donor to database
	@GetMapping(path="/donor")
	    public ModelAndView init() {        
	        mdlView.setViewName("addBloodDonor");
	        mdlView.addObject("command",bloodDonor);
	        
	        return mdlView;
	    }
	    
	    @PostMapping(path="/submit")
	    public ModelAndView onSubmit(@ModelAttribute("command") BloodDonor bloodDonor) {
	        
	        //mdlView.setViewName("success");
	        
	        BloodDonor added = this.template.postForObject("http://localhost:8080/api/v1/donors/", bloodDonor, BloodDonor.class);
	        System.out.println(added);
	        mdlView.setViewName("success");
	        mdlView.addObject("added",added);
	        return mdlView;
	    }
	    
	    //To delete blood donor from database
	    @GetMapping(path="/deleteBloodDonor")
	    public ModelAndView delete() {        
	        mdlView.setViewName("deleteBloodDonor");
	        mdlView.addObject("command",bloodDonor);
	        
	        return mdlView;
	    }
	    
	    @PostMapping(path="/delete")
	    public ModelAndView onDelete(@ModelAttribute("command") BloodDonor bloodDonor) {
	        
	        //mdlView.setViewName("success");
	        Map<String,String> params = new HashMap<String,String>();
	        params.put("id", String.valueOf(bloodDonor.getDonorPhone()));
	        System.out.println(params);
	        this.template.delete("http://localhost:8080/api/v1/donors/delete/{id}", params);
	        System.out.println(params);
	        mdlView.setViewName("success");
	        mdlView.addObject("added","deleted");
	        return mdlView;
	    }
	    
	    //To update a blood donor in database
	    @GetMapping(path="/updateBloodDonor")
	    public ModelAndView update() {        
	        mdlView.setViewName("updateBloodDonor");
	        mdlView.addObject("command",bloodDonor);
	        
	        return mdlView;
	    }
	    
	    @PostMapping(path="/update")
	    public ModelAndView onUpdate(@ModelAttribute("command") BloodDonor bloodDonor) {
	        
	        //mdlView.setViewName("success");
	        
	        this.template.postForObject("http://localhost:8080/api/v1/donors/update", bloodDonor, BloodDonor.class);
	        //System.out.println(added);
	        mdlView.setViewName("success");
	        mdlView.addObject("added","updated");
	        return mdlView;
	    }
	    
	    //To display list of blood camps
	    @GetMapping(path="/campList")
	    public ModelAndView campList(@ModelAttribute("command") BloodDonorCamp bloodDonorCamp) { 
		 	ResponseEntity<List<BloodDonorCamp>> camps = this.template.exchange("http://localhost:8080/api/v1/camps",
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<BloodDonorCamp>>() {
            });
		 	List<BloodDonorCamp> campList = camps.getBody();
		 	System.out.println(campList);
		 	mdlView.addObject("campList",campList);
		 	mdlView.setViewName("viewCamps");
	        mdlView.addObject("command",bloodDonorCamp);
		 	
	        return mdlView;
	    }
	    
	    //To add blood camps to the database
	    @GetMapping(path="/addCamp")
	    public ModelAndView add() {        
	        mdlView.setViewName("addBloodDonorCamp");
	        mdlView.addObject("command",bloodDonorCamp);
	        
	        return mdlView;
	    }
	    
	    @PostMapping(path="/submitCamp")
	    public ModelAndView onAdd(@ModelAttribute("command") BloodDonorCamp bloodDonorCamp) {
	        
	        //mdlView.setViewName("success");
	        
	        BloodDonorCamp added = this.template.postForObject("http://localhost:8080/api/v1/camps/", bloodDonorCamp, BloodDonorCamp.class);
	        System.out.println(added);
	        mdlView.setViewName("success");
	        mdlView.addObject("added",added);
	        return mdlView;
	    }
	    
	    //To delete Blood camps from database
	    @GetMapping(path="/deleteBloodDonorCamp")
	    public ModelAndView deleteCamp() {        
	        mdlView.setViewName("deleteBloodDonorCamp");
	        mdlView.addObject("command",bloodDonorCamp);
	        
	        return mdlView;
	    }
	    
	    @PostMapping(path="/deleteCamp")
	    public ModelAndView onDeleteCamp(@ModelAttribute("command") BloodDonorCamp bloodDonorCamp) {
	        
	        //mdlView.setViewName("success");
	        Map<String,String> params = new HashMap<String,String>();
	        params.put("id", String.valueOf(bloodDonorCamp.getCampName()));
	        System.out.println(params);
	        this.template.delete("http://localhost:8080/api/v1/camps/delete/{id}", params);
	        System.out.println(params);
	        mdlView.setViewName("success");
	        mdlView.addObject("added","deleted");
	        return mdlView;
	    }
	  
	    //To register a blood donor to a blood camp
	    @GetMapping(path="/registerCamp")
	    public ModelAndView registerCamp() {        
	        mdlView.setViewName("registerCamp");
	        mdlView.addObject("command",bloodDonor);
	        
	        return mdlView;
	    }
	    
	    @PostMapping(path="/register")
	    public ModelAndView onRegister(@ModelAttribute("command") BloodDonor bloodDonor) {
	        
	        //mdlView.setViewName("success");
	        Map<String,String> params = new HashMap<String,String>();
	        params.put("id", String.valueOf(bloodDonor.getDonorPhone()));
	        params.put("revised", String.valueOf(bloodDonor.getBloodCampRegistered()));
	        System.out.println(params);
	        this.template.put("http://localhost:8080/api/v1/donors/bloodDonorCamp/{id}/{revised}", bloodDonor, params);
	        //("http://localhost:8080/api/v1/donors/bloodDonorCamp/{id}/{revised}", params);
	        System.out.println(params);
	        mdlView.setViewName("success");
	        mdlView.addObject("added","registered");
	        return mdlView;
	    }
	}
