package com.design.command.chain;

/**
 * 描述
 * User: shuai
 * Date: 2017/8/2  Time: 21:59
 */
public class LSCommand extends Command {
    @Override
    public String execute(CommandVO vo) {
        CommandName firstNode = super.buildChain(AbstractLS.class).get(0);

        return firstNode.handleMessage(vo);
    }
}
