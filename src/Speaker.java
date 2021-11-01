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

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getSpeechDate() {
        return speechDate;
    }

    public String getInvitee() {
        return invitee;
    }

    public String getSpring() {
        return spring;
    }

    public String getSummer1() {
        return summer1;
    }

    public String getSummer2() {
        return summer2;
    }

    public String getFall() {
        return fall;
    }

    public String getGiftType() {
        return giftType;
    }

    public Boolean getInPerson() {
        return inPerson;
    }

    public Boolean getPermitMailed() {
        return permitMailed;
    }

    public Boolean getPrevGift() {
        return prevGift;
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


    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setSpeechDate(String speechDate) {
        this.speechDate = speechDate;
    }

    public void setInvitee(String invitee) {
        this.invitee = invitee;
    }

    public void setSpring(String spring) {
        this.spring = spring;
    }

    public void setSummer1(String summer1) {
        this.summer1 = summer1;
    }

    public void setSummer2(String summer2) {
        this.summer2 = summer2;
    }

    public void setFall(String fall) {
        this.fall = fall;
    }

    public void setGiftType(String giftType) {
        this.giftType = giftType;
    }

    public void setInPerson(Boolean inPerson) {
        this.inPerson = inPerson;
    }

    public void setPermitMailed(Boolean permitMailed) {
        this.permitMailed = permitMailed;
    }

    public void setPrevGift(Boolean prevGift) {
        this.prevGift = prevGift;
    }
}

