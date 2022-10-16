package Casting;

public class Parent {
    public String firstName = "ko";
    public String lastName = "seyun";

    public void setFirstName(String firstName){
        this.firstName = firstName;
        System.out.println(firstName);
    }
    public void setLastName(){
        this.lastName = lastName;
        System.out.println(lastName);
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void getFullName(){
        System.out.println(getFirstName() + getLastName());
    }
}
