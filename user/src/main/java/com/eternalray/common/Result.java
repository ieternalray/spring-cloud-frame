package com.eternalray.common;

import lombok.Data;

/**
 * @Author: Eternalray
 * 返回结果集公用方法
 */
@Data
public class Result<T> {

    private boolean success;//返回结果
    private T data;//返回结果数据

    public static <T> Result<T> set(boolean success,T data){
        Result<T> result=new Result<>();
        result.setSuccess(success);
        result.setData(data);
        return  result;
    }
}
