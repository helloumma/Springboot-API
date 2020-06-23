package com.sbproject.firstProject.Controller;

import com.sbproject.firstProject.Model.Person;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @GetMapping("/person")
    public List<Person> getPerson() {
        List<Person> people = List.of(
                new Person("Umma", "Umma", "1"),
                new Person("Hello", "Test", "2")
        );
        return people;
    }

    @GetMapping("/response-entity-builder-with-http-headers")
    public ResponseEntity<String> usingResponseEntityBuilderAndHttpHeaders() {
        List<Person> people = List.of(
                new Person("Umma", "Umma", "1"),
                new Person("Hello", "Test", "2")
        );

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Baeldung-Example-Header",
                "Value-ResponseEntityBuilderWithHttpHeaders");

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(people.toString());
    }

    @GetMapping("/person/{name}")
    @ResponseBody
    public Person getPersons(@RequestParam String name) {
        List<Person> people = List.of(
                new Person("helloOne", "HelloTwo", "1"),
                new Person("Hello", "Test", "22")
        );
        Person person = people.stream()
                .filter(s -> s.getFirstName().equals(name))
                .findFirst()
                .orElseThrow(RuntimeException::new);

        return person;
    }

    //post
    @PostMapping("/person")
    public void postPerson()
    {
        System.out.println("post");
    }

    //delete
    @DeleteMapping("/person")
    public void deletePerson() {
        System.out.println("delete");
    }

}
