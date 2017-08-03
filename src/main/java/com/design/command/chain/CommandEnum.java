package com.design.command.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 * User: shuai
 * Date: 2017/8/3  Time: 21:25
 */
public enum CommandEnum {

    ls("com.design.command.chain.LSCommand");

    private String value = "";

    CommandEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static List<String> getNames(){
        CommandEnum[] commandEnum = CommandEnum.values();

        List<String> names = new ArrayList<String>();
        for(CommandEnum c : commandEnum){
            names.add(c.name());
            System.out.println(c.name());
        }
        return names;
    }

    public static void main(String[] args) {
        System.out.println(getNames());
    }
}
