package cn.njupt.rest_reservation.javademo;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangqiao on 2019/4/7.
 */
public class NIO2Demo {
    public  static void main(String[] args)throws IOException{
        try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(args[0]))){
            List<String> files = new ArrayList<>();
            for (Path path:directoryStream) {
                if(Files.isDirectory(path)){
                    System.out.printf("[%s]%n",path.getFileName());
                }else {
                    files.add(path.getFileName().toString());
                }
            }
            for(int i = 0; i < files.size();i++){
                System.out.println(files.get(i).toString());
            }
        }
        /*Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
        for (Path dir:dirs) {
            System.out.println(dir.getRoot());
        }*/
    }
}
