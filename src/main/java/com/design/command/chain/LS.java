package com.design.command.chain;

/**
 * 描述
 * User: shuai
 * Date: 2017/8/2  Time: 20:19
 */
public class LS extends AbstractLS {
    @Override
    protected String getOperateParam() {
        return super.DEFAULT_PARAM;
    }

    @Override
    protected String echo(CommandVO vo) {
        return FileManager.ls(vo.formatData());
    }
}
