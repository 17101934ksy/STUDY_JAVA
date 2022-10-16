package InterfaceExample.toy1;

import java.util.Set;

public interface School<T, V> {

    int getSchoolId();

    void setName(String name);
    String getName();

    void addStudentSet(T t);
    Set getStudentSet();

    void setClassSet(V v);
    Set getClassSet();

}
