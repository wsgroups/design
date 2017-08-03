package com.design.command.chain;

/**
 * 描述
 * User: shuai
 * Date: 2017/8/3  Time: 21:36
 */
public class Invoker {

    public String exec(String _commandStr){
        String result = "";
        CommandVO vo = new CommandVO(_commandStr);
        if(CommandEnum.getNames().contains(vo.getCommandName())){
            String className = CommandEnum.valueOf(vo.getCommandName()).getValue();
        }
        return result;
    }
}
