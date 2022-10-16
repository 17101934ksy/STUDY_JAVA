package InterfaceExample.toy1;

import java.util.ArrayList;
import java.util.List;

public class StudentClassmateBatch {


    public List classmateBatch(List<Integer> list){

        int grade = 1000;
        int batch = 10;

        List<String> studentList = new ArrayList<String>();
        for (int i : list){
            for (int j = 0; j <= i; j++){
                String studentId = String.format("%06d", grade + batch + j);
                studentList.add(studentId);
            }
        }

        return studentList;
    }
}
