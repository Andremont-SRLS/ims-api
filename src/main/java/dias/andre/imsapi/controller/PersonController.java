package dias.andre.imsapi.controller;

import dias.andre.imsapi.models.person.Person;
import dias.andre.imsapi.repositories.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/person")
class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @GetMapping("/{id}")
    public Person find(@PathVariable String id) {
        return personRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person with id " + id + " not found"));

    }

    @PostMapping
    public Person create( @RequestBody Person person) {

        try {
            return personRepository.save(person);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Make sure you are sending a valid person object");
        }
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable String id, @RequestBody Person person) {

        Person personToUpdate = personRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person with id " + id + " not found"));

        person.setId(id);

        if( person.getEmail() != null) {
            personToUpdate.setEmail(person.getEmail());
        }

        if( person.getFirstName() != null) {
            personToUpdate.setFirstName(person.getFirstName());
        }

        if( person.getLastName() != null) {
            personToUpdate.setLastName(person.getLastName());
        }

        return personRepository.save(personToUpdate);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person with id " + id + " not found"));
        personRepository.delete(person);
    }

}
