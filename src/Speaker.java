/**
 * Header
 */


public class Speaker extends Person {
    private String title, organization, address, email, city, speechDate, invitee, giftType;

    private Boolean inPerson, permitMailed, prevGift;

    /**
     * Constructor
     */
    public Speaker() {
        super();
        title = "";
        organization = "";

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
        return  title + " " + super.toString() + ", " + organization;
    }

    /**
     *  getter
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * getter
     * @return organization
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * getter
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * getter
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * getter
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * getter
     * @return speechDate
     */
    public String getSpeechDate() {
        return speechDate;
    }

    /**
     * getter
     * @return invitee
     */
    public String getInvitee() {
        return invitee;
    }

    /**
     * getter
     * @return giftType
     */
    public String getGiftType() {
        return giftType;
    }

    /**
     * getter
     * @return inPerson
     */
    public Boolean getInPerson() {
        return inPerson;
    }


    /**
     * getter
     * @return permitMailed
     */
    public Boolean getPermitMailed() {
        return permitMailed;
    }

    /**
     * getter
     * @return prevGift
     */
    public Boolean getPrevGift() {
        return prevGift;
    }


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

    /**
     * setter
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * setter
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * setter
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * setter
     * @param speechDate
     */
    public void setSpeechDate(String speechDate) {
        this.speechDate = speechDate;
    }

    /**
     * setter
     * @param invitee
     */
    public void setInvitee(String invitee) {
        this.invitee = invitee;
    }

    /**
     * setter
     * @param giftType
     */
    public void setGiftType(String giftType) {
        this.giftType = giftType;
    }

    /**
     * setter
     * @param inPerson
     */
    public void setInPerson(Boolean inPerson) {
        this.inPerson = inPerson;
    }

    /**
     * setter
     * @param permitMailed
     */
    public void setPermitMailed(Boolean permitMailed) {
        this.permitMailed = permitMailed;
    }

    /**
     * setter
     * @param prevGift
     */
    public void setPrevGift(Boolean prevGift) {
        this.prevGift = prevGift;
    }
}

