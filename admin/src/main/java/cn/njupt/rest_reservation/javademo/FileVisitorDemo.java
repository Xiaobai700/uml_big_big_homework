package cn.njupt.rest_reservation.javademo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangqiao on 2019/4/7.
 */
public class FileVisitorDemo{
    public static  void main(String[] args){
        List<String> paths = new ArrayList<>();
        paths = getAllFilePaths(new File("E:\\成绩管理系统导出文件"),paths);
        for (String path:paths) {
            System.out.println(path);
        }

    }
    private static List<String> getAllFilePaths(File filePath,List<String> filePaths){
        File[] files = filePath.listFiles();
        if(files == null){
            return  filePaths;
        }
        for (File f:files){
            if(f.isDirectory()){
                filePaths.add(f.getPath());
                getAllFilePaths(f,filePaths);

            }else {
                filePaths.add(f.getPath());
            }
        }
        return  filePaths;
    }
}
