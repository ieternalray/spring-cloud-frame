package com.eternalray.common;

/**
 * @Author: Eternalray
 * 自定义的工具类
 */
public class CustomUtils {
    /**
     * 字符串是否以符合规则字符串开头
     * @param str       需要判断的字符串
     * @param ruleStr   规则字符串(可用,分开组合多个规则)
     * @return
     */
    public static boolean isStartWith(String str,String ruleStr) {
        boolean flag = false;
        String regexStr=",";
        for (String s : ruleStr.split(regexStr)) {
            if (str.startsWith(s)) {
                return true;
            }
        }
        return flag;
    }
}
