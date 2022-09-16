package InterfaceExample;

public class StudentMain {
    public static void main(String[] args){

        Student student1 = new UniversityStudent();
        UniversityStudent student2 = new UniversityStudent();

        student1.setId(102L);
        student2.setId(103L);

        System.out.println(student1.getId());
        System.out.println(student2.getId());

    }
}
