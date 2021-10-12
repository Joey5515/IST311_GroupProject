/**
 * Header
 */
public class Person {
    private String firstName, lastName;

    /**
     * Constructor which initializes the values of firstName and lastName to blanks
     */
    public Person() {
        firstName = "";
        lastName = "";
    }

    /**
     * Constructor which sets the values of firstName and lastName to
     * @param first = sets firstName value
     * @param last = sets lastName value
     */
    public Person(String first, String last) {
        firstName = first;
        lastName = last;
    }


    /**
     * Returns the value in the variable lastName
     * @return
     */
    public String getFirstName() {
        return firstName;
    }


    /**
     * Passes value to be assigned to the variable firstName
     * @param first
     */
    public void setFirstName(String first) {
        firstName = first;
    }


    /**
     * Returns the value in the variable lastName
     * @return
     */
    public String getLastName() {
        return lastName;
    }


    /**
     * Passes value to be assigned to the variable lastName
     * @param last
     */
    public void setLastName(String last) {
        lastName = last;
    }

    /**
     * Returns firstName and lastName as a concatenated string
     * @return
     */
    public String toString() {
        return firstName + " " + lastName;
    }


}