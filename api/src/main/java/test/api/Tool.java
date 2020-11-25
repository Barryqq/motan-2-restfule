package test.api;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qbs
 * @version 1.0
 * @date 2020/11/23 15:39
 */
public class Tool {
    public static void main(String[] args) throws Exception {
// 文件目录
        String path = "D:\\sinosoft\\Taiping\\code\\netCode\\m-c-agg";
// 指定字符串
        String content = "@MotanService";
        list(path,content);
    }
    public static void list(String sourcePath,String content) throws Exception {
        File file = new File(sourcePath);
// 递归获取源文件夹下的所有文件全路径
        List<String> list = filesDirs(file, new ArrayList<>());
// 遍历判断文件是否含有某个字符串
        for(String path:list){
            checkContainsString(path,content);
        }
    }
    /***
     * 递归遍历文件夹及子文件夹中所有文件
     * @param file 文件
     * @param pathList 所有文件全路径集合
     * @return 返回所有文件的全路径
     * @throws Exception
     */
    public static List<String> filesDirs(File file, List<String> pathList) throws Exception {
        if(file != null){
            if(file.isDirectory()){
                File[] files = file.listFiles();
                for(File f:files) {
                    filesDirs(f,pathList);
                }
            }else{
                pathList.add(file.toString());
            }
        }
        return pathList;
    }
    /**
     * 判断文件是否含有某个字符串
     * @param path 文件路径
     * @param content 指定字符串
     * @return 包含返回true，否则返回false
     * @throws IOException
     */
    public static Boolean checkContainsString(String path,String content) throws IOException {
        File file = new File(path);
        InputStreamReader read = new InputStreamReader(new FileInputStream(file),"UTF-8");//考虑到编码格式
        BufferedReader bufferedReader = new BufferedReader(read);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
//指定字符串判断处
            if (line.contains(content)) {
                //System.out.println(line);
                System.out.println(path);
                return true;
            }
        }
        return false;
    }
}
