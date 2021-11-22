package br.com.erudio.converter.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.erudio.data.model.Person;
import br.com.erudio.data.vo.v2.PersonVoV2;

@Service
public class PersonConverter {
 
	public PersonVoV2 convertEntityToVoV2(Person person) {
		
		 PersonVoV2 vo = new PersonVoV2();
		 
		 vo.setId(person.getId());
		 vo.setFirstName(person.getFirstName());
		 vo.setLastName(person.getLastName());
		 vo.setAddress(person.getAddress());
		 vo.setGender(person.getGender());
		 vo.setBirthDay(new Date());
		 return vo;
	}
	
	public Person convertVoV2ToEntity(PersonVoV2 person) {
		
		 Person entity = new Person();
		 
		 entity.setId(person.getId());
		 entity.setFirstName(person.getFirstName());
		 entity.setLastName(person.getLastName());
		 entity.setAddress(person.getAddress());
		 entity.setGender(person.getGender());
		 
		 return entity;
	}
	
}
