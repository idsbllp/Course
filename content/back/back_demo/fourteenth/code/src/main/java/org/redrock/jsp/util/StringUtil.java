package org.redrock.jsp.util;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtil {

    /**
     * md5加密   http://blog.csdn.net/wf1154439/article/details/44619535
     * 单向加密，http://www.cmd5.com/
     * md5是单向加密，理论上是不能反转解密的，但是存在暴力破解，比如将md5明文于密文做映射直接存数据库的，据说用了160T的硬盘，直接通过查库获取明文，直接md5加谜的方式已经不安全了
     * 上面那个网站有针对不同md5加密方式的解密，里面加密有salt这个字段，你知道那是干甚么的吗
     * @param password
     * @return
     */
    public static String md5(String password) {
        String result = null;
        try {
            //信息摘要
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());
            //加密后的数据是byte数组
            byte[] data = messageDigest.digest();
            //将结果转为16进制的字符串
            result = new BigInteger(1, data).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 检查是否有无效字符串
     * 仔细看下如何传入相同格式的不定数目的参数
     * @param params
     * @return
     */
    public static boolean hasBlank(String... params) {
        for (String param : params) {
            if (param == null || param.trim().equals("")) return true;
        }
        return false;
    }
}
