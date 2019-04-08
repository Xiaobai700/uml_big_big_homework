package cn.njupt.rest_reservation.javademo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangqiao on 2019/4/7.
 */
public class FileVisitorDemo{
    public static void main(String[] args)throws IOException{
        /*//默认取得文档
        String glob = args.length == 0 ? "*" :args[0];
        //取得目前工作路径
        Path userpath = Paths.get(System.getProperty("user.dir"));
        try(DirectoryStream<Path> directoryStream =
                    Files.newDirectoryStream(userpath,glob)) {

        }*/
        List<String> paths = new ArrayList<>();
        paths = getAllFilePaths(new File("E:\\成绩管理系统导出文件\\学生成绩汇总"),paths);
        for (String path:paths) {
            System.out.println(path);
        }

    }
    //列出给定目录下的文件信息
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
