package fit5171.monash.edu;
/*
* Person When a person is being created or returned, test following:
*
1. All fields of a Person class are required to create a person.
*
2. The gender field has following options ‘Woman’, ‘Man’,’Non-binary|gender diverse’,
* ‘Prefer not to say’ and ‘Other’.
*
3. The first name and last name should not start with a number or symbol and
* can contain only small case and upper-case alphabet letters.
* */
public abstract class Person //abstract class Person
{
    private String firstName;
    private String secondName;
    private int age;
    private String gender;

    public Person(){}

    public Person(String firstName, String secondName, int age, String gender){
        this.setFirstName(firstName);
        this.setSecondName(secondName);
        this.setAge(age);
        this.setGender(gender);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age <= 0) {
            throw new IllegalArgumentException("Age cannot be negative or zero!");
        }
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    //2. The gender field has following options ‘Woman’, ‘Man’,
    // ’Non-binary|gender diverse’, ‘Prefer not to say’ and ‘Other’.
    public void setGender(String gender) {
        if(gender == null || gender.trim().equals("") || !gender.equals("Man") && !gender.equals("Woman") && !gender.equals("Non-binary|gender diverse")
                && !gender.equals("Prefer not to say") && !gender.equals("Other")) {
            throw new IllegalArgumentException("Invalid gender field value!");
        }
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    //3. The first name and last name should not start with a number or symbol
    // and can contain only small case and upper-case alphabet letters
    public void setFirstName(String firstName) {
        if(firstName == null || firstName.trim().equals("") || !firstName.matches("^[a-zA-Z]*$")) {
            throw new IllegalArgumentException("Name cannot start with a digit or symbol!");
        }
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        if(secondName == null || secondName.trim().equals("") || !secondName.matches("^[a-zA-Z]*$")) {
            throw new IllegalArgumentException("Name cannot start with a digit or symbol!");
        }
        this.secondName = secondName;
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
