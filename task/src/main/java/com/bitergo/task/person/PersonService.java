package com.bitergo.task.person;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public List<Person> findAll(){
        List<Person> persons = (List<Person>) personRepository.findAll();
        return persons;
    }

    public float getAverageAge(){
        var averageAge = personRepository.getAverageAge();
        return  averageAge;
    }

    public boolean deleteAll (){
        personRepository.deleteAll();

        List<Person> persons = (List<Person>) personRepository.findAll();
        if(persons.isEmpty()) {
            return true;
        }
        return false;
    }
}
