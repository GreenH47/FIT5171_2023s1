package fit5171.monash.edu;

/*
* When a passenger is being created or returned, test following:
*
1. All fields of a passenger are required.Note: Mock the behavior of
* the Person class while creating objects of the Passenger class for unit testing.
*
2. Phone number follows a pattern. Within Australia, mobile phone numbers begin
* with 04 or 05 – the Australian national trunk code" 0, plus the mobile indicator 4 or 5,
* then followed by eight digits. This is generally written as 04XX XXX XXX within Australia
* or as +61 4XX XXX XXX for aninternational audience.
*
3. The email follows a valid pattern “abc@domain.com”.
*
4. The passport number should not be more than 9 characters long.
*
5. When a passenger is being added, it must include the passenger’s First name,
* Last Name, age,and gender following the person who is becoming a passenger
* */
public class Passenger extends Person
{
    private String email;
    private String phoneNumber;
    private String cardNumber;
    private int securityCode;
    private String passport;

    public Passenger(){}

//    public Passenger(Person person, String email, String phoneNumber, String cardNumber, String passport)
//    {
//        super(person.getFirstName(), person.getSecondName(), person.getAge(), person.getGender());
//        this.setSecurityCode(securityCode);
//        this.setCardNumber(cardNumber);
//        this.setPassport(passport);
//        this.setEmail(email);
//        this.setPhoneNumber(phoneNumber);
//    }

    public Passenger(String firstName, String secondName, int age, String gender,String email, String phoneNumber, String cardNumber, String passport,int securityCode)
    {
        //super(person.getFirstName(), person.getSecondName(), person.getAge(), person.getGender());
        super(firstName, secondName, age, gender);
        this.setSecurityCode(securityCode);
        this.setCardNumber(cardNumber);
        this.setPassport(passport);
        this.setEmail(email);
        this.setPhoneNumber(phoneNumber);
    }



    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        //set email validation
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9-]+\\.com$")) {
            throw new IllegalArgumentException("Invalid email address format");
        }
        this.email = email;
    }

    public String getFirstName() {
        return super.getFirstName();
    }

    public String getSecondName() {
        return super.getSecondName();
    }

    public void setSecondName(String secondName) {
        super.setSecondName(secondName);
    }

    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    public String getPassport() {
        return passport;
    }

    public void setGender(String gender) {
        super.setGender(gender);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        if (cardNumber == null) {
            throw new IllegalArgumentException("Card number must be 9 digits");
        }
        this.cardNumber = cardNumber;
    }

    public void setSecurityCode(int securityCode) {
        String str = String.valueOf(securityCode);
        if (str == null || str.length() != 3) {
            throw new IllegalArgumentException("Card number must be 3 digits");
        }
        this.securityCode = securityCode;
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    public void setPassport(String passport) {
        if (passport == null || passport.length() > 9) {
            throw new IllegalArgumentException("Passport number must be less than or equal to 9 digits");
        }
        this.passport = passport;
    }

    @Override
    public String getGender() {
        return super.getGender();
    }

    public void setPhoneNumber(String phoneNumber) {
        //set phonenumber validation
//        if (phoneNumber == null || !phoneNumber.replaceAll("\\s","").matches("^(04|05)[0-9]{8}$") ) {
//            throw new IllegalArgumentException("Invalid phone number format");
//        }

        if (phoneNumber == null || !phoneNumber.replaceAll("\\s","").matches("^(?:\\+?(61))? ?(?:\\((?=.*\\)))?(0?[2-57-8])\\)? ?(\\d\\d(?:[- ](?=\\d{3})|(?!\\d\\d[- ]?\\d[- ]))\\d\\d[- ]?\\d[- ]?\\d{3})$") ) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public String toString()
    {
        return "Passenger{" + " Fullname= "+ super.getFirstName()+" "+super.getSecondName()+
                " ,email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", passport='" + passport +
                '}';
    }
}
