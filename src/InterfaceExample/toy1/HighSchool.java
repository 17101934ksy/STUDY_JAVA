package InterfaceExample.toy1;

import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class HighSchool<T, V> implements School<T, V> {
    public int schoolId = SchoolNumber.setSchoolNumber();
    public String name;
    public Set studentSet = null;
    public Set classSet = null;

    static int schoolNumber = 0;

    public HighSchool(String name){
        this.name = name;
    }

    @Override
    public int getSchoolId() { return schoolId;}

    @Override
    public void setName(String name) { this.name = name; }

    @Override
    public String getName() { return name; }

    @Override
    public void addStudentSet(T t) {
        studentSet.add(t);
    }

    @Override
    public Set getStudentSet() {
        return studentSet;
    }

    @Override
    public void setClassSet(V v) {
        classSet.add(v);
    }

    @Override
    public Set getClassSet() {
        return classSet;
    }
}
