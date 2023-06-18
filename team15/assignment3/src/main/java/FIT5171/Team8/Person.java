package FIT5171.Team8;

//huang's allocation
public class Person {
    private String firstName;
    private String secondName;
    private int age;
    private String gender;

    public Person(){}

    public Person(String firstName, String secondName, int age, String gender){
        this.age=age;
        this.firstName=firstName;
        this.secondName=secondName;
        this.gender=gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        if (!isValidGender(gender)) {
            throw new IllegalArgumentException("Invalid gender. Gender should be one of the following: 'Woman', 'Man', 'Non-binary|gender diverse', 'Prefer not to say', 'Other'");
        }
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setFirstName(String firstName) {
        if(firstName.matches("^[A-Za-z][A-Za-z]*$")) {
            this.firstName = firstName;
        }
        else {
            throw new IllegalArgumentException("First name should contain only small case and upper-case alphabet letters and should not start with a number or symbol.");
        }
    }

    public void setSecondName(String secondName) {
        if (!secondName.matches("^[A-Za-z][A-Za-z]*$")) {
            throw new IllegalArgumentException("Last name should contain only small case and upper-case alphabet letters and should not start with a number or symbol.");
        }
        this.secondName = secondName;
    }

    public boolean isValidGender(String gender) {
        String[] validGenders = {"Woman", "Man", "Non-binary|gender diverse", "Prefer not to say", "Other"};
        boolean isValid = false;
        for (String validGender : validGenders) {
            if (gender.equals(validGender)) {
                isValid = true;
                break;
            }
        }
        return isValid;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
