package mockitexamples;


  class Person {
    private final int id; 
    private final String name; 
    public Person(int id, String name) { 
        this.id = id; 
        this.name = name; 
        } 
    public int getId() { 
        return id; 
        } 
    public String getName() { 
        return name; 
        }
}


public interface PersonDao {
    Person getPerson(int id); 
    boolean update(Person person); 
    }

  class PersonService {
    private final PersonDao personDao; 
    public PersonService(PersonDao personDao) { 
        this.personDao = personDao; 
        } 
    public boolean update(int id, String name) { 
        Person person = personDao.getPerson(id); 
        if (person == null) 
        { return false; } 
        Person personUpdate = new Person(person.getId(), name); 
        return personDao.update(personUpdate); 
        }
}
