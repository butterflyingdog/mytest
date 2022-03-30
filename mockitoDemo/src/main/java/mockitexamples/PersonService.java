package mockitexamples;

public class PersonService {
    private final PersonDao mPersonDao; 
    public PersonService(PersonDao personDao) { 
        this.mPersonDao = personDao; 
        } 
    public boolean update(int id, String name) { 
        Person person = mPersonDao.getPerson(id); 
        if (person == null) 
        { return false; } 
        Person personUpdate = new Person(person.getId(), name); 
        return mPersonDao.update(personUpdate); 
    }

    public Person getPerson(int id){
        return mPersonDao.getPerson(id);
    }
}
