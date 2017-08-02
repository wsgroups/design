package com.design.command.chain;

/**
 * 描述
 * User: shuai
 * Date: 2017/8/2  Time: 20:13
 */
public class FileManager {

    public static String ls(String path){
        return "file\nfile2\nfile3\nfile4";
    }

    public static String ls_l(String path){
        String str = "dwr-rw-rw root system 1024 2009-08-01 10:23 file1\n";
        str = str + "dwr-rw-rw root system 1024 2009-08-01 10:23 file2\n";
        str = str + "dwr-rw-rw root system 1024 2009-08-01 10:23 file3\n";
        return str;
    }

    public static String ls_a(String path){
        String str = ".\n..\nfile1\nfile2\nfile3";
        return str;
    }
}
