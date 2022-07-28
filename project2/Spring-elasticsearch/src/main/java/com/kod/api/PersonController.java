package com.kod.api;

import com.kod.entity.Person;
import com.kod.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonRepository personRepository;
    @PostConstruct
    public void init(){
        Person person= new Person();
        person.setName("iclal");
        person.setSurname("dilercan");
        person.setAddress("istanbul");
        person.setDateOfBirth(Calendar.getInstance().getTime());
        person.setId("K001");
        Person save = personRepository.save(person);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Person>> getPerson(@PathVariable String search){
        List<Person> persons= personRepository.getByCustomQuery(search);
        return ResponseEntity.ok(persons);

    }
}
