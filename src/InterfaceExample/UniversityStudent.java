package InterfaceExample;

public class UniversityStudent implements Student{
    public String name;
    public Long id;

    @Override
    public void goToSchool() {
        System.out.println("go to School");
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
