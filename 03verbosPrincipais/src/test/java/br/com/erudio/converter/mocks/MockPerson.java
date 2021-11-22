package br.com.erudio.converter.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.erudio.data.model.Person;
import br.com.erudio.data.vo.PersonVo;

public class MockPerson {
	
	public Person mockEntity() {
		return mockEntity(0);
	}
	public PersonVo mockVo() {
		return mockVo(0);
	}
	public List<Person> mockEntityList(){
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 14; i++) {
			persons.add(mockEntity(i));
		}
		return persons;
	}
	public List<PersonVo> mockVoList(){
		List<PersonVo> persons = new ArrayList<>();
		for (int i = 0; i < 14; i++) {
			persons.add(mockVo(i));
		}
		return persons;	
	}
	private Person mockEntity(Integer number) {
		Person person = new Person();
		person.setAddress("Addres Test" + number);
		person.setFirstName("First Name Test" + number);
		person.setGender(((number % 2)==0) ? "Male" : "Female");
		person.setLastName("Last Name Test"+number);	
		person.setId(number.longValue());
		
		return person;
	}
	
	private PersonVo mockVo(Integer number) {
		PersonVo person = new PersonVo();
		person.setAddress("Addres Test" + number);
		person.setFirstName("First Name Test" + number);
		person.setGender(((number % 2)==0) ? "Male" : "Female");
		person.setLastName("Last Name Test"+number);
		person.setId(number.longValue());
		
		return person;
	}
}
