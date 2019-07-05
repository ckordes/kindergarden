package pl.coderslab.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Person;
import pl.coderslab.repository.PersonRepository;

@Service
public class AuthenticationService {

    @Autowired
    PersonRepository personRepository;

    public boolean givenEmailExistInDatabase(String email){
        Person person = personRepository.findByEmail(email);
        if (person==null){
            return false;
        }
        return true;
    }

    public Person checkPasswordForUser(String email, String password){
        Person person = personRepository.findByEmail(email);
        if (person==null){
            return null;
        }
        boolean equalPassword = password.equals(person.getPassword());
//        boolean equalPassword = BCrypt.checkpw(password, person.getPassword());
        if (equalPassword) {
            return person;
        }
        return null;
    }
}
