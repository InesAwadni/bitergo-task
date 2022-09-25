package com.bitergo.task.person;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping(value ="/test2/execute")
    public Object executeTest2(){
       ObjectMapper mapper = new ObjectMapper();
       ObjectNode response = mapper.createObjectNode();
       ArrayNode personsArray = mapper.createArrayNode();
        try {
             List<Person> persons = personService.findAll();
             if(persons.isEmpty()) {
                return response.put("message","no persons found");
            }
            persons.forEach(person -> {
               ObjectNode personObject = mapper.createObjectNode();
               personObject.put("id", person.getId());
               personObject.put("name", person.getName());
               personObject.put("age", person.getAge());
               personsArray.add(personObject);
            });
            float averageAge = personService.getAverageAge();
            boolean deleteAll= personService.deleteAll();

            response.set("persons", personsArray);
            response.put("averageAge", averageAge);
            response.put("isPersonsDeleted", deleteAll);

            } catch (Exception ex){
                throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,"Something went wrong",ex);
            }
       return response;
    }
}
