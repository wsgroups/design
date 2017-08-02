package com.design.command.chain;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 描述
 * User: shuai
 * Date: 2017/8/2  Time: 20:42
 */
public class ClassUtils {

    public static List<Class> getSonClass(Class fatherClass){
        List<Class> returnClassList = new ArrayList<Class>();
        String packageName = fatherClass.getPackage().getName();

        List<Class> packClasses = getClasses(packageName);

        for(Class c : packClasses){
            if (fatherClass.isAssignableFrom(c) && !fatherClass.equals(c)){
                returnClassList.add(c);
            }
        }
        return returnClassList;
    }

    private static List<Class> getClasses(String packageName){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        String path = packageName.replace('.','/');
        Enumeration<URL> resources = null;

        try {
            resources = classLoader.getResources(path);
        }catch (IOException e){}

        List<File> dirs = new ArrayList<File>();
        while(resources.hasMoreElements()){
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }

        ArrayList<Class> classes = new ArrayList<Class>();
        for(File directory : dirs){
            classes.addAll(findClasses(directory,packageName));
        }
        return classes;
    }

    private static List<Class> findClasses(File directory, String packageName){
        List<Class> classes = new ArrayList<Class>();
        if (!directory.exists()){
            return classes;
        }

        File[] files = directory.listFiles();
        for(File file : files){
            if (file.isDirectory()){
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            }else if(file.getName().endsWith(".class")){
                try {
                    classes.add(Class.forName(packageName + '.' + file.getName().substring(0,file.getName().length() - 6)));
                } catch (ClassNotFoundException e) {

                }
            }
        }
        return classes;
    }
}
