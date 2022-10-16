package Casting;

public class Daughter extends Parent{

    public String firstName;
    public String LastName;


    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    @Override
    public void setLastName() {
        super.setLastName();
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public void getFullName() {
        super.getFullName();
    }

    public void setPlusName(String plusName){
        lastName = lastName + plusName + plusName;
    }
}
