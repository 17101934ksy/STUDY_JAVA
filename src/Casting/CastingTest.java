package Casting;

public class CastingTest {

    public static void main(String[] args){
        Parent p1 = new Parent();
        Parent s1 = new Son();
        Parent d1 = new Daughter();
        String str1 = "100";
        Man man = new Man();

        Son s2 = new Son();
        Daughter d2 = new Daughter();

        p1.getFullName();
        s1.getFullName();
        d1.getFullName();

        s2.setPlusName("test");
        s2.getFullName();

        Parent p = (Parent) s2;

        p.getFullName();

        IsParent.isParent(s2);


    }


}
