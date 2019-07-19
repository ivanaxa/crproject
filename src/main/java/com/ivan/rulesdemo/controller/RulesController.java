package com.ivan.rulesdemo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ivan.rulesdemo.entity.Rules;
import com.ivan.rulesdemo.repository.RulesRepository;

@RestController
public class RulesController {
	
	@Autowired
	private RulesRepository rr;
	
	@GetMapping("/rules")
	public List<Rules> getAllRules() {
		return rr.findAll();
	}
	
	@GetMapping("rules/{id}")
	public Rules getRule(@PathVariable int id) {
		Optional<Rules> rule = rr.findById(id);
		return rule.get();
	}

    
    /*simple implementation, should put in Service I believe*/
    
    public Rules saveUploadedFile(MultipartFile file) throws IOException{
    	
    	String fileName=StringUtils.cleanPath(file.getOriginalFilename());
    	Rules rFile= new Rules(fileName, file.getBytes());
    	return rr.save(rFile);
    }
       
    @RequestMapping(value="/postRule", method = RequestMethod.POST, consumes="multipart/form-data")
    public String uploadFile(@RequestParam MultipartFile file) throws IOException{
    	
    	saveUploadedFile(file);
    	return "File Uploaded";
    	
    }

	@RequestMapping(value = "/postRules", method = RequestMethod.POST)
	public String postMultipleFiles(@RequestParam List<MultipartFile> files) {
	  //System.out.println(files.size());
	  //files.forEach(file -> System.out.println(file.getOriginalFilename()));
	  
		if (files.size()>0) {
		files.forEach(file -> {
			try {
				saveUploadedFile(file);
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		});
		return "All files loaded succesfully";
		}else {
			return "No files loaded or uploaded failed.";
		}
	}
    

}
