package com.common.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/5/29
 * @Description: com.common.util
 * @version: 1.0
 */
public class PinYinUtils {

    /**
     * 获取汉字首字母或全拼大写字母
     * @param hanZi     汉字
     * @param isFull    是否全拼    true:是  false:否
     * @return          全拼或首字母大写字符串
     */
    public static String getUpperCase(String hanZi,boolean isFull){
        return convertHanzi2Pinyin(hanZi,isFull,true);
    }

    /**
     * 获取汉字首字母或全拼小写字母
     * @param hanZi     汉字
     * @param isFull    是否全拼    true:是  false:否
     * @return          全拼或首字母小写字符串
     */
    public static String getLowerCase(String hanZi,boolean isFull){
        return convertHanzi2Pinyin(hanZi,isFull,false);
    }

    /**
     * 将汉字转成拼音
     *
     * @param hanZi   汉字
     * @param isFull  是否全拼    true:全拼   false:首字母
     * @param isUpper 是否大写    true:是     false:否
     * @return
     */
    public static String convertHanzi2Pinyin(String hanZi, boolean isFull, boolean isUpper) {

        /**
         * ^[\u2E80-\u9FFF]+$ 匹配所有东亚区的语言
         * ^[\u4E00-\u9FFF]+$ 匹配简体和繁体
         * ^[\u4E00-\u9FA5]+$ 匹配简体
         */
        String regExp = "^[\u4E00-\u9FFF]+$";
        StringBuffer sb = new StringBuffer();
        if (null == hanZi || "".equals(hanZi.trim())) {
            return "";
        }

        for (int i = 0; i < hanZi.length(); i++) {
            char unit = hanZi.charAt(i);
            //是汉字
            if (match(String.valueOf(unit), regExp)) {
                String pinyin = convertSingleHanzi2Pinyin(unit, isUpper);
                if (isFull) {
                    sb.append(pinyin);
                } else {
                    sb.append(pinyin.charAt(0));
                }
            } else {
                sb.append(unit);
            }
        }

        if (isUpper) {
            return sb.toString().toUpperCase();
        }
        return sb.toString();

    }


    /**
     * 单个汉字转拼音
     *
     * @param hanZi   汉字
     * @param isUpper 是否大写
     * @return 拼音
     */
    public static String convertSingleHanzi2Pinyin(char hanZi, boolean isUpper) {
        HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
        outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        String[] res;
        StringBuffer sb = new StringBuffer();
        try {
            res = PinyinHelper.toHanyuPinyinStringArray(hanZi, outputFormat);
            sb.append(res[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

        //大写
        if (isUpper) {
            return sb.toString().toUpperCase();
        }
        return sb.toString();
    }

    /**
     * @param str   源字符
     * @param regex 正则表达式
     * @return 若有部分字符满足正则表达式，则返回true；无满足正则表达式的则返回false
     */
    public static boolean match(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    public static void main(String[] arg){
        System.err.println(getUpperCase("发现好零食_香香榴莲饼/++/330g",false));
    }
}
