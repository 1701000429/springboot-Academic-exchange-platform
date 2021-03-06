package com.cqupt.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <p>
 *  Md5加密
 * </p>
 *
 * @author 刘博文
 * @since 2022-02-08
 */
public class MD5Utils {

    /**
     * @Description: MD5加密
     * @Param: 要加密的字符串
     * @Return: 加密后的字符串
     */
    public static String code(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[]byteDigest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
            // 16位的加密
            //return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static String stringNstring(String source) {
        //String source = "啊啊啊啊啊啊啊啊啊啊哦哦哦哦哦哦哦哦哦哦哦呵呵呵呵呵呵呵呵呵呵";
        String t="";

        for(int i=0;i<source.length();i++){
            t+="\n";
            t+=source.substring(i,i+1);
        }
        //System.out.println(t);
        return t;
    }

    public static void main(String[] args) {
        System.out.println(code("123456"));
    }
}