package model;

public record ContactDate(String firstname, String lastname, String address, String mobile, String email ) {
    public ContactDate() {
        this("", "", "", "","");
    }
    public ContactDate withFirstname(String firstname) {
        return new ContactDate(firstname, this.lastname, this.address, this.mobile, this.email);
    }
    public ContactDate withLastname(String lastname) {
        return new ContactDate(this.firstname, lastname, this.address, this.mobile, this.email);
    }
    public ContactDate withAddress(String address) {
        return new ContactDate(this.firstname, this.lastname, address, this.mobile, this.email);
    }
    public ContactDate withMobile(String mobile) {
        return new ContactDate(this.firstname, this.lastname, this.address, mobile, this.email);
    }
    public ContactDate withEmail(String email) {
        return new ContactDate(this.firstname, this.lastname, this.address, this.mobile, email);
    }
}