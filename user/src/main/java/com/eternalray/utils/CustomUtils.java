package com.eternalray.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.UUID;

/**
 * @Author: Eternalray
 */
public class CustomUtils {

    /**
     * 获取UUID
     * @return
     */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        return uuid;
    }

    /**
     * 获取加密MD5值
     * @param text   待加密明文串
     * @param key   秘匙
     * @return 密文
     */
    public static String getTextMD5(String text,String key){
        String encText = DigestUtils.md5Hex(text + key);
        return encText;
    }

    /**
     * 验证MD5值
     * @param text
     * @param key
     * @param md5Text
     * @return
     */
    public static boolean verifyTextMD5(String text, String key, String md5Text){
        String md5TextTemp = getTextMD5(text, key);
        if(md5Text.equalsIgnoreCase(md5TextTemp)){
            return true;
        }
        return false;
    }
}
