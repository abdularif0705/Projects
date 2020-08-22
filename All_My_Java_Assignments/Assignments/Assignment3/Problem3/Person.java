package Problem3;
/**
 This class represents a person with a name.
 */
public class Person implements Comparable {
    private String name;

    /**
     Constructs a person object
     @param name the person's name
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     Gets the person's name
     @return the name
     */
    public String getName() { return name; }

    /**
     Compares person objects.
     @param other Other person against which to compare
     @return -1 if this person comes before, 0 if equal, 1 if this person comes after
     */
    public int compareTo(Object other) {
        Person otherPerson = (Person) other;

        return name.compareTo(otherPerson.name);
    }
}