package InterfaceExample.toy1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SchoolSystemMain {
    public static void main(String[] args){

        HighSchool dongbuk = new HighSchool("dongbuk");
        System.out.println(dongbuk.getSchoolId());

        HighSchool seoultech = new HighSchool("seoultech");
        System.out.println(seoultech.getSchoolId());

        HightSchoolStudentMakeId hightSchoolStudentMakeId = new HightSchoolStudentMakeId();
        hightSchoolStudentMakeId.setId(10, 30);

        System.out.println(hightSchoolStudentMakeId.getId());

        StudentClassmateBatch stcb = new StudentClassmateBatch();
        List<String> abc = stcb.classmateBatch(Arrays.asList(11, 10, 9,12));
        System.out.println(abc);
    }
}
