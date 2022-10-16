package InterfaceExample.toy1;

import java.util.List;

public class StudentIdRegisterSystem<T> implements ComputerizedRegisterSystem<T>{

    private Long schoolId;
    private List schoolStudentList;
    private List studentData;


    public StudentIdRegisterSystem(Long schoolId, List schoolStudentList, List studentData){
        this.schoolId = schoolId;
        this.schoolStudentList = schoolStudentList;
        this.studentData = studentData;
    }

    @Override
    public void setRegister(T t) {
        schoolStudentList.add(t);
    }

    @Override
    public T getRegsiter() {

        return (T) schoolStudentList;
    }
}
