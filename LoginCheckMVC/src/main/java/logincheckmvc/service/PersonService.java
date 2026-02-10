package logincheckmvc.service;

import logincheckmvc.dao.PersonDao;
import logincheckmvc.model.Person;

public class PersonService {

    private PersonDao dao = new PersonDao();

    // Business logic for login
    public boolean login(String username, String password) {
        return dao.validate(username, password);
    }

    // Business logic for registration
    public boolean register(Person p) {

        // Example business rule (you can add more later)
        if (p.getUsername() == null || p.getUsername().length() < 3) {
            return false;
        }

        return dao.register(p);
    }
}
