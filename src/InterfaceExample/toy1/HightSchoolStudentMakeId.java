package InterfaceExample.toy1;

import java.time.temporal.ValueRange;

public class HightSchoolStudentMakeId implements StudentMakeId{
    static int studentId;
    static int maxId;

    @Override
    public void setId(int studentId, int max) {
        this.studentId = studentId;
        this.maxId = max;
    }

    @Override
    public String getId() {
//        return String.format("%06d", studentId);
//        String studentId1 = String.valueOf(studentId);
        return String.format("%06d", studentId);
    }

    @Override
    public int makeId() {
        if (studentId <= maxId){ return ++studentId; }
        return 0;
    }
}
