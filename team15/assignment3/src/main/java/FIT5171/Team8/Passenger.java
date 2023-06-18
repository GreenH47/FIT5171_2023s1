package FIT5171.Team8;

//huang's allocation
public class Passenger extends Person {
    private String email;
    private String phoneNumber;
    private String passport;
    private String cardNumber;
    private int securityCode;

    public Passenger() {}

    public Passenger(String firstName, String lastName, int age, String gender, String email, String phoneNumber, String passport, String cardNumber, int securityCode) {
        super(firstName, lastName, age, gender);
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.passport = passport;
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))
            this.email = email;
        else throw new IllegalArgumentException("Invalid email.");
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        // Check if phone number follows the Australian pattern
        if (phoneNumber.matches("^(\\+?61|0)4\\d{8}$"))
            this.phoneNumber = phoneNumber;
        else throw new IllegalArgumentException("Invalid phone number.");
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        if (passport.length() > 9) {
            throw new IllegalArgumentException("Passport number cannot be more than 9 characters long.");
        } else if (passport.length() == 0) {
            throw new IllegalArgumentException("Passport number cannot be empty.");
        } else {
            this.passport = passport;
        }
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getSecondName() + '\'' +
                ", age=" + getAge() +
                ", gender='" + getGender() + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", passport='" + passport + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", securityCode=" + securityCode +
                '}';
    }
}
