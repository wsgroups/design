package com.design.command.chain;

/**
 * 描述  命令模式 + 责任链模式
 * 抽象命令类
 * User: shuai
 * Date: 2017/8/1  Time: 21:31
 */
public abstract class CommandName {

    private CommandName nextOperator;

    //设置剩余参数由谁来处理
    public void setNext(CommandName _operator) {
        this.nextOperator = _operator;
    }

    public final String handleMessage(CommandVO vo){
        //处理结果
        String result = "";

        if(vo.getParam().size() == 0 || vo.getParam().contains(this.getOperateParam())){
            result = this.echo(vo);
        }else {
            if (this.nextOperator != null){
                result = this.nextOperator.handleMessage(vo);
            }else {
                result = "命令无法执行";
            }
        }

        return result;
    }

    //每个处理者都要处理一个后缀参数
    protected abstract String getOperateParam();


    //每个处理者都必须实现处理任务
    protected abstract String echo(CommandVO vo);

}
