package br.com.erudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.converter.custom.PersonConverter;
import br.com.erudio.data.model.Person;
import br.com.erudio.data.vo.PersonVo;
import br.com.erudio.data.vo.v2.PersonVoV2;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.repository.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonConverter converter;

	public PersonVo create(PersonVo person) {
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVo.class);
		return vo;
	}
	
	public PersonVoV2 createV2(PersonVoV2 person) {
		var entity = converter.convertVoV2ToEntity(person);
		var vo2 = converter.convertEntityToVoV2(repository.save(entity));
		return vo2;
	}

	public PersonVo update(PersonVo person) {
		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("no records found for this ID"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return DozerConverter.parseObject(repository.save(entity), PersonVo.class);
	}

	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("no records found for this ID"));
		repository.delete(entity);
	}

	public PersonVo findById(Long id) {
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("no records found for this ID"));
		return DozerConverter.parseObject(entity, PersonVo.class);
	}

	public List<PersonVo> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), PersonVo.class) ;
	}

}
