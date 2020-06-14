package com.sbproject.firstProject.Controller;

import com.sbproject.firstProject.Model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    @GetMapping("/person")
    public List<Person> getPerson()
    {
        List<Person> people = List.of(
                new Person("Umma", "Umma", "1"),
                new Person("Hello", "Test", "2")
        );
        return people;
    }

    @GetMapping("/person/{name}")
    public Person getPersons(@PathVariable String name)
    {
        List<Person> people = List.of(
                new Person("Name", "One", "1"),
                new Person("Hello", "Test", "2"));

        Person person = people.stream()
                .filter(s -> s.getFirstName().equals(name))
                .findFirst()
                .orElseThrow(RuntimeException::new);

        return person;
    }
}
