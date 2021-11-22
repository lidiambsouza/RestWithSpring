package br.com.erudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.PersonVo;
import br.com.erudio.data.vo.v2.PersonVoV2;
import br.com.erudio.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices services;
		
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PersonVo> findAll(){		
		return services.findAll();		
	}
	
	@GetMapping("/{id}")
	public PersonVo findById(@PathVariable("id") Long id){		
		return services.findById(id);		
	}
	
	@PostMapping
	public PersonVo create(@RequestBody PersonVo person){		
		return services.create(person);		
	}
	
	@PostMapping("/v2")
	public PersonVoV2 createV2(@RequestBody PersonVoV2 person){		
		return services.createV2(person);		
	}
	
	@PutMapping
	public PersonVo update(@RequestBody PersonVo person){		
		return services.update(person);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){		
		services.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
