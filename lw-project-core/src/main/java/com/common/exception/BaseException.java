package com.common.exception;

import com.lw.constants.ErrEnum;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/5/14
 * @Description: com.common.exception
 * @version: 1.0
 *
 * 异常类
 */
public class BaseException extends RuntimeException{

    private String code;
    private String msg;

    public BaseException(){
        super();
    }

    public BaseException(String msg){
        super(msg);
        this.msg=msg;
    }

    public BaseException(Throwable e){
        super(e);
    }

    public BaseException(String code,String msg){
        super(msg);
        this.code=code;
        this.msg=msg;
    }

    public BaseException(String msg,Throwable e){
        super(msg,e);
        this.msg=msg;
    }

    public BaseException(String code,String msg,Throwable e){
        super(msg,e);
        this.code=code;
        this.msg=msg;
    }

    public BaseException(ErrEnum errEnum,Throwable e){
        this(errEnum.getCode(),errEnum.getMsg(),e);
    }

    public BaseException(ErrEnum errEnum){
        this(errEnum.getCode(),errEnum.getMsg());
    }

    public BaseException(ErrEnum errEnum,Object...args){
        this(errEnum.getCode(),String.format(errEnum.getMsg(),args));
    }

    public String getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }

}
