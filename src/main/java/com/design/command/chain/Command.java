package com.design.command.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 * User: shuai
 * Date: 2017/8/2  Time: 21:43
 */
public abstract class Command {

    public abstract String execute(CommandVO vo);

    protected final List<? extends CommandName> buildChain(Class<? extends CommandName> abstractClass){

        List<Class> classes = ClassUtils.getSonClass(abstractClass);

        List<CommandName> commandNameList = new ArrayList<CommandName>();
        for(Class c : classes){
            CommandName commandName = null;
            try {
                commandName = (CommandName) Class.forName(c.getName()).newInstance();
            }catch (Exception e){}

            if (commandNameList.size() > 0){
                commandNameList.get(commandNameList.size() - 1).setNext(commandName);
            }
            commandNameList.add(commandName);
        }

        return commandNameList;
    }
}
