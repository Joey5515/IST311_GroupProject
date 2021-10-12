/**
 * Header
 */


public class Speaker extends Person {
    private String title, organization, address, email, city, speechDate, invitee, spring, summer1, summer2, fall, giftType;

    private Boolean inPerson, permitMailed, prevGift;

    /**
     * Constructor
     */
    public Speaker() {
        super();
        title = "";
        organization = "";
        //do this for all the strings and booleans
    }

    /**
     * Constructor
     */
    public Speaker(String first, String last, String titl, String org) {
        super(first, last);
        title = titl;
        organization = org;
    }


    /**
     *
     * @return toString for Speaker
     */
    public String toString() {
        //create toString
        return  title + " " + super.toString() + ", " + organization;
    }

    //**********getters***********
    /**
     *  getter
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * getter
     * @return
     */
    public String getOrganization() {
        return organization;
    }




    //**********setters***********

    /**
     * setter
     * @param titl
     */

    public void setTitle(String titl) { titl = title; }

    /**
     * setter
     * @param org
     */
    public void setOrganization(String org) { org = organization; }
}
