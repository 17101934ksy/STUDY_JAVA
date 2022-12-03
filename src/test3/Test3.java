package test3;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Test3 {

    public static void main(String[] args) {

        List<String> folders = Arrays.asList("/home/koseyun/IdeaProjects/capston/main/source/storage/12/test2", "/home/koseyun/IdeaProjects/capston/main/source/storage/12/test3");

        String path = "/home/koseyun/IdeaProjects/capston/main/source/storage/12" ;

        File folder = new File(path);
        File[] folder_list = folder.listFiles();

        for (File file : folder_list) {
            System.out.println("folder = " + file.getPath());
        }

        boolean flag = false;
        
//        for (File file : folder_list) {
//
//            for (int i=0; i<folders.size(); i++) {
//                if (file.getPath().equals(folders.get(i))) {
//                    flag = true;
//                    break;
//                }
//            }
//
//            if (!flag) {
//                System.out.println("file.getPath() = " + file.getPath());
//
//                try {
//                    int cnt = 0;
//                    while(file.exists()) {
//                        cnt ++;
//                        if (cnt > 2000) {
//                            break;
//                        }
//
//                        File[] toDeleteFolder = file.listFiles(); //파일리스트 얻어오기
//
//                        for (int j = 0; j < toDeleteFolder.length; j++) {
//                            toDeleteFolder[j].delete(); //파일 삭제
//
//                        }
//
//                        if(toDeleteFolder.length == 0 && file.isDirectory()){
//                            file.delete(); //대상폴더 삭제
//                        }
//                    }
//                } catch (Exception e) {
//                    e.getStackTrace();
//                }
//
//            }
//
//            flag = false;
//
//        }


    }


}
