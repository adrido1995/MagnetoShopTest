package pl.testeroprogramowania.models;

public class NewCustomer {

    int random = (int) (Math.random() * 1000);

    private String firstName = "Adrian";
    private String lastName = "Tester";
    private String email = "tester" + random + "@test.pl";
    private String password = "p@ssword456";

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
