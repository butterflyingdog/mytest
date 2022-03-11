package mockitexamples;

public class PersonFacade {
    private PersonService personService;

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public Person getPerson(int id){
        return personService.getPerson(id);
    }
}
