package mycode;

public class PersonFacade {
    private PersonService mPersonService;

    public PersonFacade(PersonService personService) {
        this.mPersonService = personService;
    }



    public void setPersonService(PersonService personService) {
        this.mPersonService = personService;
    }

    public Person getPerson(int id){
        return mPersonService.getPerson(id);
    }
}
