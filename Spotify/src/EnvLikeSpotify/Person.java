package EnvLikeSpotify;

public class Person {
    private String PersonName;
    private Person next;

    public Person(String PersonName) {
        this.PersonName=PersonName;
        this.next=null;
    }

    public String getPersonName() {
        return PersonName;
    }

    public void setPersonName(String PersonName) {
        this.PersonName = PersonName;
    }

    public Person getNext() {
        return next;
    }

    public void setNext(Person next) {
        this.next = next;
    }
}
